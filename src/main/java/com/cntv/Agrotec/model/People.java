package com.cntv.Agrotec.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pessoa")
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username", nullable = false, length = 20, unique = true)
    private String username;
    @Column(name = "password", nullable = false, length = 20)
    private String password;

    @Column(name = "firstname", nullable = false, length = 20)
    private String firstName;
    @Column(name = "lastname", nullable = false, length = 20)
    private String lastName;

    @Column(name = "email", nullable = false, length = 20, unique = true)
    private String email;
    @Column(name = "phone", nullable = false, length = 20, unique = true)
    private String phone;

    public People() {}

    public People(String username, String password, String firstName, String lastName, String email, String phone) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
}
