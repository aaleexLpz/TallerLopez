package es.taller.alex.controller.dtos.mapper;
import es.taller.alex.controller.dtos.car_dto.CarCreateDto;
import es.taller.alex.controller.dtos.car_dto.CarPatchDto;
import es.taller.alex.controller.dtos.car_dto.CarReadDto;
import es.taller.alex.controller.dtos.car_dto.CarUpdateDto;
import es.taller.alex.model.entities.Car;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface CarMapper {

    CarCreateDto carToCreate(Car car);

    Car createToCar(CarCreateDto carCreateDto);

    CarReadDto carToRead(Car car);

    Car readToCar(CarReadDto carReadDto);

    CarUpdateDto carToUpdate(Car car);

    Car updateToCar(CarUpdateDto carUpdateDto);

    CarPatchDto carToPatch(Car car);

    Car patchToCar(CarPatchDto carPatchDto);
}
