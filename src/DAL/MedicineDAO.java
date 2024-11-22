package DAL;


import Entity.Medicine;
import dbUtils.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineDAO {

    // 获取数据库连接，这里假设您已经有了一个名为 DBConnection 的类，它提供了 getConnection() 方法
    private Connection getConnection() {
        return Connect.connectMySQL();
    }

    // 添加药品信息
    public boolean addMedicine(Medicine medicine) {
        String sql = "INSERT INTO medicines (id, name, generic_name, dosage, indications, category_name, unit, amount) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, medicine.getId());
            pstmt.setString(2, medicine.getName());
            pstmt.setString(3, medicine.getGeneric_name());
            pstmt.setString(4, medicine.getDosage());
            pstmt.setString(5, medicine.getIndications());
            pstmt.setString(6, medicine.getCategory_name());
            pstmt.setString(7, medicine.getUnit());
            pstmt.setInt(8, medicine.getAmount());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 更新药品信息
    public boolean updateMedicine(Medicine medicine) {
        String sql = "UPDATE medicines SET name=?, generic_name=?, dosage=?, indications=?, category_name=?, unit=?, amount=? WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, medicine.getName());
            pstmt.setString(2, medicine.getGeneric_name());
            pstmt.setString(3, medicine.getDosage());
            pstmt.setString(4, medicine.getIndications());
            pstmt.setString(5, medicine.getCategory_name());
            pstmt.setString(6, medicine.getUnit());
            pstmt.setInt(7, medicine.getAmount());
            pstmt.setInt(8, medicine.getId());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 删除药品信息
    public boolean deleteMedicine(int id) {
        String sql = "DELETE FROM medicines WHERE id=?";
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

    // 根据ID查询药品信息
    public Medicine getMedicineById(int id) {
        String sql = "SELECT * FROM medicines WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Medicine(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("generic_name"),
                    rs.getString("dosage"),
                    rs.getString("indications"),
                    rs.getString("category_name"),
                    rs.getString("unit"),
                    rs.getInt("amount")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 查询所有药品信息
    public List<Medicine> getAllMedicines() {
        List<Medicine> medicines = new ArrayList<>();
        String sql = "SELECT * FROM medicines";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                medicines.add(new Medicine(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("generic_name"),
                    rs.getString("dosage"),
                    rs.getString("indications"),
                    rs.getString("category_name"),
                    rs.getString("unit"),
                    rs.getInt("amount")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicines;
    }
}

