/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.service;

import java.util.List;
import za.gov.sars.domain.Attendence;

/**
 *
 * @author S2028398
 */
public interface AttendenceServiceLocal {

    Attendence save(Attendence attendence);

    Attendence findById(Long id);

    Attendence update(Attendence attendence);

    void deleteAll();

    Attendence deleteById(Long id);

    List<Attendence> listAll();

    List<Attendence> findAttendenceBySubjectName(String name);

    boolean isExist(Attendence attendence);

    long count();
}
