package Entity;


public class MedicineCategory {
    private int id;
    private int medicine_id;
    private int category_id;

    public MedicineCategory(int id, int medicine_id, int category_id) {
        this.id = id;
        this.medicine_id = medicine_id;
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

 
    public int getMedicine_id() {
        return medicine_id;
    }

    public void setMedicine_id(int medicine_id) {
        this.medicine_id = medicine_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }


    @Override
    public String toString() {
        return "MedicineCategory{" +
               "id=" + id +
               ", medicineId=" + medicine_id +
               ", categoryId=" + category_id +
               '}';
    }
}