package com.donContainer.web.auth.mapper;

import com.donContainer.web.auth.dto.UserDtoRequest;
import com.donContainer.web.auth.dto.UserDtoResponse;
import com.donContainer.web.auth.entity.Userx;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public Userx userDto2Entity(UserDtoRequest dto) {
        Userx entity = new Userx();
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setRole(dto.getRole());
        return entity;
    }

    public UserDtoRequest userEntity2Dto(Userx entity) {
        UserDtoRequest dto = new UserDtoRequest();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setRole(entity.getRole());
        return dto;
    }

    public UserDtoResponse userRequest2Response(UserDtoRequest request) {
        UserDtoResponse response = new UserDtoResponse();
        response.setUsername(request.getUsername());
        return response;
    }

    public UserDtoResponse userEntity2Response(Userx entity) {
        UserDtoResponse response = new UserDtoResponse();
        response.setUsername(entity.getUsername());
        return response;
    }

    public List<Userx> usersDto2Entity(List<UserDtoRequest> usersDTOS) {
        List<Userx> userEntities = new ArrayList<>();
        for (UserDtoRequest dto : usersDTOS) {
            userEntities.add(userDto2Entity(dto));
        }
        return userEntities;
    }

    public List<UserDtoRequest> usersEntity2Dto(List<Userx> UserEntities) {
        List<UserDtoRequest> usersDTOS = new ArrayList<>();
        for (Userx entity : UserEntities) {
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

    public Userx user2Update(Userx user4Update, UserDtoRequest dto) {
        user4Update.setUsername(dto.getUsername());
        user4Update.setPassword(dto.getPassword());
        return user4Update;
    }
}
