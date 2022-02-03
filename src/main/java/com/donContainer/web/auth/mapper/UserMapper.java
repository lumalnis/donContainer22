package com.donContainer.web.auth.mapper;

import com.donContainer.web.auth.dto.UserDtoRequest;
import com.donContainer.web.auth.dto.UserDtoResponse;
import com.donContainer.web.auth.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public User userDto2Entity(UserDtoRequest dto) {
        User entity = new User();
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setRole(dto.getRole());
        return entity;
    }

    public UserDtoRequest userEntity2Dto(User entity) {
        UserDtoRequest dto = new UserDtoRequest();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setRole(entity.getRole());
        return dto;
    }

    public UserDtoResponse userRequest2Response(UserDtoRequest request){
        UserDtoResponse response = new UserDtoResponse();
        response.setUsername(request.getUsername());
        return response;
    }

    public UserDtoResponse userEntity2Response(User entity){
        UserDtoResponse response = new UserDtoResponse();
        response.setUsername(entity.getUsername());
        return response;
    }

    public List<User> usersDto2Entity(List<UserDtoRequest> usersDTOS) {
        List<User> userEntities = new ArrayList<>();
        for (UserDtoRequest dto : usersDTOS) {
            userEntities.add(userDto2Entity(dto));
        }
        return userEntities;
    }

    public List<UserDtoRequest> usersEntity2Dto(List<User> userEntities) {
        List<UserDtoRequest> usersDTOS = new ArrayList<>();
        for (User entity : userEntities) {
            usersDTOS.add(userEntity2Dto(entity));
        }
        return usersDTOS;
    }

    public List<UserDtoResponse> requests2Responses(List<UserDtoRequest> requests) {
        List<UserDtoResponse> responses = new ArrayList<>();
        for (UserDtoRequest request : requests) {
            responses.add(userRequest2Response(request));
        }
        return responses;
    }

    public User user2Update(User user4Update, UserDtoRequest dto) {
        user4Update.setUsername(dto.getUsername());
        user4Update.setPassword(dto.getPassword());
        return user4Update;
    }


}
