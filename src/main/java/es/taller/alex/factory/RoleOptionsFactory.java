package es.taller.alex.factory;

import es.taller.alex.options.UserOptions;

public class RoleOptionsFactory {

    public static Object getOptionsForRole(String role) {
        switch (role) {
            case "USER":
                return new UserOptions();
            default:
                throw new IllegalArgumentException("Rol no válido: " + role);
        }
    }
}

