package es.taller.alex.controller.user;

import es.taller.alex.factory.RoleOptionsFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/welcome")
    public String welcome(Model model) {
        // Obtengo el nombre del usuario y su rol
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        String role = authentication.getAuthorities().iterator().next().getAuthority();

        // Obtengo las opciones según el rol del usuario
        Object userOptions = RoleOptionsFactory.getOptionsForRole(role);

        // Añado las opciones al modelo
        model.addAttribute("username", username);
        model.addAttribute("userOptions", userOptions);

        // Devuelvo la vista correspondiente según el rol
        if ("GUEST".equals(role)) {
            return "welcome_guest"; // archivo HTML para invitados
        } else if ("USER".equals(role)) {
            return "welcome_user"; // archivo HTML para usuarios
        } else if ("ADMIN".equals(role)) {
            return "welcome_admin"; // archivo HTML para administradores
        } else {
            throw new IllegalArgumentException("Rol no válido: " + role);
        }
    }
}
