package com.binio.dbmaster.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonSerialize
public class Model implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "modelid")
    private Byte modelId;

    @Column(name = "modelname")
    private String modelName;

    @OneToMany( orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "model")
    @JsonIgnoreProperties("model")
    private Collection<Product> productsByModelId;


    public Collection<Product> getProductsByModelId() {
        return productsByModelId;
    }

    public void setProductsByModelId(final Collection<Product> productsByModelId) {
        this.productsByModelId = productsByModelId;
    }
}
