//package com.donContainer.web.auth.service;
//
//import com.donContainer.web.auth.dto.UserDtoRequest;
//import com.donContainer.web.auth.dto.UserDtoResponse;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetailsService;
//
//import javax.persistence.EntityNotFoundException;
//import java.util.Collection;
//import java.util.List;
//
//public interface IUserService extends UserDetailsServiceCustom {
//
//    UserDtoResponse save(UserDtoRequest dto);
//
//    UserDtoResponse update(Long id, UserDtoRequest dto);
//
//    void delete(Long id) throws EntityNotFoundException;
//
//    UserDtoResponse getUserById(Long id);
//
//    UserDtoResponse getUserByUsername(String username);
//
//    List<UserDtoResponse> getAllUsers();
//
//    UserDtoResponse makeAdmin(Long id); //Solo desde una cuenta ADMIN
//
//    Collection<? extends GrantedAuthority> getAuthorities();
//
//    String getPassword();
//
//    String getUsername();
//
//    boolean isAccountNonExpired();
//
//    boolean isAccountNonLocked();
//
//    boolean isCredentialsNonExpired();
//
//    boolean isEnabled();
//}
