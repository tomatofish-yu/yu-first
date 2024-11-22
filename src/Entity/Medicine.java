package Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Medicine {

	   private int id;
	   private String name; 
	   private String generic_name;
	   private String dosage;
	   private String indications;
	   private String category_name;
	   private String unit;
	   private int amount;

	   public Medicine(int id,String name,String generic_name,String dosage,String indications,String category_name,String unit,int amount)
	   {   
		   this.id = id;
		   this.name = name;
		   this.generic_name = generic_name;
		   this.dosage = dosage;
		   this.indications = indications;
		   this.category_name = category_name;
		   this.unit = unit;
		   this.amount = amount;
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
		public String getGeneric_name() {
			return generic_name;
		}
		public void setGeneric_name(String generic_name) {
			this.generic_name = generic_name;
		}
		public String getDosage() {
			return dosage;
		}
		public void setDosage(String dosage) {
			this.dosage = dosage;
		}
		public String getIndications() {
			return indications;
		}
		public void setIndications(String indications) {
			this.indications = indications;
		}
		public String getCategory_name() {
			return category_name;
		}
		public void setCategory_name(String category_name) {
			this.category_name = category_name;
		}
		public String getUnit() {
			return unit;
		}
		public void setUnit(String unit) {
			this.unit = unit;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		public String toString() {
	   		   return "["+this.getId()+"]"+this.getName()+"("+this.getGeneric_name()+")"+"("+this.getDosage()+")"+"("+this.getIndications()+")"+
	   	"("+this.getCategory_name()+")"+"("+this.getUnit()+")"+"("+this.getAmount()+")";
		}
}
