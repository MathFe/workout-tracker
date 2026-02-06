package com.workoutracker.infrastructure.presentation;

import com.workoutracker.core.entities.User;
import com.workoutracker.core.usecases.CreateUserCase;
import com.workoutracker.infrastructure.dtos.UserDto;
import com.workoutracker.infrastructure.mapper.UserDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/workoutracker/")
public class UserController {

    private final CreateUserCase createUserCase;
    private final UserDtoMapper userDtoMapper;

    public UserController(CreateUserCase createUserCase, UserDtoMapper userDtoMapper) {
        this.createUserCase = createUserCase;
        this.userDtoMapper = userDtoMapper;
    }

    @PostMapping("createuser")
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody UserDto userDto) {
        User newUser = createUserCase.execute(userDtoMapper.toEntity(userDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Mensagem: ","Usuário registrado com sucesso no banco de dados!");
        response.put("Dados do usuário: ",userDtoMapper.toResponseDto(newUser));
        return ResponseEntity.ok(response);
    }
}
