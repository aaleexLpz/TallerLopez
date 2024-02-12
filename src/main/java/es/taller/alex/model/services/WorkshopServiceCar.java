package es.taller.alex.model.services;

import es.taller.alex.controller.dtos.car.CarCreateDto;
import es.taller.alex.model.entities.Car;
import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;

@Service
public interface WorkshopServiceCar {

    public Car createCar(CarCreateDto carCreateDto);

    public Car readCar(Long carId) throws InstanceNotFoundException;

    public void updateCar(Long carId) throws InstanceNotFoundException;

    public void patchCar(Long carId, String brand, String model, String owner, String mechanic, Long workshop, String color, String tuition) throws InstanceNotFoundException;

    public void deleteCar(Long carId);
}