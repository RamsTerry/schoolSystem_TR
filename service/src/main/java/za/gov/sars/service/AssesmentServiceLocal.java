/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.service;

import java.util.List;
import za.gov.sars.domain.Assesment;

/**
 *
 * @author S2028398
 */
public interface AssesmentServiceLocal {

    Assesment save(Assesment Assesment);

    Assesment findById(Long id);

    Assesment update(Assesment assesment);

    void deleteAll();

    Assesment deleteById(Long id);

    List<Assesment> listAll();

    List<Assesment> findAssesmentByEmployeeNum(String employeeId);

    List<Assesment> findAssesmentByStudentNum(String studentId);

    boolean isExist(Assesment assesment);

    long count();
}
