package com.ufpb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ad")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Id do anuncio", example = "1", required = false, position = 0)
    @JsonIgnore
    @JsonProperty(value = "id")
    private Long Id;

    @Column(name = "title", nullable = false, length = 40)
    @ApiModelProperty(notes = "Titulo do anuncio", example = "Casal de calopsita", required = true, position = 1)
    private String title;

    @Column(name = "description", nullable = false, length = 100)
    @ApiModelProperty(notes = "Descriçao do anuncio", example = "Casal reprodutor, mansos", required = true, position = 2)
    private String description;

    @Column(name = "registerDate", nullable = false)
    @ApiModelProperty(notes = "Data da criaçao do anuncio", example = "11/09/2001", required = true, position = 3)
    private String registerDate;

    @ManyToOne(targetEntity = People.class, fetch=FetchType.EAGER)
    @JoinColumn(name="people_id")
    @ApiModelProperty(notes = "Entidade pessoa")
    @JsonIgnore
    private People people;

    @Column(name = "people_id", insertable = false, updatable = false)
    private long people_id;

    @Column(name = "image", nullable = true)
    @ApiModelProperty(notes = "Url da imagem", example = "http://url/image.jpeg", required = false, position = 4)
    private String urlImage;

    @Column(name = "regiao", nullable = false)
    @ApiModelProperty(notes = "Regiao do Anuncio", example = "1", required = true, position = 4)
    private int regiao;

    public Ad(String title, String description, int regiao, String registerDate, People people, String urlImage) {
        this.title = title;
        this.description = description;
        this.regiao = regiao;
        this.registerDate = registerDate;
        this.people = people;
        this.urlImage = urlImage;
    }
}
