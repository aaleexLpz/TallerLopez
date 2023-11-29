package es.taller.alex.model.entities;

import lombok.Data;

@Data
public class User {
  private String username;
  private String password;
  private String role; // Puede ser "Invitado", "Usuario" o "Admin"
}
