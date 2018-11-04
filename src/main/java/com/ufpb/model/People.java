package com.ufpb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "pessoa")
@ApiModel(description = "Classe que representa uma pessoa na aplicaçao")
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "Identificador unico por pessoa, cada um so possui apenas 1 (um) id", example = "1", required = false, position = 0)
    @JsonIgnore
    private Long Id;

    @Column(name = "username", nullable = false, length = 20, unique = true)
    @ApiModelProperty(notes = "Nome de usuario da pessoa", example = "agricultor2018", required = true, position = 1)
    private String username;

    @Column(name = "password", nullable = false, length = 20)
    @ApiModelProperty(notes = "Senha do usuario", example = "123456", required = true, position = 2)
    private String password;

    @Column(name = "firstname", nullable = false, length = 20)
    @ApiModelProperty(notes = "Primeiro nome do usuario", example = "Oscar", required = true, position = 3)
    private String firstName;

    @Column(name = "lastname", nullable = false, length = 20)
    @ApiModelProperty(notes = "Ultimo nome do usuario", example = "Alho", required = true, position = 4)
    private String lastName;

    @Column(name = "email", nullable = false, length = 20, unique = true)
    @ApiModelProperty(notes = "Email do usuario", example = "email@email.com", required = true, position = 5)
    private String email;

    @Column(name = "phone", nullable = false, length = 20, unique = true)
    @ApiModelProperty(notes = "Telefone do usuario", example = "11988887777", required = true, position = 6)
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
