package ru.innopolis.rest_service.dto;

import lombok.Value;

@Value
public class UserDTO {

    Integer id;

    String name;

    String password;
}
