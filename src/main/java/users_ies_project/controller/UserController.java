package users_ies_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import users_ies_project.entity.User;
import users_ies_project.dto.InfoCreateEditGeneric;
import users_ies_project.dto.UserDto;
import users_ies_project.repository.UserRepository;
import users_ies_project.request.UserCreateRequest;
import users_ies_project.request.UserUpdateRequest;
import users_ies_project.response.ErrorResponseDTO;

import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<UserDto> index() {
        return userRepository.findAll()
            .stream()
            .map(u -> new UserDto(u.getIdUser(), u.getName(), u.getEmail()))
            .collect(Collectors.toList());
    }

     @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable Integer id) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            User u = userOpt.get();
            UserDto dto = new UserDto(
                u.getIdUser(),
                u.getName(),
                u.getEmail()
            );
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDTO("No se encontró el usuario"));
    }

    @PostMapping
    public ResponseEntity<?> store(@Valid @RequestBody UserCreateRequest request, BindingResult result) {        
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error -> {
                errores.put(error.getField(), error.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body(errores);
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setToken(request.getToken());
        user.setDateToken(request.getDateToken());
        user.setDateCreate(new Date());
        userRepository.save(user);

        return ResponseEntity.ok("Usuario creado exitosamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,@Valid @RequestBody UserUpdateRequest request,BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error -> {
                errores.put(error.getField(), error.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body(errores);
        }
    
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            return ResponseEntity.badRequest().body("El usuario ingresado no existe");
        }
    
        User user = optionalUser.get();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setToken(request.getToken());
        user.setDateToken(request.getDateToken());
        user.setDateUpdate(new Date()); 
        userRepository.save(user);
    
        return ResponseEntity.ok("Usuario actualizado correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return ResponseEntity.ok("Usuario eliminado correctamente");
        }
        return ResponseEntity.ok(new ErrorResponseDTO("No se encontró el usuario"));
    }

    @GetMapping("/create")
    public ResponseEntity<InfoCreateEditGeneric<User>> getCreateData() {
        InfoCreateEditGeneric<User> response = new InfoCreateEditGeneric<>();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/edit")
    public ResponseEntity<?> getEditData(@PathVariable Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            InfoCreateEditGeneric<User> response = new InfoCreateEditGeneric<>();
            response.setEntity(optionalUser.get());
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.ok(new ErrorResponseDTO("No se encontró el usuario"));
    }
} 