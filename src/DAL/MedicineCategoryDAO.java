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

    // ��ȡ���ݿ�����
    private Connection getConnection() {
        return Connect.connectMySQL();
    }

    // ���ҩƷ���
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

    // ����ҩƷ���
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

    // ɾ��ҩƷ���
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

    // ����ID��ѯҩƷ���
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

    // ��ѯ����ҩƷ���
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
