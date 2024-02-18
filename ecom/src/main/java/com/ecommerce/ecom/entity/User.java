package com.ecommerce.ecom.entity;

import com.ecommerce.ecom.enums.UserRol;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_user;

    private String email;
    private String password;
    private String name;
    private UserRol role;

    @Lob
    @Column(name = "image", columnDefinition = "longblob")
    private byte[] image;

}
