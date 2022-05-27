package com.hipet.hipetspringboot.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vid;

    private Integer petid;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean v1;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean v2;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean v3;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean v4;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean test;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean v5;
}
