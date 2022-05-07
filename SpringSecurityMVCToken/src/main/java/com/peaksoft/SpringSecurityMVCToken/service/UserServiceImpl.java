package com.peaksoft.SpringSecurityMVCToken.service;

import com.peaksoft.SpringSecurityMVCToken.dto.user.UserRequest;
import com.peaksoft.SpringSecurityMVCToken.dto.user.UserResponse;
import com.peaksoft.SpringSecurityMVCToken.mappers.user.UserEditMapper;
import com.peaksoft.SpringSecurityMVCToken.mappers.user.UserViewMapper;
import com.peaksoft.SpringSecurityMVCToken.models.securityModels.User;
import com.peaksoft.SpringSecurityMVCToken.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService {

    private final UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserEditMapper editMapper;
    private final UserViewMapper viewMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException("User with email not found"));
    }

    public UserResponse createUser(UserRequest request) {
        User user = editMapper.createUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setIsActive(true);
        repository.save(user);
        return viewMapper.viewUser(user);
    }

    public UserResponse updateUser(UserRequest request, Long id) {
        User user = repository.getById(id);
        editMapper.updateUser(user, request);
        return viewMapper.viewUser(repository.save(user));
    }

    public UserResponse getByIdUser(Long id) {
        User user = repository.getById(id);
        return viewMapper.viewUser(user);
    }

    public List<UserResponse> getAllUsers() {
        return viewMapper.viewUsers(repository.findAll());
    }

    public UserResponse deleteById(Long id) {
        User user = repository.getById(id);
        repository.deleteById(id);
        return viewMapper.viewUser(user);
    }
}
