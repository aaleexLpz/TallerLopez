package es.taller.alex.model.repository;

import es.taller.alex.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {
}
