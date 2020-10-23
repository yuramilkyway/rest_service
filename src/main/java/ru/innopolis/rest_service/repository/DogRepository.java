package ru.innopolis.rest_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.rest_service.entity.Dog;

public interface DogRepository extends JpaRepository<Dog, Integer> {
}
