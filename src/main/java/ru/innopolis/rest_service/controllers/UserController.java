package ru.innopolis.rest_service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.innopolis.rest_service.dto.DogDTO;
import ru.innopolis.rest_service.service.user.UserService;

import javax.sql.DataSource;
import java.util.Collection;

@RestController
@RequestMapping(path = "/rest_service")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final DataSource dataSource;

    @GetMapping(value = "/dogs")
    public Collection<DogDTO> dogs() {
        return userService.get;
    }
}
