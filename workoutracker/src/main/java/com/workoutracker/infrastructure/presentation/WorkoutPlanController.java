package com.workoutracker.infrastructure.presentation;

import com.workoutracker.core.entities.WorkoutPlan;
import com.workoutracker.core.usecases.CreateWorkoutPlanCase;
import com.workoutracker.infrastructure.dtos.WorkoutPlanDto;
import com.workoutracker.infrastructure.mapper.WorkoutPlanDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/workoutplan")
public class WorkoutPlanController {

    private final CreateWorkoutPlanCase createWorkoutPlanCase;
    private final WorkoutPlanDtoMapper workoutPlanDtoMapper;

    public WorkoutPlanController(CreateWorkoutPlanCase createWorkoutPlanCase, WorkoutPlanDtoMapper workoutPlanDtoMapper) {
        this.createWorkoutPlanCase = createWorkoutPlanCase;
        this.workoutPlanDtoMapper = workoutPlanDtoMapper;
    }

    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> createWorkoutPlan(@RequestBody WorkoutPlanDto workoutPlanDto) {
        WorkoutPlan newWorkoutPlan = createWorkoutPlanCase.execute(workoutPlanDtoMapper.toEntity(workoutPlanDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Mensagem: ","Usuário registrado com sucesso no banco de dados!");
        response.put("Dados do plano de treino: ", workoutPlanDtoMapper.toResponseDto(newWorkoutPlan));
        return ResponseEntity.ok(response);

    }
}
