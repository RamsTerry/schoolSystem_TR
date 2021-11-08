/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.persistance;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.gov.sars.domain.Attendence;

/**
 *
 * @author S2028398
 */
@Repository
public interface AttendenceRepository extends JpaRepository<Attendence, Long> {

    @Query("SELECT e FROM Attendence e WHERE e.subject.name=:name")
    public List<Attendence> findAttendenceBySubjectName(@Param("name") String name);

}
