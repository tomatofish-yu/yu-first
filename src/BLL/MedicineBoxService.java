package BLL;

import DAL.MedicineBoxDAO;
import Entity.MedicineBox;
import java.util.Date;
import java.util.List;

public class MedicineBoxService {

    // 数据访问对象
    private MedicineBoxDAO medicineBoxDAO = new MedicineBoxDAO();

    // 添加药盒信息
    public boolean addMedicineBox(MedicineBox box) {
        return medicineBoxDAO.addMedicineBox(box);
    }

    // 更新药盒信息
    public boolean updateMedicineBox(MedicineBox box) {
        return medicineBoxDAO.updateMedicineBox(box);
    }

    // 删除药盒信息
    public boolean deleteMedicineBox(int id) {
        return medicineBoxDAO.deleteMedicineBox(id);
    }

    // 根据ID查询药盒信息
    public MedicineBox getMedicineBoxById(int id) {
        return medicineBoxDAO.getMedicineBoxById(id);
    }

    // 查询所有药盒信息
    public List<MedicineBox> getAllMedicineBoxes() {
        return medicineBoxDAO.getAllMedicineBoxes();
    }

    // 检查药盒是否过期
    public boolean isMedicineBoxExpired(MedicineBox box) {
        Date today = new Date(); // 当前日期
        return today.after(box.getExpiration_date()); // 如果当前日期在过期日期之后，返回true
    }

    // 获取所有过期的药盒
    public List<MedicineBox> getExpiredMedicineBoxes() {
        return medicineBoxDAO.getExpiredMedicineBoxes();
    }

    // 获取所有即将过期的药盒（例如，30天内）
    public List<MedicineBox> getMedicineBoxesExpiringSoon(int days) {
        return medicineBoxDAO.getMedicineBoxesExpiringSoon(days);
    }
}