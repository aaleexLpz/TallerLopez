package es.taller.alex.model.services;

import es.taller.alex.model.entities.Car;
import es.taller.alex.model.entities.CarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.taller.alex.model.entities.*;

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
        Optional<Car> car = carDao.findById(carId);
        if(car.isEmpty()) throw new InstanceNotFoundException("car");
        return car.get();
    }

    @Override
    public void updateCar(Long carId, Car updatedCar) throws InstanceNotFoundException {
        Optional<Car> car = carDao.findById(carId);
        updatedCar.setId(carId);

        if(car.isEmpty()) throw new InstanceNotFoundException("car");

        carDao.save(updatedCar);
    }

    @Override
    public void patchCar(Long carId, Car patchedCar) throws InstanceNotFoundException {
        Optional<Car> optionalCar = carDao.findById(carId);

        if(!optionalCar.isPresent()){
            throw new InstanceNotFoundException("Car");
        }
        Car existingCar = optionalCar.get();

        if(patchedCar.getBrand() != null){
            existingCar.setBrand(patchedCar.getBrand());
        }

        if(patchedCar.getModel() != null){
            existingCar.setModel(patchedCar.getModel());
        }

        if(patchedCar.getOwner() != null){
            existingCar.setOwner(patchedCar.getOwner());
        }

        if(patchedCar.getMechanic() != null){
            existingCar.setMechanic(patchedCar.getMechanic());
        }

        if(patchedCar.getWorkshop() != null){
            existingCar.setWorkshop(patchedCar.getWorkshop());
        }

        if(patchedCar.getColor() != null){
            existingCar.setColor(patchedCar.getColor());
        }

        if(patchedCar.getTuition() != null){
            existingCar.setTuition(patchedCar.getTuition());
        }

        carDao.save(existingCar);
    }

    @Override
    public void deleteCar(Long carId){
        carDao.deleteById(carId);
    }
}
