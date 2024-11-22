package BLL;


import DAL.MedicineDAO;
import Entity.Medicine;

import java.util.Date;
import java.util.List;

public class MedicineService {

    // ���ݷ��ʶ���
    private MedicineDAO medicineDAO = new MedicineDAO();

    // ���ҩƷ��Ϣ
    public boolean addMedicine(Medicine medicine) {
        return medicineDAO.addMedicine(medicine);
    }

    // ����ҩƷ��Ϣ
    public boolean updateMedicine(Medicine medicine) {
        return medicineDAO.updateMedicine(medicine);
    }

    // ɾ��ҩƷ��Ϣ
    public boolean deleteMedicine(int id) {
        return medicineDAO.deleteMedicine(id);
    }

    // ����ID��ѯҩƷ��Ϣ
    public Medicine getMedicineById(int id) {
        return medicineDAO.getMedicineById(id);
    }

    // ��ѯ����ҩƷ��Ϣ
    public List<Medicine> getAllMedicines() {
        return medicineDAO.getAllMedicines();
    }

  }