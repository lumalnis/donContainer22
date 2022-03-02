package com.donContainer.web.auth.controller;

import com.donContainer.web.auth.dto.UserDtoRequest;
import com.donContainer.web.auth.dto.UserDtoResponse;
import com.donContainer.web.auth.service.UserDetailsServiceCustom;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDetailsServiceCustom userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDtoResponse> getUserById(@PathVariable Long id) {
        UserDtoResponse response = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<List<UserDtoResponse>> getAllUsers() {
        List<UserDtoResponse> users = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PostMapping
    public ResponseEntity<UserDtoResponse> save(@RequestBody UserDtoRequest dto) {
        UserDtoResponse response = userService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDtoResponse> update(@PathVariable Long id, @RequestBody UserDtoRequest dto) {
        UserDtoResponse response = userService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("admin/{id}")
    public ResponseEntity<UserDtoResponse> makeAdmin(@PathVariable Long id) {
        UserDtoResponse response = userService.makeAdmin(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Empty> remove(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
