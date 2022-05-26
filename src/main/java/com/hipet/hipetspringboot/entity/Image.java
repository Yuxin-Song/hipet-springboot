package com.hipet.hipetspringboot.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer imageid;

    private Integer withid;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private Byte[] image;

}
