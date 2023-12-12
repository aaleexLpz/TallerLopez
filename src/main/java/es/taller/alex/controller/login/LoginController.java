package es.taller.alex.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    // Ruta para procesar el formulario de login
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, RedirectAttributes redirectAttributes) {
        // Verificar las credenciales
        if ("usuario".equals(username) && "contraseña".equals(password)) {
            // Credenciales correctas
            return "redirect:/index";
        } else {
            // Credenciales incorrectas
            redirectAttributes.addFlashAttribute("error", "Credenciales incorrectas");
            return "redirect:/login";
        }
    }

    @GetMapping("/index")
    public String showIndex() {
        return "index";
    }
}