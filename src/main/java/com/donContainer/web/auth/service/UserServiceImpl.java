package com.donContainer.web.auth.service;

import com.donContainer.web.auth.dto.UserDtoRequest;
import com.donContainer.web.auth.dto.UserDtoResponse;
import com.donContainer.web.auth.entity.User;
import com.donContainer.web.auth.enums.Role;
import com.donContainer.web.auth.mapper.UserMapper;
import com.donContainer.web.auth.repository.UserRepository;
import com.donContainer.web.exceptions.NotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private static final String USER_NOT_FOUND_MESSAGE = "Usuario no encontardo.";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDtoResponse save(UserDtoRequest dto) {
        dto.setRole(Role.USER);
        User userEntity = userMapper.userDto2Entity(dto);
        User userSaved = userRepository.save(userEntity);
        UserDtoResponse response = userMapper.userEntity2Response(userSaved);
        return response;
    }

    @Override
    public UserDtoResponse update(Long id, UserDtoRequest dto) {
        if (!userRepository.existsById(id)) {
            throw new NotFoundExceptions(USER_NOT_FOUND_MESSAGE);
        }
        User userEntity = userRepository.getById(id);
        User userUpdated = userMapper.user2Update(userEntity, dto);
        User userSaved = userRepository.save(userUpdated);
        UserDtoResponse response = userMapper.userEntity2Response(userSaved);
        return response;
    }

//    @Override
//    public void delete(Long id) throws EntityNotFoundException {
//        User user = userRepository.getById(id);
//        user.setSoftDeleted(true);
//        userRepository.save(user);
//    }

    @Override
    public void delete(Long id) throws EntityNotFoundException {
        User user = userRepository.getById(id);
        userRepository.delete(user);
    }

    @Override
    public UserDtoResponse getUserById(Long id) {
        if (userRepository.findById(id) == null) {
            throw new NotFoundExceptions(USER_NOT_FOUND_MESSAGE);
        }
        User userEntity = userRepository.findById(id).get();
        UserDtoRequest request = userMapper.userEntity2Dto(userEntity);
        UserDtoResponse response = userMapper.userRequest2Response(request);
        return response;
    }

    @Override
    public UserDtoResponse getUserByUsername(String username) {
        if (userRepository.findByUsername(username) == null) {
            throw new NotFoundExceptions(USER_NOT_FOUND_MESSAGE);
        }
        User userEntity = userRepository.findByUsername(username);
        UserDtoRequest request = userMapper.userEntity2Dto(userEntity);
        UserDtoResponse response = userMapper.userRequest2Response(request);
        return response;
    }

    @Override
    public List<UserDtoResponse> getAllUsers() {
        if (userRepository.findAll() == null) {
            throw new NotFoundExceptions(USER_NOT_FOUND_MESSAGE);
        }
        List<User> users = userRepository.findAll();
        List<UserDtoRequest> requests = userMapper.usersEntity2Dto(users);
        List<UserDtoResponse> responses = userMapper.requests2Responses(requests);
        return responses;
    }

    @Override
    public UserDtoResponse makeAdmin(Long id) {
        if (userRepository.findById(id) == null) {
            throw new NotFoundExceptions(USER_NOT_FOUND_MESSAGE);
        }
        User forAdmin = userRepository.getById(id);
        forAdmin.setRole(Role.ADMIN);
        User admin = userRepository.save(forAdmin);
        UserDtoResponse response = userMapper.userEntity2Response(admin);
        return response;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (userRepository.findByUsername(username) == null) {
            throw new NotFoundExceptions(USER_NOT_FOUND_MESSAGE);
        }
        User usuario = userRepository.findByUsername(username);

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("PROYECTOS")); //VIDEOS NAHU

        return new org.springframework.security.core.userdetails.User(username, usuario.getPassword(), authorities);
    }
}