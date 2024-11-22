package BLL;


import DAL.MedicineDAO;
import Entity.Medicine;

import java.util.Date;
import java.util.List;

public class MedicineService {

    // 数据访问对象
    private MedicineDAO medicineDAO = new MedicineDAO();

    // 添加药品信息
    public boolean addMedicine(Medicine medicine) {
        return medicineDAO.addMedicine(medicine);
    }

    // 更新药品信息
    public boolean updateMedicine(Medicine medicine) {
        return medicineDAO.updateMedicine(medicine);
    }

    // 删除药品信息
    public boolean deleteMedicine(int id) {
        return medicineDAO.deleteMedicine(id);
    }

    // 根据ID查询药品信息
    public Medicine getMedicineById(int id) {
        return medicineDAO.getMedicineById(id);
    }

    // 查询所有药品信息
    public List<Medicine> getAllMedicines() {
        return medicineDAO.getAllMedicines();
    }

  }