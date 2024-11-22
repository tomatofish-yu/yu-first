package DAL;


import Entity.MedicineBox;
import dbUtils.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MedicineBoxDAO {

    // ��ȡ���ݿ�����
    private Connection getConnection() {
        return Connect.connectMySQL();
    }

    // ���ҩ����Ϣ
    public boolean addMedicineBox(MedicineBox box) {
        String sql = "INSERT INTO medicine_boxes (id, production_date, expiration_date, is_expired) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, box.getId());
            pstmt.setDate(2, new java.sql.Date(box.getProduction_date().getTime()));
            pstmt.setDate(3, new java.sql.Date(box.getExpiration_date().getTime()));
            pstmt.setBoolean(4, box.isExpired());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ����ҩ����Ϣ
    public boolean updateMedicineBox(MedicineBox box) {
        String sql = "UPDATE medicine_boxes SET production_date=?, expiration_date=?, is_expired=? WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, new java.sql.Date(box.getProduction_date().getTime()));
            pstmt.setDate(2, new java.sql.Date(box.getExpiration_date().getTime()));
            pstmt.setBoolean(3, box.isExpired());
            pstmt.setInt(4, box.getId());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ɾ��ҩ����Ϣ
    public boolean deleteMedicineBox(int id) {
        String sql = "DELETE FROM medicine_boxes WHERE id=?";
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

    // ����ID��ѯҩ����Ϣ
    public MedicineBox getMedicineBoxById(int id) {
        String sql = "SELECT * FROM medicine_boxes WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new MedicineBox(
                    rs.getInt("id"),
                    new Date(rs.getDate("production_date").getTime()),
                    new Date(rs.getDate("expiration_date").getTime()),
                    rs.getBoolean("is_expired")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // ��ѯ����ҩ����Ϣ
    public List<MedicineBox> getAllMedicineBoxes() {
        List<MedicineBox> boxes = new ArrayList<>();
        String sql = "SELECT * FROM medicine_boxes";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                boxes.add(new MedicineBox(
                    rs.getInt("id"),
                    new Date(rs.getDate("production_date").getTime()),
                    new Date(rs.getDate("expiration_date").getTime()),
                    rs.getBoolean("is_expired")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return boxes;
    }

    // ��ȡ���й��ڵ�ҩ��
    public List<MedicineBox> getExpiredMedicineBoxes() {
        List<MedicineBox> expiredBoxes = new ArrayList<>();
        String sql = "SELECT * FROM medicine_boxes WHERE expiration_date < ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, new java.sql.Date(System.currentTimeMillis()));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                expiredBoxes.add(new MedicineBox(
                    rs.getInt("id"),
                    new Date(rs.getDate("production_date").getTime()),
                    new Date(rs.getDate("expiration_date").getTime()),
                    rs.getBoolean("is_expired")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expiredBoxes;
    }

    // ��ȡ���м������ڵ�ҩ�У����磬30���ڣ�
    public List<MedicineBox> getMedicineBoxesExpiringSoon(int days) {
        List<MedicineBox> expiringSoonBoxes = new ArrayList<>();
        String sql = "SELECT * FROM medicine_boxes WHERE expiration_date BETWEEN ? AND ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            Date thresholdDate = new Date(System.currentTimeMillis() + days * 86400000L);
            pstmt.setDate(1, new java.sql.Date(System.currentTimeMillis()));
            pstmt.setDate(2, new java.sql.Date(thresholdDate.getTime()));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                expiringSoonBoxes.add(new MedicineBox(
                    rs.getInt("id"),
                    new Date(rs.getDate("production_date").getTime()),
                    new Date(rs.getDate("expiration_date").getTime()),
                    rs.getBoolean("is_expired")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expiringSoonBoxes;
    }
}
