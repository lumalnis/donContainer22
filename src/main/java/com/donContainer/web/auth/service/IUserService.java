package com.donContainer.web.auth.service;

import com.donContainer.web.auth.dto.UserDtoRequest;
import com.donContainer.web.auth.dto.UserDtoResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface IUserService extends UserDetailsService {

    UserDtoResponse save(UserDtoRequest dto);

    UserDtoResponse update(Long id, UserDtoRequest dto);

    void delete(Long id) throws EntityNotFoundException;

    UserDtoResponse getUserById(Long id);

    UserDtoResponse getUserByUsername(String username);

    List<UserDtoResponse> getAllUsers();

    UserDtoResponse makeAdmin(Long id); //Solo desde una cuenta ADMIN

    UserDetails loadUserByUsername(String username);
}
