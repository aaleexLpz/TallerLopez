package es.taller.alex.controller.mechanics;

import es.taller.alex.controller.dtos.mapper.MechanicMapper;
import es.taller.alex.controller.dtos.mechanic_dto.*;
import es.taller.alex.model.services.WorkshopServiceMechanic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceNotFoundException;

@Controller
public class MechanicsController {

    @Autowired
    private MechanicMapper mechanicMapper;

    @Autowired
    private WorkshopServiceMechanic workshopServiceMechanic;

    @GetMapping("/readMechanic/{DNI}")
    public ResponseEntity<MechanicReadDto> getMechanic(@PathVariable String DNI) throws InstanceNotFoundException{
        return new ResponseEntity<>(mechanicMapper.mechanicToRead(workshopServiceMechanic.getMechanic(DNI)), HttpStatus.OK);
    }

    @PostMapping("/createMechanic")
    public ResponseEntity<MechanicDto> createMechanic(@RequestBody MechanicCreateDto mechanicCreateDto){
        workshopServiceMechanic.createMechanic(mechanicMapper.createToMechanic(mechanicCreateDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/updateMechanic/{DNI}")
    public ResponseEntity<MechanicUpdateDto> updateMechanic(@PathVariable String DNI, @RequestBody MechanicUpdateDto mechanicUpdateDto) throws InstanceNotFoundException{
        workshopServiceMechanic.updateMechanic(DNI, mechanicMapper.updateToMechanic(mechanicUpdateDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/patchMechanic/{DNI}")
    public ResponseEntity<MechanicPatchDto> patchMechanic(@PathVariable String DNI, @RequestBody MechanicPatchDto mechanicPatchDto) throws InstanceNotFoundException{
        workshopServiceMechanic.patchMechanic(DNI, mechanicMapper.patchToMechanic(mechanicPatchDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteMechanic/{DNI}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMechanic(@PathVariable String DNI){
        workshopServiceMechanic.deleteMechanic(DNI);
    }
}
