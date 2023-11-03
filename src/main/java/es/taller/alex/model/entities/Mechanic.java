package es.taller.alex.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mechanic {

    @Id
    private String DNI;

    private String name;

    private String lastName;

    private Long phone;

    private Long workshop;

    private Long car;


    public Mechanic(String DNI, String name, String lastName, Long phone, Long workshop, Long car){
        this.DNI = DNI;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.workshop = workshop;
        this.car = car;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Long getWorkshop() {
        return workshop;
    }

    public void setWorkshop(Long workshop) {
        this.workshop = workshop;
    }

    public Long getCar() {
        return car;
    }

    public void setCar(Long car) {
        this.car = car;
    }
}
