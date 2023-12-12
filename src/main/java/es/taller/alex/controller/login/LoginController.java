package es.taller.alex.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        if ("usuario".equals(username) && "contraseña".equals(password)) {
            return "redirect:/index";
        } else {
            model.addAttribute("error", "Credenciales incorrectas");
            return "redirect:/login";
        }
    }

    @GetMapping("/index")
    public String showIndex() {
        return "index";
    }
}
