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

    // ҩ�����
    public boolean addPurchase(Purchase purchase) {
        // ���ʱ���ӿ��
        Medicine medicine = medicineDAO.getMedicineById(purchase.getMedicine_id());
        if (medicine != null) {
            medicine.setAmount(medicine.getAmount() + purchase.getAmount());
            return medicineDAO.updateMedicine(medicine) && purchaseDAO.addPurchase(purchase);
        }
        return false;
    }

    // ҩ������

    public boolean recordMedication(MedicationRecord record) {
        // ����ҩ��ʱ���ٿ��
        Medicine medicine = medicineDAO.getMedicineById(record.getMedicine_id());
        if (medicine != null && medicine.getAmount() >= record.getDose()) {
            medicine.setAmount(medicine.getAmount() - record.getDose());
            return medicineDAO.updateMedicine(medicine);
        }
        return false;
    }


    // ���ҩ���Ƿ����
    public boolean isMedicineExpired(MedicineBox box) {
        Date today = new Date();
        return today.after(box.getExpiration_date());
    }

    // ��ȡ����ҩ��
    public List<MedicineBox> getExpiredMedicineBoxes() {
        return medicineBoxDAO.getExpiredMedicineBoxes();
    }

 // ���¹���ҩ��״̬�����ٿ��
    public boolean updateExpiredMedicineBox(MedicineBox box) {
        if (isMedicineExpired(box)) {
            box.setExpired(true);
            Medicine medicine = medicineDAO.getMedicineById(box.getId());
            if (medicine != null) {
                medicine.setAmount(0); // �������ҩ��ȫ������
                return medicineDAO.updateMedicine(medicine) && medicineBoxDAO.updateMedicineBox(box);
            }
        }
        return false;
    }

    // ��ȡ����ҩ����
    public List<Medicine> getAllMedicines() {
        return medicineDAO.getAllMedicines();
    }
}