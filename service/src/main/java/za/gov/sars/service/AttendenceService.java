/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.gov.sars.domain.Attendence;
import za.gov.sars.persistance.AttendenceRepository;

/**
 *
 * @author S2028398
 */
@Service
public class AttendenceService implements AttendenceServiceLocal {

    @Autowired
    private AttendenceRepository attendandRepository;

    @Override
    public Attendence save(Attendence attendence) {
        return attendandRepository.save(attendence);
    }

    @Override
    public Attendence findById(Long id) {
        return attendandRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("The requested id [" + id + "] does not exist."));
    }

    @Override
    public Attendence update(Attendence attendence) {
        return attendandRepository.save(attendence);
    }

    @Override
    public void deleteAll() {
        attendandRepository.deleteAll();
    }

    @Override
    public Attendence deleteById(Long id) {
        Attendence attend = findById(id);
        if (attend != null) {
            attendandRepository.deleteById(id);
        }
        return attend;
    }

    @Override
    public List<Attendence> listAll() {
        return attendandRepository.findAll();
    }

    @Override
    public List<Attendence> findAttendenceBySubjectName(String name) {
        return attendandRepository.findAttendenceBySubjectName(name);
    }

    @Override
    public boolean isExist(Attendence attendence) {
        return attendandRepository.findById(attendence.getId()) != null;
    }

    @Override
    public long count() {
        return attendandRepository.count();
    }

}
