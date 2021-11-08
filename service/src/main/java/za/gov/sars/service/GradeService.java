/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.gov.sars.domain.Grade;
import za.gov.sars.persistance.GradeRepository;

/**
 *
 * @author S2028398
 */
@Service
public class GradeService implements GradeServiceLocal {

    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public Grade save(Grade grade) {
        return gradeRepository.save(grade);
    }

    @Override
    public Grade findById(Long id) {
        return gradeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("The requested id [" + id + "] does not exist."));
    }

    @Override
    public Grade update(Grade grade) {
        return gradeRepository.save(grade);
    }

    @Override
    public void deleteAll() {
        gradeRepository.deleteAll();
    }

    @Override
    public Grade deleteById(Long id) {
        Grade grd = findById(id);
        if (grd != null) {
            gradeRepository.deleteById(id);
        }
        return grd;
    }

    @Override
    public List<Grade> listAll() {
        return gradeRepository.findAll();
    }

    @Override
    public boolean isExist(Grade grade) {
        return gradeRepository.findById(grade.getId()) != null;
    }

    @Override
    public long count() {
        return gradeRepository.count();
    }
}
