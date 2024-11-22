package DAL;


import Entity.Purchase;
import dbUtils.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PurchaseDAO {

    // 获取数据库连接
    private Connection getConnection() {
        return Connect.connectMySQL();
    }

    // 添加采购信息
    public boolean addPurchase(Purchase purchase) {
        String sql = "INSERT INTO purchases (id, medicine_id, stock_in_date, expiration_date, amount, purchaser, pharmacy_name) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, purchase.getId());
            pstmt.setInt(2, purchase.getMedicine_id());
            pstmt.setDate(3, new java.sql.Date(purchase.getStock_in_date().getTime()));
            pstmt.setDate(4, new java.sql.Date(purchase.getExpiration_date().getTime()));
            pstmt.setInt(5, purchase.getAmount());
            pstmt.setString(6, purchase.getPurchaser());
            pstmt.setString(7, purchase.getPharmacy_name());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 更新采购信息
    public boolean updatePurchase(Purchase purchase) {
        String sql = "UPDATE purchases SET medicine_id=?, stock_in_date=?, expiration_date=?, amount=?, purchaser=?, pharmacy_name=? WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, purchase.getMedicine_id());
            pstmt.setDate(2, new java.sql.Date(purchase.getStock_in_date().getTime()));
            pstmt.setDate(3, new java.sql.Date(purchase.getExpiration_date().getTime()));
            pstmt.setInt(4, purchase.getAmount());
            pstmt.setString(5, purchase.getPurchaser());
            pstmt.setString(6, purchase.getPharmacy_name());
            pstmt.setInt(7, purchase.getId());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 删除采购信息
    public boolean deletePurchase(int id) {
        String sql = "DELETE FROM purchases WHERE id=?";
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

    // 根据ID查询采购信息
    public Purchase getPurchaseById(int id) {
        String sql = "SELECT * FROM purchases WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Purchase(
                    rs.getInt("id"),
                    rs.getInt("medicine_id"),
                    new Date(rs.getDate("stock_in_date").getTime()),
                    new Date(rs.getDate("expiration_date").getTime()),
                    rs.getInt("amount"),
                    rs.getString("purchaser"),
                    rs.getString("pharmacy_name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 查询所有采购信息
    public List<Purchase> getAllPurchases() {
        List<Purchase> purchases = new ArrayList<>();
        String sql = "SELECT * FROM purchases";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                purchases.add(new Purchase(
                    rs.getInt("id"),
                    rs.getInt("medicine_id"),
                    new Date(rs.getDate("stock_in_date").getTime()),
                    new Date(rs.getDate("expiration_date").getTime()),
                    rs.getInt("amount"),
                    rs.getString("purchaser"),
                    rs.getString("pharmacy_name")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return purchases;
    }
}