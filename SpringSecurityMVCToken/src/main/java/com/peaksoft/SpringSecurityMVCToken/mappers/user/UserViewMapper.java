package com.peaksoft.SpringSecurityMVCToken.mappers.user;

import com.peaksoft.SpringSecurityMVCToken.dto.user.UserResponse;
import com.peaksoft.SpringSecurityMVCToken.models.securityModels.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserViewMapper {

    public UserResponse viewUser(User user) {
        if (user == null) {
            return null;
        }
        UserResponse response = new UserResponse();
        if (user.getId() != null) {
            response.setId(user.getId());
        }
        response.setFirstname(user.getFirstname());
        response.setLastname(user.getLastname());
        response.setEmail(user.getEmail());
        response.setCreated(user.getCreated());
        response.setIsActive(user.getIsActive());
        return response;
    }

    public List<UserResponse> viewUsers(List<User> users) {
        List<UserResponse> responses = new ArrayList<>();
        for (User user : users) {
            responses.add(viewUser(user));
        }
        return responses;
    }
}
