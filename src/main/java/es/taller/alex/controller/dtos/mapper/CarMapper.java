package es.taller.alex.controller.dtos.mapper;

import es.taller.alex.controller.dtos.car.CarCreateDto;
import es.taller.alex.controller.dtos.car.CarPatchDto;
import es.taller.alex.controller.dtos.car.CarReadDto;
import es.taller.alex.controller.dtos.car.CarUpdateDto;
import es.taller.alex.model.entities.Car;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarCreateDto carToCreate(Car car);

    Car createDtoToCar(CarCreateDto carCreateDto);

    CarReadDto carToRead(Car car);

    Car readDtoToCar(CarReadDto carReadDto);

    CarUpdateDto carToUpdate(Car car);

    Car updateDtoToCar(CarUpdateDto carUpdateDto);

    CarPatchDto carToPatch(Car car);

    Car patchDtoToCar(CarPatchDto carPatchDto);
}
