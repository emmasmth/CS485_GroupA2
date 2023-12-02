package edu.loyola.cs485.model.entity;

public class Equipment extends AbstractEntity {
    private Integer idequipment;
    private String brand;
    private String color;
    private String description;

    public Equipment(){
    }


    public Integer getId() {
        return this.idequipment;
    }

    public void setId(Integer id) {
        this.idequipment = id;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override public String toString(){
        return Integer.toString(idequipment)+" | "+brand+", "+color+", " + description + "\n";
    }
}
