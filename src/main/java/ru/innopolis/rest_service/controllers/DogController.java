package ru.innopolis.rest_service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.rest_service.dto.DogDTO;
import ru.innopolis.rest_service.repository.DogRepository;
import ru.innopolis.rest_service.service.dog.DogService;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/rest_service")
@RequiredArgsConstructor
public class DogController {

    private final DogService dogService;
    private final DataSource dataSource;

    @GetMapping(value = "/dogs")
    public Collection<DogDTO> dogs() {
        return dogService.getDogs();
    }

    @GetMapping("/dogs/{row_id}")
    public Object getDogByIdJdbc(
            @PathVariable("row_id") Integer id) {
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        Map<String, Integer> paramMap = new HashMap<>();
        paramMap.put("id", id);
        Map<String, Object> resultMap = jdbcTemplate.queryForMap("SELECT * FROM dogs WHERE id=:id", paramMap);
        return resultMap;
    }
}
