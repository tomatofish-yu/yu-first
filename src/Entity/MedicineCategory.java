package Entity;

public class MedicineCategory {

	   private int id;
	   private String name; 
	   private String desription;

	   public MedicineCategory(int id,String name,String desription)
		{   
			   this.id = id;
			   this.name = name;
			   this.desription = desription;
			   
		}


		public int getId() {
			return id;
		}
		public void setID(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDesription() {
			return desription;
		}
		public void setDesription(String desription) {
			this.desription = desription;
		}
		public String toString() {
			   return "["+this.getId()+"]"+this.getName()+"("+this.getDesription()+")";
		}
}
