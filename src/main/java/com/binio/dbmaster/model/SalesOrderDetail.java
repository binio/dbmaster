package com.binio.dbmaster.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sales_order_detail")
public class SalesOrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sales_order_detail_id")
    private Long salesOrderDetailId;

    @OneToOne
    @JoinColumn(name = "sales_order_header_id", foreignKey = @ForeignKey(name = "FK_SALES_ORDER_HEADER"))
    private SalesOrderHeader salesOrderHeaderId;

    @ManyToOne
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "FK_PRODUCT"))
    private Product productId;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "rabate")
    private BigDecimal rabate;

    @Column(name = "total_price")
    private BigDecimal totalPrice;
}
