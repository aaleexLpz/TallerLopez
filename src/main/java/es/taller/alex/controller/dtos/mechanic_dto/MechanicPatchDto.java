package es.taller.alex.controller.dtos.mechanic_dto;

import lombok.Data;

@Data
public class MechanicPatchDto {

    private String name;

    private String lastName;

    private Long phone;

    private Long workshop;

    private Long car;
}
