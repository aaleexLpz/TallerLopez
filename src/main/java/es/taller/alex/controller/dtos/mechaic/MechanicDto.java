package es.taller.alex.controller.dtos.mechaic;

import lombok.Data;

@Data
public class MechanicDto {

    private String DNI;

    private String name;

    private String lastName;

    private Long phone;

    private Long workshop;

    private Long car;
}
