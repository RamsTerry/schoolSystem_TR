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
import za.gov.sars.domain.Assesment;
/**
 *
 * @author S2028398
 */
@Repository
public interface AssesmentRepository extends JpaRepository<Assesment, Long> {

    @Query("SELECT e FROM Assesment e WHERE e.student.studentId=:studentId")
    public List<Assesment> findAssesmentByStudentNum(@Param("studentId") String studentId);

    @Query("SELECT e FROM Assesment e WHERE e.teacher.employeeId=:employeeId")
    public List<Assesment> findAssesmentByEmployeeNum(@Param("employeeId") String employeeId);
}
