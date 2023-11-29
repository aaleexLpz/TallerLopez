package es.taller.alex.controller.dtos.client;

import lombok.Data;

@Data
public class ClientDto {

    private String Dni;

    private String name;

    private String lastName;

    private Long phone;

    private Long car;
}
