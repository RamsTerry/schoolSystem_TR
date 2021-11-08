/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.service;

import java.util.Date;
import za.gov.sars.domain.Grade;
import za.gov.sars.persistance.GradeRepository;
import za.gov.sars.persistance.SchoolRepository;

/**
 *
 * @author S2028398
 */
public class GradeHelper {

    public static void addGrade(GradeRepository gradeRepository, SchoolRepository schoolRepository) {
        Grade grade1 = new Grade();
        grade1.setCreatedBy("Test");
        grade1.setCreatedDate(new Date());
        grade1.setDesignation("Grade 8A");
        grade1.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        gradeRepository.save(grade1);

        Grade grade2 = new Grade();
        grade2.setCreatedBy("Test");
        grade2.setCreatedDate(new Date());
        grade2.setDesignation("Grade 8B");
        grade2.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        gradeRepository.save(grade2);

        Grade grade3 = new Grade();
        grade3.setCreatedBy("Test");
        grade3.setCreatedDate(new Date());
        grade3.setDesignation("Grade 9");
        grade3.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        gradeRepository.save(grade3);

        Grade grade4 = new Grade();
        grade4.setCreatedBy("Test");
        grade4.setCreatedDate(new Date());
        grade4.setDesignation("Grade 9B");
        grade4.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        gradeRepository.save(grade4);

        Grade grade5 = new Grade();
        grade5.setCreatedBy("Test");
        grade5.setCreatedDate(new Date());
        grade5.setDesignation("Grade 10");
        grade5.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        gradeRepository.save(grade5);

        Grade grade6 = new Grade();
        grade6.setCreatedBy("Test");
        grade6.setCreatedDate(new Date());
        grade6.setDesignation("Grade 10B");
        grade6.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        gradeRepository.save(grade6);

        Grade grade7 = new Grade();
        grade7.setCreatedBy("Test");
        grade7.setCreatedDate(new Date());
        grade7.setDesignation("Grade 11");
        grade7.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        gradeRepository.save(grade7);

        Grade grade8 = new Grade();
        grade8.setCreatedBy("Test");
        grade8.setCreatedDate(new Date());
        grade8.setDesignation("Grade 11B");
        grade8.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        gradeRepository.save(grade8);

        Grade grade11 = new Grade();
        grade11.setCreatedBy("Test");
        grade11.setCreatedDate(new Date());
        grade11.setDesignation("Grade 12");
        grade11.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        gradeRepository.save(grade11);

        Grade grade12 = new Grade();
        grade12.setCreatedBy("Test");
        grade12.setCreatedDate(new Date());
        grade12.setDesignation("Grade 12B");
        grade12.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        gradeRepository.save(grade12);
    }
}
