/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.viabill.productorders.repository;

import dk.viabill.productorders.entity.Cutomers;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author victor.zaitev
 * @version 1.0
 * @since 2018-12-09
 */
public interface CutomersRepository extends JpaRepository<Cutomers, Integer> {

    /**
     * 
     * @param email
     * @return 
     */
    Cutomers findByEmail(String email);
}
