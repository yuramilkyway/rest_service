package ru.innopolis.rest_service.service.dog;

import ru.innopolis.rest_service.dto.DogDTO;

import java.util.Collection;

public interface DogService {

    Collection<DogDTO> getDogs();
}
