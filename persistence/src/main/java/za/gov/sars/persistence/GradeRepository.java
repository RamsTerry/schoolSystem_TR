/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.gov.sars.domain.Grade;

/**
 *
 * @author S2028398
 */
@Repository
public interface GradeRepository extends JpaRepository<Grade, Long>{
    
}
