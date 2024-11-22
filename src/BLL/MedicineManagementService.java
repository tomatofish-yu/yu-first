package BLL;

import DAL.MedicineBoxDAO;
import DAL.PurchaseDAO;
import DAL.MedicineDAO;
import Entity.Medicine;
import Entity.Purchase;
import Entity.MedicationRecord;
import Entity.MedicineBox;
import java.util.Date;
import java.util.List;

public class MedicineManagementService {

    private MedicineDAO medicineDAO;
    private PurchaseDAO purchaseDAO;
    private MedicineBoxDAO medicineBoxDAO;

    public MedicineManagementService() {
        this.medicineDAO = new MedicineDAO();
        this.purchaseDAO = new PurchaseDAO();
        this.medicineBoxDAO = new MedicineBoxDAO();
    }

    // 药物入库
    public boolean addPurchase(Purchase purchase) {
        // 入库时增加库存
        Medicine medicine = medicineDAO.getMedicineById(purchase.getMedicine_id());
        if (medicine != null) {
            medicine.setAmount(medicine.getAmount() + purchase.getAmount());
            return medicineDAO.updateMedicine(medicine) && purchaseDAO.addPurchase(purchase);
        }
        return false;
    }

    // 药物消耗

    public boolean recordMedication(MedicationRecord record) {
        // 消耗药物时减少库存
        Medicine medicine = medicineDAO.getMedicineById(record.getMedicine_id());
        if (medicine != null && medicine.getAmount() >= record.getDose()) {
            medicine.setAmount(medicine.getAmount() - record.getDose());
            return medicineDAO.updateMedicine(medicine);
        }
        return false;
    }


    // 检查药物是否过期
    public boolean isMedicineExpired(MedicineBox box) {
        Date today = new Date();
        return today.after(box.getExpiration_date());
    }

    // 获取过期药物
    public List<MedicineBox> getExpiredMedicineBoxes() {
        return medicineBoxDAO.getExpiredMedicineBoxes();
    }

 // 更新过期药物状态并减少库存
    public boolean updateExpiredMedicineBox(MedicineBox box) {
        if (isMedicineExpired(box)) {
            box.setExpired(true);
            Medicine medicine = medicineDAO.getMedicineById(box.getId());
            if (medicine != null) {
                medicine.setAmount(0); // 假设过期药物全部出库
                return medicineDAO.updateMedicine(medicine) && medicineBoxDAO.updateMedicineBox(box);
            }
        }
        return false;
    }

    // 获取所有药物库存
    public List<Medicine> getAllMedicines() {
        return medicineDAO.getAllMedicines();
    }
}