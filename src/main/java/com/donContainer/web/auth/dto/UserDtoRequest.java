package com.donContainer.web.auth.dto;

import com.donContainer.web.auth.enums.Role;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserDtoRequest {

    private Long id;

    @Email(message = "El usuario debe ser un email")
    private String username;

    @Size(min = 8, message = "La contraseña debe contener 8 caracteres como mínimo")
    private String password;

    private Role role;

}
