package com.cntv.Agrotec.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "ad")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "title", nullable = false, length = 40)
    private String title;

    @Column(name = "description", nullable = false, length = 100)
    private String description;

    @Column(name = "registerDate", nullable = false)
    private Date registerDate;

    @ManyToOne
    @JoinColumn
    private People people;
}
