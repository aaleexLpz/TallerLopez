package es.taller.alex.controller.dtos.mechaic;

import lombok.Data;

@Data
public class MechanicUpdateDto {

    private String name;

    private String lastName;

    private Long phone;

    private Long workshop;

    private Long car;
}
