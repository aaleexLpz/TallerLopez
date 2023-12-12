package es.taller.alex.model.repository;

import es.taller.alex.model.entities.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface WorkshopRepository extends CrudRepository<Workshop, Long> {
}
