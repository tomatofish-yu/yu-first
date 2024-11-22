package DAL;


import Entity.FamilyMember;
import dbUtils.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FamilyMemberDAO {

    // 获取数据库连接
    private Connection getConnection() {
        return Connect.connectMySQL();
    }

    // 添加家庭成员信息
    public boolean addFamilyMember(FamilyMember familyMember) {
        String sql = "INSERT INTO family_members (name, birth_date, gender, allergy_history) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, familyMember.getName());
            pstmt.setInt(2, familyMember.getBirth_date());
            pstmt.setString(3, familyMember.getGender());
            pstmt.setString(4, familyMember.getAllergy_historys());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 更新家庭成员信息
    public boolean updateFamilyMember(FamilyMember familyMember) {
        String sql = "UPDATE family_members SET name=?, birth_date=?, gender=?, allergy_history=? WHERE name=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, familyMember.getName());
            pstmt.setInt(2, familyMember.getBirth_date());
            pstmt.setString(3, familyMember.getGender());
            pstmt.setString(4, familyMember.getAllergy_historys());
            pstmt.setString(5, familyMember.getName());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 删除家庭成员信息
    public boolean deleteFamilyMember(String name) {
        String sql = "DELETE FROM family_members WHERE name=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 根据姓名查询家庭成员信息
    public FamilyMember getFamilyMemberByName(String name) {
        String sql = "SELECT * FROM family_members WHERE name=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new FamilyMember(
                    rs.getString("name"),
                    rs.getInt("birth_date"),
                    rs.getString("gender"),
                    rs.getString("allergy_history")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 查询所有家庭成员信息
    public List<FamilyMember> getAllFamilyMembers() {
        List<FamilyMember> familyMembers = new ArrayList<>();
        String sql = "SELECT * FROM family_members";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                familyMembers.add(new FamilyMember(
                    rs.getString("name"),
                    rs.getInt("birth_date"),
                    rs.getString("gender"),
                    rs.getString("allergy_history")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return familyMembers;
    }
}