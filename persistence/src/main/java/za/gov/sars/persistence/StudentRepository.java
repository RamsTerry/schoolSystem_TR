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
import za.gov.sars.domain.Student;

/**
 *
 * @author S2028398
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    @Query("SELECT e FROM Student e WHERE e.studentId=:studentId")
    public Student findStudentByStudentNum(@Param("studentId") String studentId);
}
