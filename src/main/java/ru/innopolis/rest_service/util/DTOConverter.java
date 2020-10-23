package ru.innopolis.rest_service.util;

import ru.innopolis.rest_service.dto.DogDTO;
import ru.innopolis.rest_service.dto.UserDTO;
import ru.innopolis.rest_service.entity.Dog;
import ru.innopolis.rest_service.entity.User;

public class DTOConverter {
    public static DogDTO dogConvertToDTO(Dog dog) {
        return new DogDTO(
                dog.getId(),
                dog.getName(),
                dog.getColor(),
                dog.getBreed()
        );
    }

    public static UserDTO userConvertToDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getPassword()
        );
    }
}
