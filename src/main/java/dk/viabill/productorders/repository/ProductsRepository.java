/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.viabill.productorders.repository;

import dk.viabill.productorders.entity.Products;
import dk.viabill.productorders.entity.rest.ProductsFormRest;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author victor.zaitev
 * @version 1.0
 * @since 2018-12-09
 */
public interface ProductsRepository extends JpaRepository<Products, Integer> {

    /**
     *
     * @return
     */
    @Query("   SELECT new dk.viabill.productorders.entity.rest.ProductsFormRest(p.id, p.name, p.unitPrice) "
            + "  FROM Products p"
            + " WHERE p.active = 1"
    )
    List<ProductsFormRest> findAllProducts();

    /**
     *
     * @param name
     * @return
     */
    Products findByName(String name);

}
