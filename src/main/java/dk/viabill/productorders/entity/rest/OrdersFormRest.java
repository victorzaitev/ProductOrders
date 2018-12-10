/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.viabill.productorders.entity.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author victor.zaitev
 * @version 1.0
 * @since 2018-12-09
 */
public class OrdersFormRest {

    @JsonProperty("customer_email")
    private String customerEmail;

    @JsonProperty("order_date")
    private Date orderDate;

    @JsonProperty("total_amount")
    private BigDecimal totalAmount;

    private Set<OrdersDetailsFormRest> ordersDetailsFormRests = new HashSet<>();

    public OrdersFormRest() {
    }

    public OrdersFormRest(String customerEmail, Date orderDate) {
        this.customerEmail = customerEmail;
        this.orderDate = orderDate;
    }

    public OrdersFormRest(String customerEmail, Date orderDate, BigDecimal totalAmount) {
        this.customerEmail = customerEmail;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Set<OrdersDetailsFormRest> getOrdersDetailsFormRests() {
        return ordersDetailsFormRests;
    }

    public void setOrdersDetailsFormRests(Set<OrdersDetailsFormRest> ordersDetailsFormRests) {
        this.ordersDetailsFormRests = ordersDetailsFormRests;
    }

}
