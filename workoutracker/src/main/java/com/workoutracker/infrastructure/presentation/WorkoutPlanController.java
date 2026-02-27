package com.workoutracker.infrastructure.presentation;

import com.workoutracker.core.entities.WorkoutPlan;
import com.workoutracker.core.usecases.CreateWorkoutPlanCase;
import com.workoutracker.infrastructure.dtos.UserWithWorkoutsResponseDto;
import com.workoutracker.infrastructure.dtos.WorkoutPlanDto;
import com.workoutracker.infrastructure.dtos.WorkoutPlanResponseDto;
import com.workoutracker.infrastructure.mapper.WorkoutPlanDtoMapper;
import com.workoutracker.infrastructure.persistence.UserEntity;
import com.workoutracker.infrastructure.persistence.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/workoutplan")
public class WorkoutPlanController {

    private final CreateWorkoutPlanCase createWorkoutPlanCase;
    private final WorkoutPlanDtoMapper workoutPlanDtoMapper;
    private final UserRepository userRepository;

    public WorkoutPlanController(CreateWorkoutPlanCase createWorkoutPlanCase, WorkoutPlanDtoMapper workoutPlanDtoMapper, UserRepository userRepository) {
        this.createWorkoutPlanCase = createWorkoutPlanCase;
        this.workoutPlanDtoMapper = workoutPlanDtoMapper;
        this.userRepository = userRepository;
    }

    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> createWorkoutPlan(@RequestBody WorkoutPlanDto workoutPlanDto) {
        WorkoutPlan newWorkoutPlan = createWorkoutPlanCase.execute(workoutPlanDtoMapper.toEntity(workoutPlanDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Mensagem: ","Treino registrado com sucesso no banco de dados!");
        response.put("Dados do plano de treino: ", workoutPlanDtoMapper.toResponseDto(newWorkoutPlan));
        return ResponseEntity.ok(response);

    }

    @GetMapping("{id}/with-workouts")
    public UserWithWorkoutsResponseDto getUserWithWorkouts(@PathVariable Long id){
        UserEntity u = userRepository.findById(id).orElseThrow();
        return new UserWithWorkoutsResponseDto(
                u.getId(), u.getUsername(),
                u.getWorkoutPlans().stream()
                        .map(wp -> new WorkoutPlanResponseDto(wp.getId(), u.getId(), wp.getName(), wp.getCreatedAt()))
                        .toList()
        );
    }
}
