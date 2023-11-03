package es.taller.alex.model.services;

import es.taller.alex.model.entities.Client;
import es.taller.alex.model.entities.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;
import java.util.Optional;

@Service
public class WorkshopServiceImplClient implements WorkshopServiceClient {

    @Autowired
    ClientDao clientDao;

    @Override
    public Client getClient(String DNI) throws InstanceNotFoundException{
        Optional<Client> client = clientDao.findById(DNI);
        if(client.isEmpty()) throw new InstanceNotFoundException("client");

        return client.get();
    }

    @Override
    public Client createClient(Client client){
        return clientDao.save(client);
    }

    @Override
    public void updateClient(String DNI, Client updatedClient) throws InstanceNotFoundException{
        Optional<Client> client = clientDao.findById(DNI);
        updatedClient.setDNI(DNI);

        if(client.isEmpty()) throw new InstanceNotFoundException("client");

        clientDao.save(updatedClient);
    }

    @Override
    public void patchClient(String DNI, Client patchedClient) throws InstanceNotFoundException{
        Optional<Client> optionalClient = clientDao.findById(DNI);

        if(!optionalClient.isPresent()){
            throw new InstanceNotFoundException("Client");
        }
        Client existingClient = optionalClient.get();

        if(patchedClient.getName() != null){
            existingClient.setName(patchedClient.getName());
        }

        if(patchedClient.getLastName() != null){
            existingClient.setLastName(patchedClient.getLastName());
        }

        if(patchedClient.getPhone() != null){
            existingClient.setPhone(patchedClient.getPhone());
        }

        clientDao.save(existingClient);
    }

    @Override
    public void deleteClient(String DNI){
        clientDao.deleteById(DNI);
    }
}
