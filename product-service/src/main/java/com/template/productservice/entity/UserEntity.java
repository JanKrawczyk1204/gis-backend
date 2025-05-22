package com.template.productservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;
    private String login;
    private String email;
    private String role;
    private boolean isLock;
    private boolean isEnabled;
    private String firstname;
    private String lastname;
    private String phone;
    private String city;
    private String street;
    private String number;
    private String postalcode;
    private boolean iscompany;
    private String companyname;
    private String nip;
}
