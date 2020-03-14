package com.binio.dbmaster.model;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sales_order_header")
public class SalesOrderHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sales_order_heder_id")
    private Long salesOrderHederId;

    @OneToOne
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "FK_CUSTOMER"))
    private Customer customerId;

    @OneToOne
    @JoinColumn(name = "sale_person_id", foreignKey = @ForeignKey(name = "FK_EMPLOYEE"))
    private Employee salesPersonId;


    @OneToOne
    @JoinColumn(name = "status_id", foreignKey = @ForeignKey(name = "FK_STATUS"))
    private Status statusId;

    @Column(name = "order_date")
    private ZonedDateTime orderDate;

    @Column(name = "ship_date")
    private ZonedDateTime shipDate;

    @Column(name = "delivery_date")
    private ZonedDateTime deliveryDate;
}
