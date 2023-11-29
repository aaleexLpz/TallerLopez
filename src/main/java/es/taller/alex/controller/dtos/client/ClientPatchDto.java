package es.taller.alex.controller.dtos.client;

import lombok.Data;

@Data
public class ClientPatchDto {

    private String name;

    private String lastName;

    private Long phone;

    private Long car;
}
