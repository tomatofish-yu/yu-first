package BLL;

import DAL.MedicineProductDAO;
import Entity.MedicineProduct;
import java.util.List;

public class MedicineProductService {

    // ���ݷ��ʶ���
    private MedicineProductDAO medicineProductDAO = new MedicineProductDAO();

    // ���ҩƷ��Ʒ��Ϣ
    public boolean addMedicineProduct(MedicineProduct product) {
        return medicineProductDAO.addMedicineProduct(product);
    }

    // ����ҩƷ��Ʒ��Ϣ
    public boolean updateMedicineProduct(MedicineProduct product) {
        return medicineProductDAO.updateMedicineProduct(product);
    }

    // ɾ��ҩƷ��Ʒ��Ϣ
    public boolean deleteMedicineProduct(int id) {
        return medicineProductDAO.deleteMedicineProduct(id);
    }

    // ����ID��ѯҩƷ��Ʒ��Ϣ
    public MedicineProduct getMedicineProductById(int id) {
        return medicineProductDAO.getMedicineProductById(id);
    }

    // ��ѯ����ҩƷ��Ʒ��Ϣ
    public List<MedicineProduct> getAllMedicineProducts() {
        return medicineProductDAO.getAllMedicineProducts();
    }
}