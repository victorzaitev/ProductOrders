/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.viabill.productorders.entity.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.NumberFormat;

/**
 *
 * @author victor.zaitev
 * @version 1.0
 * @since 2018-12-09
 */
public class OrderDetailsRequestForm {

    @NotNull
    @NotEmpty
    @JsonProperty("products_name")
    private String productsName;

    @NotNull
    @NumberFormat
    @DecimalMin("0.01")
    @JsonProperty("unit_price")
    private BigDecimal unitPrice;

    @NotNull
    @Min(1)
    private Integer quantity;

    public OrderDetailsRequestForm() {
    }

    public OrderDetailsRequestForm(String productsName, BigDecimal unitPrice, Integer quantity) {
        this.productsName = productsName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getProductsName() {
        return productsName;
    }

    public void setProductsName(String productsName) {
        this.productsName = productsName;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
