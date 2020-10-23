package ru.innopolis.rest_service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.innopolis.rest_service.dto.UserDTO;
import ru.innopolis.rest_service.service.user.UserService;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/rest_service")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final DataSource dataSource;

    @GetMapping(value = "/users")
    public Collection<UserDTO> users() {
        return userService.getUsers();
    }

    @GetMapping("/users/{row_id}")
    public Object getUserByIdJdbc(
            @PathVariable("row_id") Integer id) {
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        Map<String, Integer> paramMap = new HashMap<>();
        paramMap.put("id", id);
        Map<String, Object> resultMap = jdbcTemplate.queryForMap("SELECT * FROM users WHERE id=:id", paramMap);
        return resultMap;
    }
}
