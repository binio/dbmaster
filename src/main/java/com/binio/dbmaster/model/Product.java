package com.binio.dbmaster.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize
public class Product implements  Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Short productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_subcategory_id")
    @JsonIgnore
    private ProductSubcategory productSubcategory;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "unit_price", precision=10, scale=2)
    private BigDecimal unitPrice;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="model_id", foreignKey = @ForeignKey(name = "FK_MODEL"))
    @JsonIgnoreProperties("productsByModelId")
    private Model model;
}
