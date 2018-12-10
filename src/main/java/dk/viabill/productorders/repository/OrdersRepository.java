/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.viabill.productorders.repository;

import dk.viabill.productorders.entity.Orders;
import java.util.Date;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author victor.zaitev
 * @version 1.0
 * @since 2018-12-09
 */
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    Set<Orders> findByOrderDateBetween(Date startDate, Date endDate);
}
