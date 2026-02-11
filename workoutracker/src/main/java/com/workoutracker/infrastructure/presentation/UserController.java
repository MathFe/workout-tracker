package com.workoutracker.infrastructure.presentation;

import com.workoutracker.core.entities.User;
import com.workoutracker.core.usecases.CreateUserCase;
import com.workoutracker.core.usecases.ListUserCase;
import com.workoutracker.infrastructure.dtos.UserDto;
import com.workoutracker.infrastructure.dtos.UserResponseDto;
import com.workoutracker.infrastructure.mapper.UserDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/workoutracker/")
public class UserController {

    private final CreateUserCase createUserCase;
    private final ListUserCase listUserCase;
    private final UserDtoMapper userDtoMapper;

    public UserController(CreateUserCase createUserCase, ListUserCase listUserCase, UserDtoMapper userDtoMapper) {
        this.createUserCase = createUserCase;
        this.listUserCase = listUserCase;
        this.userDtoMapper = userDtoMapper;
    }

    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody UserDto userDto) {
        User newUser = createUserCase.execute(userDtoMapper.toEntity(userDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Mensagem: ","Usuário registrado com sucesso no banco de dados!");
        response.put("Dados do usuário: ",userDtoMapper.toResponseDto(newUser));
        return ResponseEntity.ok(response);
    }

    @GetMapping("list")
    public List<UserResponseDto> listUsers(){
        List<User> users =  listUserCase.execute();
        return  users.stream()
                .map(userDtoMapper  ::toResponseDto)
                .collect(Collectors.toList());
    }
}
