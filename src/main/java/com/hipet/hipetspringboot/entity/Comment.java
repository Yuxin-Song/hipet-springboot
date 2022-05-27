package com.hipet.hipetspringboot.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentid;
    private Integer commenterid;
    private Integer toid;  // Comment to the article, toid is the id of the article

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createtime;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updatetime;
}
