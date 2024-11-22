package BLL;


import DAL.FamilyMemberDAO;
import Entity.FamilyMember;
import java.util.List;

public class FamilyMemberService {

    private FamilyMemberDAO familyMemberDAO = new FamilyMemberDAO();

    public boolean addFamilyMember(FamilyMember familyMember) {
        return familyMemberDAO.addFamilyMember(familyMember);
    }

    public boolean updateFamilyMember(FamilyMember familyMember) {
        return familyMemberDAO.updateFamilyMember(familyMember);
    }

    public boolean deleteFamilyMember(String name) {
        return familyMemberDAO.deleteFamilyMember(name);
    }

    public FamilyMember getFamilyMemberByName(String name) {
        return familyMemberDAO.getFamilyMemberByName(name);
    }

    public List<FamilyMember> getAllFamilyMembers() {
        return familyMemberDAO.getAllFamilyMembers();
    }

}