package ru.innopolis.rest_service.dto;

import lombok.Value;

@Value
public class DogDTO {

    Integer id;

    String name;

    String color;

    String breed;
}
