package DAL;

import Entity.MedicineProduct;
import dbUtils.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineProductDAO {

    // 获取数据库连接
    private Connection getConnection() {
        return Connect.connectMySQL();
    }

    // 添加药品产品信息
    public boolean addMedicineProduct(MedicineProduct product) {
        String sql = "INSERT INTO medicine_products (id, manufacturer, specification) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, product.getId());
            pstmt.setString(2, product.getManufacturer());
            pstmt.setString(3, product.getSpecification());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 更新药品产品信息
    public boolean updateMedicineProduct(MedicineProduct product) {
        String sql = "UPDATE medicine_products SET manufacturer=?, specification=? WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, product.getManufacturer());
            pstmt.setString(2, product.getSpecification());
            pstmt.setInt(3, product.getId());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 删除药品产品信息
    public boolean deleteMedicineProduct(int id) {
        String sql = "DELETE FROM medicine_products WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 根据ID查询药品产品信息
    public MedicineProduct getMedicineProductById(int id) {
        String sql = "SELECT * FROM medicine_products WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new MedicineProduct(
                    rs.getInt("id"),
                    rs.getString("manufacturer"),
                    rs.getString("specification")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 查询所有药品产品信息
    public List<MedicineProduct> getAllMedicineProducts() {
        List<MedicineProduct> products = new ArrayList<>();
        String sql = "SELECT * FROM medicine_products";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                products.add(new MedicineProduct(
                    rs.getInt("id"),
                    rs.getString("manufacturer"),
                    rs.getString("specification")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}