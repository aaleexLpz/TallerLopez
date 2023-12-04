package es.taller.alex.model.repository;

import es.taller.alex.model.entities.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkshopRepository extends JpaRepository<Workshop, Long> {
}
