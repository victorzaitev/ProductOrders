package dk.viabill.productorders.entity;
// Generated Dec 8, 2018 4:40:16 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * OrderDetails generated by hbm2java
 */
@Entity
@Table(name = "OrderDetails"
)
public class OrderDetails implements java.io.Serializable {

    private int id;
    private Orders orders;
    private Products products;
    private BigDecimal unitPrice;
    private Integer quantity;

    public OrderDetails() {
    }

    public OrderDetails(int id) {
        this.id = id;
    }

    public OrderDetails(int id, Orders orders, Products products, BigDecimal unitPrice, Integer quantity) {
        this.id = id;
        this.orders = orders;
        this.products = products;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    @Cascade(CascadeType.ALL)
    public Orders getOrders() {
        return this.orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    public Products getProducts() {
        return this.products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    @Column(name = "unitPrice", precision = 10)
    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Column(name = "quantity")
    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
