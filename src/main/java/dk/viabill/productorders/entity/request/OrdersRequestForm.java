/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.viabill.productorders.entity.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author victor.zaitev
 * @version 1.0
 * @since 2018-12-09
 */
public class OrdersRequestForm {

    @NotNull
    @NotEmpty
    @JsonProperty("email")
    private String email;

    @NotNull
    @JsonProperty("order_details")
    List<OrderDetailsRequestForm> orderDetails = new ArrayList<>();

    public OrdersRequestForm() {
    }

    public OrdersRequestForm(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<OrderDetailsRequestForm> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailsRequestForm> orderDetails) {
        this.orderDetails = orderDetails;
    }

}
