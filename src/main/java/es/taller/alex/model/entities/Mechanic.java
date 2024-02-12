package es.taller.alex.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Mechanic {

    @Id
    private String DNI;

    private String name;

    private String lastName;

    private Long phone;

    private Long workshop;

    private Long car;

}