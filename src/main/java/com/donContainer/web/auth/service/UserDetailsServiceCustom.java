package com.donContainer.web.auth.service;

import com.donContainer.web.auth.dto.UserDtoRequest;
import com.donContainer.web.auth.dto.UserDtoResponse;
import com.donContainer.web.auth.entity.Userx;
import com.donContainer.web.auth.enums.ApplicationRole;
import com.donContainer.web.auth.mapper.UserMapper;
import com.donContainer.web.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceCustom implements UserDetailsService {

    private static final String USER_NOT_FOUND_MESSAGE = "Usuario no encontardo.";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Userx userx = findByUsername(username);
            User user;
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_" + userx.getRole()));

            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder
                    .currentRequestAttributes();

            HttpSession session = attr.getRequest().getSession(true);
            session.setAttribute("usuariosession", userx);

            return new User(username, userx.getPassword(), authorities);
        } catch (Exception e) {
            throw new UnsupportedOperationException("El usuario no existe.");
        }
    }

    public UserDtoResponse save(UserDtoRequest dto) {
        dto.setRole(ApplicationRole.USER);
        Userx userEntity = userMapper.userDto2Entity(dto);
        Userx userSaved = userRepository.save(userEntity);
        UserDtoResponse response = userMapper.userEntity2Response(userSaved);
        return response;
    }


    public UserDtoResponse update(Long id, UserDtoRequest dto) {
        if (!userRepository.existsById(id)) {
            throw new UsernameNotFoundException(USER_NOT_FOUND_MESSAGE);
        }
        Userx userEntity = userRepository.getById(id);
        Userx userUpdated = userMapper.user2Update(userEntity, dto);
        Userx userSaved = userRepository.save(userUpdated);
        UserDtoResponse response = userMapper.userEntity2Response(userSaved);
        return response;
    }

//    @Override
//    public void delete(Long id) throws EntityNotFoundException {
//        User user = userRepository.getById(id);
//        user.setSoftDeleted(true);
//        userRepository.save(user);
//    }


    public void delete(Long id) throws EntityNotFoundException {
        Userx user = userRepository.getById(id);
        userRepository.delete(user);
    }

    public UserDtoResponse getUserById(Long id) {
        if (userRepository.findById(id) == null) {
            throw new UsernameNotFoundException(USER_NOT_FOUND_MESSAGE);
        }
        Userx userEntity = userRepository.findById(id).get();
        UserDtoRequest request = userMapper.userEntity2Dto(userEntity);
        UserDtoResponse response = userMapper.userRequest2Response(request);
        return response;
    }

    public UserDtoResponse getUserByUsername(String username) {
        if (userRepository.findByUsername(username) == null) {
            throw new UsernameNotFoundException(USER_NOT_FOUND_MESSAGE);
        }
        Userx userEntity = userRepository.findByUsername(username);
        UserDtoRequest request = userMapper.userEntity2Dto(userEntity);
        UserDtoResponse response = userMapper.userRequest2Response(request);
        return response;
    }

    public Userx findByUsername(String username) {
        if (userRepository.findByUsername(username) == null) {
            throw new UsernameNotFoundException(USER_NOT_FOUND_MESSAGE);
        }
        Userx userEntity = userRepository.findByUsername(username);
        return userEntity;
    }

    public List<UserDtoResponse> getAllUsers() {
        if (userRepository.findAll() == null) {
            throw new UsernameNotFoundException(USER_NOT_FOUND_MESSAGE);
        }
        List<Userx> users = userRepository.findAll();
        List<UserDtoRequest> requests = userMapper.usersEntity2Dto(users);
        List<UserDtoResponse> responses = userMapper.requests2Responses(requests);
        return responses;
    }


    public UserDtoResponse makeAdmin(Long id) {
        if (userRepository.findById(id) == null) {
            throw new UsernameNotFoundException(USER_NOT_FOUND_MESSAGE);
        }
        Userx forAdmin = userRepository.getById(id);
        forAdmin.setRole(ApplicationRole.ADMIN);
        Userx admin = userRepository.save(forAdmin);
        UserDtoResponse response = userMapper.userEntity2Response(admin);
        return response;
    }

}
