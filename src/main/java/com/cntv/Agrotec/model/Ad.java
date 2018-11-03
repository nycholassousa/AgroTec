package com.cntv.Agrotec.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "ad")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Id do anuncio", example = "1", required = false, position = 0)
    private Long Id;

    @Column(name = "title", nullable = false, length = 40)
    @ApiModelProperty(notes = "Titulo do anuncio", example = "Casal de calopsita", required = true, position = 1)
    private String title;

    @Column(name = "description", nullable = false, length = 100)
    @ApiModelProperty(notes = "Descriçao do anuncio", example = "Casal reprodutor, mansos", required = true, position = 2)
    private String description;

    @Column(name = "registerDate", nullable = false)
    @ApiModelProperty(notes = "Data da criaçao do anuncio", example = "11/09/2001", required = true, position = 3)
    private Date registerDate;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="people_id")
    @ApiModelProperty(notes = "Entidade pessoa")
    private People people;
}
