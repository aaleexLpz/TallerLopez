package es.taller.alex.model.services;

import es.taller.alex.model.entities.Mechanic;
import es.taller.alex.model.repository.MechanicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;

@Service
public class WorkshopServiceImplMechanic implements WorkshopServiceMechanic{

    @Autowired
    MechanicRepository mechanicRepository;

    @Override
    public Mechanic getMechanic(String DNI) throws InstanceNotFoundException {
        return null;
    }

    @Override
    public Mechanic createMechanic(Mechanic mechanic) {
        return null;
    }

    @Override
    public void updateMechanic(String DNI, Mechanic mechanic) throws InstanceNotFoundException {

    }

    @Override
    public void patchMechanic(String DNI, Mechanic mechanic) throws InstanceNotFoundException {

    }

    @Override
    public void deleteMechanic(String DNI) {

    }
}
