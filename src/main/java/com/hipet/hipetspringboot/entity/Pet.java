package com.hipet.hipetspringboot.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer petid;
    private Integer ownerid;
    private String petname;
    private String petsex;
    private String petbreed;

    @Temporal(TemporalType.TIMESTAMP)
    private Date petbirth;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean petpreg;
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean petdeworm;

}
