package es.taller.alex.model.services;

import es.taller.alex.model.entities.Client;
import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;

@Service
public interface WorkshopServiceClient {

    public Client getClient(String DNI) throws InstanceNotFoundException;

    public Client createClient(Client client);

    public void updateClient(String DNI, Client client) throws InstanceNotFoundException;

    public void patchClient(String DNI, Client client) throws InstanceNotFoundException;

    public void deleteClient(String DNI);

}
