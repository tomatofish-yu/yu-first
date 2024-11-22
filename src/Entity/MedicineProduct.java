package Entity;

public class MedicineProduct {

	   private int id;
	   private String manufacturer;
	   private String specification;

	   public MedicineProduct(int id,String manufacturer,String specification)
		{   
			   this.id = id;
			   this.manufacturer = manufacturer;
			   this.specification = specification;
			   
		}


		public int getId() {
			return id;
		}
		public void setID(int id) {
			this.id = id;
		}
		public String getManufacturer() {
			return manufacturer;
		}
		public void setManufacturer(String manufacturer) {
			this.manufacturer = manufacturer;
		}
		public String getSpecification() {
			return specification;
		}
		public void setSpecification(String specification) {
			this.specification = specification;
		}
		
		public String toString() {
			   return "["+this.getId()+"]"+this.getManufacturer()+"("+this.getSpecification()+")";
		}
}
