package es.taller.alex.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    private String model;

    private String owner;

    private String mechanic;

    private Long workshop;

    private String color;

    private String tuition;

    public Car(){

    }

    public Car(Long id, String brand, String model, String owner, String mechanic, Long workshop, String color,
               String tuition){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.owner = owner;
        this.mechanic = mechanic;
        this.workshop = workshop;
        this.color = color;
        this.tuition = tuition;
    }

}