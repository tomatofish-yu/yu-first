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

    private Connection getConnection() {
        return Connect.connectMySQL();
    }

    // ���ҩ��-�����ϵ
    public boolean addMedicineCategory(MedicineCategory medicineCategory) {
        String sql = "INSERT INTO medicine_categories (medicine_id, category_id) VALUES (?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, medicineCategory.getMedicine_id());
            pstmt.setInt(2, medicineCategory.getCategory_id());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ����ҩ��-�����ϵ
    public boolean updateMedicineCategory(MedicineCategory medicineCategory) {
        String sql = "UPDATE medicine_categories SET medicine_id=?, category_id=? WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, medicineCategory.getMedicine_id());
            pstmt.setInt(2, medicineCategory.getCategory_id());
            pstmt.setInt(3, medicineCategory.getId());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ɾ��ҩ��-�����ϵ
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

    // ����ID��ѯҩ��-�����ϵ
    public MedicineCategory getMedicineCategoryById(int id) {
        String sql = "SELECT * FROM medicine_categories WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new MedicineCategory(
                    rs.getInt("id"),
                    rs.getInt("medicine_id"),
                    rs.getInt("category_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // ��ѯ����ҩ��-�����ϵ
    public List<MedicineCategory> getAllMedicineCategories() {
        List<MedicineCategory> medicineCategories = new ArrayList<>();
        String sql = "SELECT * FROM medicine_categories";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                medicineCategories.add(new MedicineCategory(
                    rs.getInt("id"),
                    rs.getInt("medicine_id"),
                    rs.getInt("category_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicineCategories;
    }
}