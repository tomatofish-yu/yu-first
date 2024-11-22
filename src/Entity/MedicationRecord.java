package Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MedicationRecord {

	   private int id;
	   private String member_name; 
	   private int medicine_id;
	   private Date medication_time;
	   private int dose;
	   private String symptoms;
	   
	   public MedicationRecord(int id,String member_name,int medicine_id,Date medication_time,int dose,String symptoms)
	   {   
		   this.id = id;
		   this.member_name = member_name;
		   this.medicine_id = medicine_id;
		   this.medication_time = medication_time;
		   this.dose = dose;
		   this.symptoms = symptoms;
		   
	   }
		public int getId() {
			return id;
		}
		public void setID(int id) {
			this.id = id;
		}
		public String getMember_name() {
			return member_name;
		}
		public void setMember_name(String member_name) {
			this.member_name = member_name;
		}
		public int getMedicine_id() {
			return medicine_id;
		}
		public void setMedicine_id(int medicine_id) {
			this.medicine_id = medicine_id;
		}
		public Date getmedication_time() {
			return medication_time;
		}
		public void setMedication_time(Date medication_time) {
			this.medication_time = medication_time;
		}
		public int getDose() {
			return dose;
		}
		public void setDose(int dose) {
			this.dose = dose;
		}
		public String getSymptoms() {
			return symptoms;
		}
		public void setSymptoms(String symptoms) {
			this.symptoms = symptoms;
		}
		
		public String toString() {
	   		   return "["+this.getId()+"]"+this.getMember_name()+"("+this.getMedicine_id()+")"+
		"("+this.getmedication_time()+")"+"("+this.getDose()+")"+"("+this.getSymptoms()+")";
		}

}
