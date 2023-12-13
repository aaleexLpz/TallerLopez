package es.taller.alex.controller.home;

import es.taller.alex.model.repository.CarRepository;
import es.taller.alex.model.repository.ClientRepository;
import es.taller.alex.model.repository.MechanicRepository;
import es.taller.alex.model.repository.WorkshopRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CarRepository carRepository;
    private final ClientRepository clientRepository;
    private final MechanicRepository mechanicRepository;
    private final WorkshopRepository workshopRepository;

    public HomeController(
            CarRepository carRepository,
            ClientRepository clientRepository,
            MechanicRepository mechanicRepository,
            WorkshopRepository workshopRepository) {
        this.carRepository = carRepository;
        this.clientRepository = clientRepository;
        this.mechanicRepository = mechanicRepository;
        this.workshopRepository = workshopRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("cars", carRepository.findAll());
        model.addAttribute("clients", clientRepository.findAll());
        model.addAttribute("mechanics", mechanicRepository.findAll());
        model.addAttribute("workshops", workshopRepository.findAll());

        return "index";
    }
}

