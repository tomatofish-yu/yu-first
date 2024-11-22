package Entity;

import java.util.Date;

public class MedicineBox {

	   private int id;
	   private Date production_date;
	   private Date expiration_date;
	   private boolean isExpired;
	  
	   public MedicineBox(int id,Date production_date,Date expiration_date,boolean isExpired)
	   {   
	   	   this.id = id;
	   	   this.production_date = production_date;
	   	   this.expiration_date = expiration_date;
	   	   this.isExpired = isExpired;
	   	   
	   }
	   	public int getId() {
	   		return id;
	   	}
	   	public void setID(int id) {
	   		this.id = id;
	   	}
	   	public Date getProduction_date() {
	   		return production_date;
	   	}
	   	public void setProduction_date(Date production_date) {
	   		this.production_date = production_date;
	   	}
	   	public Date getExpiration_date() {
	   		return expiration_date;
	   	}
	   	public void setExpiration_date(Date expiration_date) {
	   		this.expiration_date = expiration_date;
	   	}
	   	public boolean isExpired() {
	        return isExpired;
	    }

	    public void setExpired(boolean expired) {
	        isExpired = expired;
	    }
	    public String toString() {
	        return "[" + this.getId() + "]" + "(" + this.getProduction_date() + ")" + "(" + this.getExpiration_date() + ")";
	    }
}
