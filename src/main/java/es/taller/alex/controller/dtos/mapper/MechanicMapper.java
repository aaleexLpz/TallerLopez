package es.taller.alex.controller.dtos.mapper;

import es.taller.alex.controller.dtos.mechanic_dto.MechanicCreateDto;
import es.taller.alex.controller.dtos.mechanic_dto.MechanicPatchDto;
import es.taller.alex.controller.dtos.mechanic_dto.MechanicReadDto;
import es.taller.alex.controller.dtos.mechanic_dto.MechanicUpdateDto;
import es.taller.alex.model.entities.Mechanic;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MechanicMapper {

    MechanicCreateDto mechanicToCreate(Mechanic mechanic);

    Mechanic createToMechanic(MechanicCreateDto mechanicCreateDto);

    MechanicReadDto mechanicToRead(Mechanic mechanic);

    Mechanic readToMechanic(MechanicReadDto mechanicReadDto);

    MechanicUpdateDto mechanicToUpdate(Mechanic mechanic);

    Mechanic updateToMechanic(MechanicUpdateDto mechanicUpdateDto);

    MechanicPatchDto mechanicToPatch(Mechanic mechanic);

    Mechanic patchToMechanic(MechanicPatchDto mechanicPatchDto);
}
