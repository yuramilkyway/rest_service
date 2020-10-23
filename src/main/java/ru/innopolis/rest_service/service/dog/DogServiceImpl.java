package ru.innopolis.rest_service.service.dog;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.innopolis.rest_service.dto.DogDTO;
import ru.innopolis.rest_service.entity.Dog;
import ru.innopolis.rest_service.repository.DogRepository;
import ru.innopolis.rest_service.util.DTOConverter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

@Service("dogService")
@RequiredArgsConstructor
public class DogServiceImpl implements DogService {

    private final DogRepository dogRepository;

    @Override
    public Collection<DogDTO> getDogs() {
        List<DogDTO> list = new ArrayList<>();
        Iterable<Dog> all = dogRepository.findAll();
        for (Dog dog : all) {
            list.add(DTOConverter.convertToDTO(dog));
        }
        list.sort(Comparator.comparing(DogDTO::getName));
        return list;
    }
}
