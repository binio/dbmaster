package com.binio.dbmaster.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "status")
public class Status {

    @Id
    @Column(name = "status_id")
    private Long statusId;

    @Column(name = "status_name")
    private String statusName;

}
