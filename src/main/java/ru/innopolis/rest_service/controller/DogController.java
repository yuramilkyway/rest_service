package ru.innopolis.rest_service.controller;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.innopolis.rest_service.entity.Dog;
import ru.innopolis.rest_service.repository.DogRepository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/rest_service")
public class DogController {

    private final DogRepository dogRepository;
    private final DataSource dataSource;

    public DogController(DogRepository dogRepository, DataSource dataSource) {
        this.dogRepository = dogRepository;
        this.dataSource = dataSource;
    }

    @GetMapping("/{table_name}/{row_id}")
    public Dog getDogsById(
            @PathVariable("table_name") Object obg,
            @PathVariable("row_id") Integer id) {
        Dog dog = dogRepository.getOne(id);
        Dog result = new Dog();
        result.setId(dog.getId());
        result.setName(dog.getName());
        result.setColor(dog.getColor());
        result.setBreed(dog.getBreed());
        return result;
    }

    @GetMapping("/jdbc/{table_name}/{row_id}")
    public Object getDogByIdJdbc(
            @PathVariable("table_name") Object obg,
            @PathVariable("row_id") Integer id) {
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        Map<String, Integer> paramMap = new HashMap<>();
        paramMap.put("id", id);
        Map<String, Object> resultMap = jdbcTemplate.queryForMap("SELECT * FROM dog WHERE id=:id", paramMap);
        return resultMap;
    }
}
