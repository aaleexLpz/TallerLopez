package es.taller.alex.model.repository;

import es.taller.alex.model.entities.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MechanicRepository extends CrudRepository<Mechanic, String> {
}
