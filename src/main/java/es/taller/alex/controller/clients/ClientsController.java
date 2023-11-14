package es.taller.alex.controller.clients;

import es.taller.alex.controller.dtos.client_dto.*;
import es.taller.alex.controller.dtos.mapper.ClientMapper;
import es.taller.alex.model.services.WorkshopServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceNotFoundException;

@Controller
public class ClientsController {

    @Autowired
    private final WorkshopServiceClient workshopServiceClient;

    @Autowired
    private ClientMapper clientMapper;

    @Autowired
    public ClientsController(WorkshopServiceClient workshopServiceClient) {
        this.workshopServiceClient = workshopServiceClient;
    }

    @GetMapping("/client/read/{DNI}")
    public ResponseEntity<ClientReadDto> readClient(@PathVariable String DNI) throws InstanceNotFoundException {
        return new ResponseEntity<>(clientMapper.readToClient(workshopServiceClient.getClient(DNI)), HttpStatus.OK);
    }

    @PostMapping("/client/create")
    public ResponseEntity<ClientCreateDto> createClient(@RequestBody ClientCreateDto clientCreateDto, @PathVariable String DNI){
        workshopServiceClient.createClient(clientMapper.createToClient(clientCreateDto));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/client/update/{DNI}")
    public ResponseEntity<ClientUpdateDto> updateClient(@PathVariable String DNI, @RequestBody ClientUpdateDto clientUpdateDto)
            throws InstanceNotFoundException {
        workshopServiceClient.updateClient(DNI, clientMapper.updateToClient(clientUpdateDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/client/patch/{DNI}")
    public ResponseEntity<ClientPatchDto> patchClient(@PathVariable String DNI, @RequestBody ClientPatchDto clientPatchDto) throws InstanceNotFoundException{
        workshopServiceClient.patchClient(DNI, clientMapper.patchToClient(clientPatchDto));

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/client/delete/{DNI}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable String DNI){
        workshopServiceClient.deleteClient(DNI);
    }
}

