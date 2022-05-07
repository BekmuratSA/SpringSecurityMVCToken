package com.peaksoft.SpringSecurityMVCToken.mappers.authoruty;

import com.peaksoft.SpringSecurityMVCToken.dto.authority.AuthResponse;
import com.peaksoft.SpringSecurityMVCToken.models.securityModels.Role;
import com.peaksoft.SpringSecurityMVCToken.models.securityModels.User;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class AuthViewMapper {

    public AuthResponse viewAuth(String token, String message, User user) {
        var authResponse = new AuthResponse();
        if (user != null) {
            setAuthority(authResponse, user.getRoles());
        }
        authResponse.setJwtToken(token);
        authResponse.setMessage(message);
        return authResponse;
    }


    private void setAuthority(AuthResponse response, List<Role> roles) {
        Set<String> authorities = new HashSet<>();
        for (Role role : roles) {
            authorities.add(role.getName());
        }
        response.setAuthorities(authorities);
    }
}
