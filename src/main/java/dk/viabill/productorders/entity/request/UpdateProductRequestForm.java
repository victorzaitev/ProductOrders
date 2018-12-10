/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.viabill.productorders.entity.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.NumberFormat;

/**
 *
 * @author victor.zaitev
 * @version 1.0
 * @since 2018-12-09
 */
public class UpdateProductRequestForm extends ProductRequestForm {

    @NotNull
    @NumberFormat
    @JsonProperty("id")
    private int id;

    public UpdateProductRequestForm() {
    }

    public UpdateProductRequestForm(int id) {
        this.id = id;
    }

    public UpdateProductRequestForm(int id, String name, BigDecimal unitPrice) {
        super(name, unitPrice);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
