//package com.donContainer.web.auth.service;
//
//import com.donContainer.web.auth.dto.UserDtoRequest;
//import com.donContainer.web.auth.dto.UserDtoResponse;
//import com.donContainer.web.auth.entity.Userx;
//import com.donContainer.web.auth.mapper.UserMapper;
//import com.donContainer.web.auth.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.persistence.EntityNotFoundException;
//import javax.servlet.http.HttpSession;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//@Service
//public class UserServiceImpl implements IUserService {
//
//    private static final String USER_NOT_FOUND_MESSAGE = "Usuario no encontardo.";
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private UserMapper userMapper;
//
//
//    @Override
//    public UserDtoResponse save(UserDtoRequest dto) {
//        return null;
//    }
//
//    @Override
//    public UserDtoResponse update(Long id, UserDtoRequest dto) {
//        return null;
//    }
//
//    @Override
//    public void delete(Long id) throws EntityNotFoundException {
//
//    }
//
//    @Override
//    public UserDtoResponse getUserById(Long id) {
//        return null;
//    }
//
//    @Override
//    public UserDtoResponse getUserByUsername(String username) {
//        return null;
//    }
//
//    @Override
//    public List<UserDtoResponse> getAllUsers() {
//        return null;
//    }
//
//    @Override
//    public UserDtoResponse makeAdmin(Long id) {
//        return null;
//    }
//
////    @Override
////    public Collection<? extends GrantedAuthority> getAuthorities() {
////        return null;
////    }
//
//    public String getPassword() {
//        return getPassword();
//    }
//
//    public String getUsername() {
//        return getUsername();
//    }
//
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    public boolean isEnabled() {
//        return true;
//    }
//
//
//}