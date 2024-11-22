package Entity;

public class FamilyMember {

	   private String name; 
	   private int birth_date;
	   private String gender;
	   private String allergy_history;
	   

	public FamilyMember(String name,int birth_date,String gender,String allergy_history)
	{   
		   this.name = name;
		   this.birth_date = birth_date;
		   this.gender = gender;
		   this.allergy_history = allergy_history;
		   
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(int birth_date) {
		this.birth_date = birth_date;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAllergy_historys() {
		return allergy_history;
	}
	public void setAllergy_history(String allergy_history) {
		this.allergy_history = allergy_history;
	}
	public String toString() {
		   return this.getName()+"("+this.getBirth_date()+")"+"("+this.getGender()+")"+"("+this.getAllergy_historys()+")";
	   }
}
