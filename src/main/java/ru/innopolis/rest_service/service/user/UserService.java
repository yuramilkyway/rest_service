package ru.innopolis.rest_service.service.user;

import ru.innopolis.rest_service.dto.UserDTO;

import java.util.Collection;

public interface UserService {

    Collection<UserDTO> getUsers();
}
