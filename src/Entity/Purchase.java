package Entity;

import java.text.SimpleDateFormat;
import java.util.Date;
//这是一个实体类
public class Purchase {

	   private int id;
	   private int medicine_id; 
	   private Date stock_in_date;
	   private Date expiration_date;
	   private int amount;
	   private String purchaser;
	   private String pharmacy_name;
	   
	   public Purchase(int id,int medicine_id,Date stock_in_date,Date expiration_date,int amount,String purchaser,String pharmacy_name)
	   {   
	   	   this.id = id;
	   	   this.medicine_id = medicine_id;
	   	   this.stock_in_date = stock_in_date;
	   	   this.expiration_date = expiration_date;
	   	   this.amount = amount;
	   	   this.purchaser = purchaser;
	   	   this.pharmacy_name = pharmacy_name;
	   	   
	   }

	   	public int getId() {
	   		return id;
	   	}
	   	public void setID(int id) {
	   		this.id = id;
	   	}
	   	public int getMedicine_id() {
	   		return medicine_id;
	   	}
	   	public void setMedicine_name(int medicine_id) {
	   		this.medicine_id = medicine_id;
	   	}
	   	public Date getStock_in_date() {
	   		return stock_in_date;
	   	}
	   	public void setStock_in_date(Date stock_in_date) {
	   		this.stock_in_date = stock_in_date;
	   	}
	   	public Date getExpiration_date() {
	   		return expiration_date;
	   	}
	   	public void setExpiration_date(Date expiration_date) {
	   		this.expiration_date = expiration_date;
	   	}
	   	public int getAmount() {
	   		return amount;
	   	}
	   	public void setAmount(int amount) {
	   		this.amount = amount;
	   	}
	   	public String getPurchaser() {
	   		return purchaser;
	   	}
	   	public void setpurchaser(String purchaser) {
	   		this.purchaser = purchaser;
	   	}
	   	public String getPharmacy_name() {
	   		return pharmacy_name;
	   	}
	   	public void setPharmacy_name(String pharmacy_name) {
	   		this.pharmacy_name = pharmacy_name;
	   	}
	   	
	   	public String toString() {
	   		   return "["+this.getId()+"]"+this.getMedicine_id()+"("+this.getStock_in_date()+")"+"("+this.getExpiration_date()+")"+"("+this.getAmount()+")"+
	   	"("+this.getAmount()+")"+"("+this.getPharmacy_name()+")";
	   	
	    }	   
}

