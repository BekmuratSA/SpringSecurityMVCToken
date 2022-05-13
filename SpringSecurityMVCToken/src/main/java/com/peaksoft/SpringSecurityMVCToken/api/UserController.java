package com.peaksoft.SpringSecurityMVCToken.api;

import com.peaksoft.SpringSecurityMVCToken.config.JWTTokenUtil;
import com.peaksoft.SpringSecurityMVCToken.exception.ValidationExceptionType;
import com.peaksoft.SpringSecurityMVCToken.dto.authority.AuthRequest;
import com.peaksoft.SpringSecurityMVCToken.dto.authority.AuthResponse;
import com.peaksoft.SpringSecurityMVCToken.dto.user.UserRequest;
import com.peaksoft.SpringSecurityMVCToken.dto.user.UserResponse;
import com.peaksoft.SpringSecurityMVCToken.mappers.authority.AuthViewMapper;
import com.peaksoft.SpringSecurityMVCToken.models.securityModels.User;
import com.peaksoft.SpringSecurityMVCToken.repository.UserRepository;
import com.peaksoft.SpringSecurityMVCToken.service.UserServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jwt")
@Tag(name = "Authentication", description = "User description")
public class UserController {

    private final UserServiceImpl service;
    private final UserRepository repository;
    private final JWTTokenUtil tokenUtil;
    private final AuthViewMapper viewMapper;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(request.getEmail(),
                            request.getPassword());
            User user = repository.findByEmail(authenticationToken.getName()).get();
            return ResponseEntity.ok().body(viewMapper.viewAuth(tokenUtil.generationToken(user),
                    ValidationExceptionType.Successfully, user));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(viewMapper.viewAuth
                    ("", ValidationExceptionType.LOGIN_FAILED, null));
        }
    }

    @PostMapping("/create")
    public UserResponse createUser(@RequestBody UserRequest request) {
        return service.createUser(request);
    }

    @PutMapping("/update/{id}")
    public UserResponse updateUser(@RequestBody UserRequest request, @PathVariable Long id) {
        return service.updateUser(request, id);
    }

    @GetMapping("/getById/{id}")
    public UserResponse getByIdUser(@PathVariable Long id) {
        return service.getByIdUser(id);
    }

    @DeleteMapping("/delete/{id}")
    public UserResponse deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @GetMapping("/getAll")
    public List<UserResponse> getAllUsers() {
        return service.getAllUsers();
    }
}
