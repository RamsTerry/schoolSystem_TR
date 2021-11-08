/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.gov.sars.domain.Assesment;
import za.gov.sars.persistance.AssesmentRepository;


/**
 *
 * @author S2028398
 */
@Service
public class AssesmentService implements AssesmentServiceLocal{
     @Autowired
    private AssesmentRepository assesmentRepository;

    @Override
    public Assesment save(Assesment assesment) {
       return assesmentRepository.save(assesment);
    }

    @Override
    public Assesment findById(Long id) {
         return assesmentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("The requested id [" + id + "] does not exist."));
    }

    @Override
    public Assesment update(Assesment assesment) {
         return assesmentRepository.save(assesment);
    }

    @Override
    public void deleteAll() {
         assesmentRepository.deleteAll();
    }

    @Override
    public Assesment deleteById(Long id) {
       Assesment assess = findById(id);
        if (assess != null) {
            assesmentRepository.deleteById(id);
        }
        return assess;
    }

    @Override
    public List<Assesment> listAll() {
        return assesmentRepository.findAll();
    }

    @Override
    public List<Assesment> findAssesmentByEmployeeNum(String employeeId) {
        return assesmentRepository.findAssesmentByEmployeeNum(employeeId);
    }

    @Override
    public List<Assesment> findAssesmentByStudentNum(String studentId) {
        return assesmentRepository.findAssesmentByStudentNum(studentId);
    }

    @Override
    public boolean isExist(Assesment assesment) {
        return assesmentRepository.findById(assesment.getId()) != null;
    }

    @Override
    public long count() {
         return assesmentRepository.count();
    }
}
