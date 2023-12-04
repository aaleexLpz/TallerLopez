package es.taller.alex.model.repository;

import es.taller.alex.model.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
