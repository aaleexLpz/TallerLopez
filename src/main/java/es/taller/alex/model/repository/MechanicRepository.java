package es.taller.alex.model.repository;

import es.taller.alex.model.entities.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MechanicRepository extends JpaRepository<Mechanic, String> {
}
