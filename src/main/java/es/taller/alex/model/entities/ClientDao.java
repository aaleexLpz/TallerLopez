package es.taller.alex.model.entities;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDao extends JpaRepository<Client, String> {
}
