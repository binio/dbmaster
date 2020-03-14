package com.binio.dbmaster.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Comment {
    @Id
    @Column(name = "commentid")
    private Integer commentId;
    private String comment;
}
