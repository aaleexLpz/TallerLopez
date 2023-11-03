package es.taller.alex.controller.dtos.car_dto;

public class CarUpdateDto {

    private String brand;
    
    private String model;

    private String owner;

    private String mechanic;

    private Long workshop;

    private String color;

    private String tuition;

    public CarUpdateDto(){

    }

    public CarUpdateDto(String brand, String model, String owner, String mechanic, Long workshop, String color, String tuition){

        this.brand = brand;
        this.model = model;
        this.owner = owner;
        this.mechanic = mechanic;
        this.workshop = workshop;
        this.color = color;
        this.tuition = tuition;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getMechanic() {
        return mechanic;
    }

    public void setMechanic(String mechanic) {
        this.mechanic = mechanic;
    }

    public Long getWorkshop() {
        return workshop;
    }

    public void setWorkshop(Long workshop) {
        this.workshop = workshop;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTuition() {
        return tuition;
    }

    public void setTuition(String tuition) {
        this.tuition = tuition;
    }
}
