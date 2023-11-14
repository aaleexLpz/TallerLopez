package es.taller.alex.controller.cars;

import es.taller.alex.controller.dtos.car_dto.*;
import es.taller.alex.controller.dtos.mapper.CarMapper;
import es.taller.alex.model.services.WorkshopServiceCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceNotFoundException;

@Controller
public class CarsController {

    @Autowired
    public WorkshopServiceCar workshopServiceCar;

    @Autowired
    private CarMapper carMapper;

    @Autowired
    public CarsController(
        WorkshopServiceCar workshopServiceCar){
        this.workshopServiceCar = workshopServiceCar;
    }

    @PostMapping("/car/create")
    public ResponseEntity<CarDto> creatingCar(CarCreateDto carCreateDto) throws InstanceNotFoundException{
        workshopServiceCar.createCar(carMapper.createToCar(carCreateDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/car/read/{carId}")
    public ResponseEntity<CarReadDto> readingCar(@PathVariable long carId, CarReadDto carReadDto) throws InstanceNotFoundException{
        return new ResponseEntity<>(carMapper.carToRead(workshopServiceCar.readCar(carId)), HttpStatus.OK);
    }

    @PutMapping("/car/update/{carId}")
    public ResponseEntity<CarUpdateDto> updateCar(@PathVariable long carId, CarUpdateDto carUpdateDto) throws InstanceNotFoundException {
        workshopServiceCar.updateCar(carId, carMapper.updateToCar(carUpdateDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/car/patch/{carId}")
    public ResponseEntity<CarPatchDto> patchCar(@PathVariable long carId, CarPatchDto carPatchDto) throws InstanceNotFoundException{
        workshopServiceCar.patchCar(carId, carMapper.patchToCar(carPatchDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/car/delete/{carId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCar(@PathVariable long carId){
        workshopServiceCar.deleteCar(carId);
    }

}