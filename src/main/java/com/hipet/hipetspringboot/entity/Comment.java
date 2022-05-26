package com.hipet.hipetspringboot.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentid;
    private Integer commenterid;
    private Integer toid;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createtime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatetime;
}
