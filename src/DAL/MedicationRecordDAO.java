package DAL;

import Entity.MedicationRecord;
import dbUtils.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MedicationRecordDAO {

    // 获取数据库连接
    private Connection getConnection() {
        return Connect.connectMySQL();
    }

    // 添加用药记录
    public boolean addMedicationRecord(MedicationRecord record) {
        String sql = "INSERT INTO medication_records (id, member_name, medicine_id, medication_time, dose, symptoms) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, record.getId());
            pstmt.setString(2, record.getMember_name());
            pstmt.setInt(3, record.getMedicine_id());
            pstmt.setDate(4, new java.sql.Date(record.getmedication_time().getTime()));
            pstmt.setInt(5, record.getDose());
            pstmt.setString(6, record.getSymptoms());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 更新用药记录
    public boolean updateMedicationRecord(MedicationRecord record) {
        String sql = "UPDATE medication_records SET member_name=?, medicine_id=?, medication_time=?, dose=?, symptoms=? WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, record.getMember_name());
            pstmt.setInt(2, record.getMedicine_id());
            pstmt.setDate(3, new java.sql.Date(record.getmedication_time().getTime()));
            pstmt.setInt(4, record.getDose());
            pstmt.setString(5, record.getSymptoms());
            pstmt.setInt(6, record.getId());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 删除用药记录
    public boolean deleteMedicationRecord(int id) {
        String sql = "DELETE FROM medication_records WHERE id=?";
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

    // 根据ID查询用药记录
    public MedicationRecord getMedicationRecordById(int id) {
        String sql = "SELECT * FROM medication_records WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new MedicationRecord(
                    rs.getInt("id"),
                    rs.getString("member_name"),
                    rs.getInt("medicine_id"),
                    new Date(rs.getDate("medication_time").getTime()),
                    rs.getString("dose"),
                    rs.getString("symptoms")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 查询所有用药记录
    public List<MedicationRecord> getAllMedicationRecords() {
        List<MedicationRecord> records = new ArrayList<>();
        String sql = "SELECT * FROM medication_records";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                records.add(new MedicationRecord(
                    rs.getInt("id"),
                    rs.getString("member_name"),
                    rs.getInt("medicine_id"),
                    new Date(rs.getDate("medication_time").getTime()),
                    rs.getString("dose"),
                    rs.getString("symptoms")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }
}