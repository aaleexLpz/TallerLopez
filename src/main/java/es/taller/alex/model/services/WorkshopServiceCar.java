package es.taller.alex.model.services;

import es.taller.alex.model.entities.Car;
import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;

@Service
public interface WorkshopServiceCar {

    public Car getCar(Long carId) throws InstanceNotFoundException;

    public void createCar(Car car);

    public Car readCar(Long carId) throws InstanceNotFoundException;

    public void updateCar(Long carId, Car car) throws InstanceNotFoundException;

    public void patchCar(Long carId, Car car) throws InstanceNotFoundException;

    public void deleteCar(Long carId);
}

