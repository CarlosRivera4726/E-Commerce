package com.ecommerce.ecom.dto;

import java.util.UUID;

import com.ecommerce.ecom.enums.UserRol;

import lombok.Data;

@Data
public class UserDto {
    private UUID id_user;
    private String email;
    private String name;
    private UserRol rol;

}
