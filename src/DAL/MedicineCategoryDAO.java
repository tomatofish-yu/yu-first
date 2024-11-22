package DAL;


import Entity.MedicineCategory;
import dbUtils.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineCategoryDAO {

    // 获取数据库连接
    private Connection getConnection() {
        return Connect.connectMySQL();
    }

    // 添加药品类别
    public boolean addMedicineCategory(MedicineCategory category) {
        String sql = "INSERT INTO medicine_categories (id, name, description) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, category.getId());
            pstmt.setString(2, category.getName());
            pstmt.setString(3, category.getDesription());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 更新药品类别
    public boolean updateMedicineCategory(MedicineCategory category) {
        String sql = "UPDATE medicine_categories SET name=?, description=? WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, category.getName());
            pstmt.setString(2, category.getDesription());
            pstmt.setInt(3, category.getId());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 删除药品类别
    public boolean deleteMedicineCategory(int id) {
        String sql = "DELETE FROM medicine_categories WHERE id=?";
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

    // 根据ID查询药品类别
    public MedicineCategory getMedicineCategoryById(int id) {
        String sql = "SELECT * FROM medicine_categories WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new MedicineCategory(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 查询所有药品类别
    public List<MedicineCategory> getAllMedicineCategories() {
        List<MedicineCategory> categories = new ArrayList<>();
        String sql = "SELECT * FROM medicine_categories";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                categories.add(new MedicineCategory(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}