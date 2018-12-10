/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.viabill.productorders.entity.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.NumberFormat;

/**
 *
 * @author victor.zaitev
 * @version 1.0
 * @since 2018-12-09
 */
public class ProductRequestForm {

    @NotNull
    @NotEmpty
    @JsonProperty("name")
    private String name;

    @NotNull
    @NumberFormat
    @DecimalMin("0.01")
    @JsonProperty("unit_price")
    private BigDecimal unitPrice;

    public ProductRequestForm() {
    }

    public ProductRequestForm(String name, BigDecimal unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "ProductRequestForm{" + "name=" + name + ", unitPrice=" + unitPrice + '}';
    }

}
