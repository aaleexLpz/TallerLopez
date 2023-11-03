package es.taller.alex.model.entities;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MechanicDao extends JpaRepository<Mechanic, String> {
}
