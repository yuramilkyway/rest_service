package ru.innopolis.rest_service.util;

import ru.innopolis.rest_service.dto.DogDTO;
import ru.innopolis.rest_service.entity.Dog;

public class DTOConverter {
    public static DogDTO convertToDTO(Dog dog) {
        return new DogDTO(
                dog.getId(),
                dog.getName(),
                dog.getColor(),
                dog.getBreed()
        );
    }
}
