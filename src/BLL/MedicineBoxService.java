package BLL;

import DAL.MedicineBoxDAO;
import Entity.MedicineBox;
import java.util.Date;
import java.util.List;

public class MedicineBoxService {

    // ���ݷ��ʶ���
    private MedicineBoxDAO medicineBoxDAO = new MedicineBoxDAO();

    // ���ҩ����Ϣ
    public boolean addMedicineBox(MedicineBox box) {
        return medicineBoxDAO.addMedicineBox(box);
    }

    // ����ҩ����Ϣ
    public boolean updateMedicineBox(MedicineBox box) {
        return medicineBoxDAO.updateMedicineBox(box);
    }

    // ɾ��ҩ����Ϣ
    public boolean deleteMedicineBox(int id) {
        return medicineBoxDAO.deleteMedicineBox(id);
    }

    // ����ID��ѯҩ����Ϣ
    public MedicineBox getMedicineBoxById(int id) {
        return medicineBoxDAO.getMedicineBoxById(id);
    }

    // ��ѯ����ҩ����Ϣ
    public List<MedicineBox> getAllMedicineBoxes() {
        return medicineBoxDAO.getAllMedicineBoxes();
    }

    // ���ҩ���Ƿ����
    public boolean isMedicineBoxExpired(MedicineBox box) {
        Date today = new Date(); // ��ǰ����
        return today.after(box.getExpiration_date()); // �����ǰ�����ڹ�������֮�󣬷���true
    }

    // ��ȡ���й��ڵ�ҩ��
    public List<MedicineBox> getExpiredMedicineBoxes() {
        return medicineBoxDAO.getExpiredMedicineBoxes();
    }

    // ��ȡ���м������ڵ�ҩ�У����磬30���ڣ�
    public List<MedicineBox> getMedicineBoxesExpiringSoon(int days) {
        return medicineBoxDAO.getMedicineBoxesExpiringSoon(days);
    }
}
