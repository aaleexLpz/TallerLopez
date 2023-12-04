package es.taller.alex.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import es.taller.alex.model.entities.Car;
import es.taller.alex.model.entities.Client;
import es.taller.alex.model.entities.Mechanic;
import es.taller.alex.model.entities.Workshop;
import es.taller.alex.model.repository.CarRepository;
import es.taller.alex.model.repository.ClientRepository;
import es.taller.alex.model.repository.MechanicRepository;
import es.taller.alex.model.repository.WorkshopRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final CarRepository carRepository;
    private final ClientRepository clientRepository;
    private final MechanicRepository mechanicRepository;
    private final WorkshopRepository workshopRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DataLoader(
            CarRepository carRepository,
            ClientRepository clientRepository,
            MechanicRepository mechanicRepository,
            WorkshopRepository workshopRepository,
            PasswordEncoder passwordEncoder) {
        this.carRepository = carRepository;
        this.clientRepository = clientRepository;
        this.mechanicRepository = mechanicRepository;
        this.workshopRepository = workshopRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Si la bbdd está vacía, ejecutar insertTestData()
        if (carRepository.count() == 0) {
            insertTestData();
        }
    }

    private void insertTestData() {
        // Inserta un coche de ejemplo
        Car car = new Car(1L, "Toyota", "Camry", "John Doe", "Alice", 1L, "Red", "ABC123");
        carRepository.save(car);

        // Inserta un cliente de ejemplo
        Client client = new Client("123456789", "John", "Doe", 123456789L, car.getId());
        clientRepository.save(client);

        // Inserta un mecánico de ejemplo
        Mechanic mechanic = new Mechanic("987654321", "Bob", "Smith", 987654321L, 1L, car.getId());
        mechanicRepository.save(mechanic);

        // Inserta un taller de ejemplo
        Workshop workshop = new Workshop(1L, "Main Street", car.getId(), mechanic.getDNI());
        workshopRepository.save(workshop);
    }
}
