package com.hipet.hipetspringboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date petbirth;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean petpreg;
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean petdeworm;

}
