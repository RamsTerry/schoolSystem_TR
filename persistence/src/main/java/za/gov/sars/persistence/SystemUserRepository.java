/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.gov.sars.domain.SystemUser;

/**
 *
 * @author S2028398
 */
@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser, Long>{
   @Query("SELECT e FROM SystemUser e WHERE e.username=:username")
   public SystemUser searchByUsername(@Param("username") String username);
   
    @Query("SELECT e FROM SystemUser e WHERE e.identifier=:identifier")
    public SystemUser findSystemUserByIdentifier(@Param("identifier") String identifier);
}
