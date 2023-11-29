package es.taller.alex.model.services;

import es.taller.alex.model.entities.Car;
import es.taller.alex.model.entities.CarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;
import java.util.Optional;

@Service
public abstract class WorkshopServiceImplCar implements WorkshopServiceCar {

    @Autowired
    private CarDao carDao;

    @Override
    public void createCar(Car car) {
        carDao.save(car);
    }

    @Override
    public Car readCar(Long carId) throws InstanceNotFoundException {
        Optional<Car> optionalCar = carDao.findById(carId);

        if (optionalCar.isEmpty()) {
            throw new InstanceNotFoundException("Car not found with ID: " + carId);
        }

        return optionalCar.get();
    }


    @Override
    public void updateCar(Long carId) throws InstanceNotFoundException {
        Optional<Car> optionalCar = carDao.findById(carId);

        if (optionalCar.isEmpty()) {
            throw new InstanceNotFoundException("Car not found with ID: " + carId);
        }

        Car existingCar = optionalCar.get();
        // Realiza las actualizaciones necesarias en el objeto Car
        // Por ejemplo, existingCar.setNombreNuevo(nombreNuevo);

        carDao.save(existingCar);
    }


    @Override
    public void patchCar(Long carId, String brand, String model, String owner, String mechanic, Long workshop,
                         String color, String tuition) throws InstanceNotFoundException {
        Optional<Car> optionalCar = carDao.findById(carId);

        if (optionalCar.isEmpty()) {
            throw new InstanceNotFoundException("Car not found with ID: " + carId);
        }

        Car existingCar = optionalCar.get();

        if (brand != null) {
            existingCar.setBrand(brand);
        }

        if (model != null) {
            existingCar.setModel(model);
        }

        if (owner != null) {
            existingCar.setOwner(owner);
        }

        if (mechanic != null) {
            existingCar.setMechanic(mechanic);
        }

        if (workshop != null) {
            existingCar.setWorkshop(workshop);
        }

        if (color != null) {
            existingCar.setColor(color);
        }

        if (tuition != null) {
            existingCar.setTuition(tuition);
        }

        carDao.save(existingCar);
    }
`



    @Override
    public void deleteCar(Long carId){
        carDao.deleteById(carId);
    }
}
