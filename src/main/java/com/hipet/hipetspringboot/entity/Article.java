package com.hipet.hipetspringboot.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer articleid;
    private Integer posterid;
    private String title;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date time;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updatetime;
}
