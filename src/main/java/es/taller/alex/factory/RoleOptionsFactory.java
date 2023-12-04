package es.taller.alex.factory;

import es.taller.alex.options.AdminOptions;
import es.taller.alex.options.GuestOptions;
import es.taller.alex.options.UserOptions;

public class RoleOptionsFactory {

    public static Object getOptionsForRole(String role) {
        switch (role) {
            case "GUEST":
                return new GuestOptions();
            case "USER":
                return new UserOptions();
            case "ADMIN":
                return new AdminOptions();
            default:
                throw new IllegalArgumentException("Rol no válido: " + role);
        }
    }
}

