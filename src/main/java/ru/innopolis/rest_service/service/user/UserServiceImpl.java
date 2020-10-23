package ru.innopolis.rest_service.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.innopolis.rest_service.dto.UserDTO;
import ru.innopolis.rest_service.entity.User;
import ru.innopolis.rest_service.repository.UserRepository;
import ru.innopolis.rest_service.util.DTOConverter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

@Service("userService")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Collection<UserDTO> getUsers() {
        List<UserDTO> list = new ArrayList<>();
        Iterable<User> all = userRepository.findAll();
        for (User user : all) {
            list.add(DTOConverter.userConvertToDTO(user));
        }
        list.sort(Comparator.comparing(UserDTO::getName));
        return list;
    }
}

