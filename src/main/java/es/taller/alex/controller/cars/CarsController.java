package es.taller.alex.controller.cars;

import es.taller.alex.controller.dtos.car.*;
import es.taller.alex.controller.dtos.mapper.CarMapper;
import es.taller.alex.model.services.WorkshopServiceCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceNotFoundException;

@RestController
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
    public ResponseEntity<CarDto> creatingCar(@RequestBody CarCreateDto carCreateDto) {
        workshopServiceCar.createCar(carMapper.createDtoToCar(carCreateDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/car/read/{carId}")
    public ResponseEntity<CarReadDto> readingCar(@PathVariable Long carId) {
        try {
            return new ResponseEntity<>(carMapper.carToRead(workshopServiceCar.readCar(carId)), HttpStatus.OK);
        } catch (InstanceNotFoundException e) {
            // Manejo de la excepción por ejemplo, lanzar HttpStatus.NOT_FOUND
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/car/update/{carId}")
    public ResponseEntity<CarUpdateDto> updateCar(@PathVariable Long carId) {
        try {
            workshopServiceCar.updateCar(carId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (InstanceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/car/patch/{carId}")
    public ResponseEntity<CarPatchDto> patchCar(@PathVariable Long carId, @RequestBody CarPatchDto carPatchDto) {
        try {
            workshopServiceCar.patchCar(carId, carPatchDto.getBrand(), carPatchDto.getModel(), carPatchDto.getOwner(), carPatchDto.getMechanic(), carPatchDto.getWorkshop(), carPatchDto.getColor(), carPatchDto.getTuition());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (InstanceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/car/delete/{carId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> removeCar(@PathVariable long carId) {
        workshopServiceCar.deleteCar(carId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}