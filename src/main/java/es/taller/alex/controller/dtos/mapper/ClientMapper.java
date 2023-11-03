package es.taller.alex.controller.dtos.mapper;

import es.taller.alex.controller.dtos.client_dto.ClientCreateDto;
import es.taller.alex.controller.dtos.client_dto.ClientPatchDto;
import es.taller.alex.controller.dtos.client_dto.ClientReadDto;
import es.taller.alex.controller.dtos.client_dto.ClientUpdateDto;
import es.taller.alex.model.entities.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client clientToRead(ClientReadDto clientReadDto);

    ClientReadDto readToClient (Client client);

    Client createToClient(ClientCreateDto clientCreateDto);

    ClientReadDto clientToCreate(Client client);

    Client updateToClient(ClientUpdateDto clientUpdateDto);

    ClientUpdateDto clientToUpdate(Client client);

    Client patchToClient(ClientPatchDto clientPatchDto);

    ClientPatchDto clientToPatch(Client client);
}
