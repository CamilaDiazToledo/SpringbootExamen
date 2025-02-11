package com.campus.restaurante.web.controller;

import com.campus.restaurante.domain.repository.UserRepository;
import com.campus.restaurante.domain.security.JWTAuthtenticationConfig;
import com.campus.restaurante.dto.LoginDto;
import com.campus.restaurante.persistence.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class LoginController {

    @Autowired
    JWTAuthtenticationConfig jwtAuthtenticationConfig;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private UserRepository userRepositorty;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("login")
    public ResponseEntity<LoginDto> login(
            @RequestParam("email") String email,
            @RequestParam("encryptedPass") String encryptedPass) {

        try {

            Optional<Users> user = userRepositorty.findByEmail(email); //SE USARIA EL IMPL
            if (passwordEncoder.matches(encryptedPass, user.get().getPassword())) {

                String token = jwtAuthtenticationConfig.getJWTToken(email);
                LoginDto userLogin = new LoginDto(email, encryptedPass, token);
                return ResponseEntity.ok(userLogin);
            } else {
                throw new ActionNotAllowed("the email or password is wrong");
            }

        } catch (NotFoundException e) {
            if (e.getMessage().contains("No user found with this email")) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new LoginDto(email, null, "Correo no encontrado"));
            } else if (e.getMessage().contains("The password does not match for the email")) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginDto(email, null, "Contraseña no coincide"));
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody CreateUserDto createUserDTO) {
        try {
            // Encriptar la contraseña
            String encryptedPassword = passwordEncoder.encode(createUserDTO.getPassword());
            createUserDTO.setPassword(encryptedPassword);

            // Guardar el usuario
            ResponseEntity<UserDto> savedUser = userServiceImpl.createUser(createUserDTO);

            return ResponseEntity.ok(savedUser.getBody());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al registrar el usuario.");
        }
    }
}
