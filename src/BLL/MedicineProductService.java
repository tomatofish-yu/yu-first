package BLL;


import DAL.MedicineProductDAO;
import Entity.MedicineProduct;
import java.util.List;

public class MedicineProductService {

    // 数据访问对象
    private MedicineProductDAO medicineProductDAO = new MedicineProductDAO();

    // 添加药品产品信息
    public boolean addMedicineProduct(MedicineProduct product) {
        return medicineProductDAO.addMedicineProduct(product);
    }

    // 更新药品产品信息
    public boolean updateMedicineProduct(MedicineProduct product) {
        return medicineProductDAO.updateMedicineProduct(product);
    }

    // 删除药品产品信息
    public boolean deleteMedicineProduct(int id) {
        return medicineProductDAO.deleteMedicineProduct(id);
    }

    // 根据ID查询药品产品信息
    public MedicineProduct getMedicineProductById(int id) {
        return medicineProductDAO.getMedicineProductById(id);
    }

    // 查询所有药品产品信息
    public List<MedicineProduct> getAllMedicineProducts() {
        return medicineProductDAO.getAllMedicineProducts();
    }
}