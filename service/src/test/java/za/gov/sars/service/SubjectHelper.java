/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.service;

import java.util.Date;
import za.gov.sars.domain.Subject;
import za.gov.sars.persistance.SchoolRepository;
import za.gov.sars.persistance.SubjectRepository;

/**
 *
 * @author S2028398
 */
public class SubjectHelper {

    public static void addSubject(SubjectRepository subjectRepository, SchoolRepository schoolRepository) {
        Subject subject1 = new Subject();
        subject1.setCreatedBy("Test");
        subject1.setCreatedDate(new Date());
        subject1.setName("English");
        subject1.setCode("ECS 1545");
        subject1.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject1);

        Subject subject2 = new Subject();
        subject2.setCreatedBy("Test");
        subject2.setCreatedDate(new Date());
        subject2.setName("Mathematics");
        subject2.setCode("MAT 1542");
        subject2.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject2);

        Subject subject3 = new Subject();
        subject3.setCreatedBy("Test");
        subject3.setCreatedDate(new Date());
        subject3.setName("Biology");
        subject3.setCode("BIO 1354");
        subject3.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject3);

        Subject subject4 = new Subject();
        subject4.setCreatedBy("Test");
        subject4.setCreatedDate(new Date());
        subject4.setName("Life Orientation");
        subject4.setCode("L.0 3544");
        subject4.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject4);

        Subject subject5 = new Subject();
        subject5.setCreatedBy("Test");
        subject5.setCreatedDate(new Date());
        subject5.setName("Computer Literacy");
        subject5.setCode("COM 3598");
        subject5.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject5);

        Subject subject6 = new Subject();
        subject6.setCreatedBy("Test");
        subject6.setCreatedDate(new Date());
        subject6.setName("Database Enginering");
        subject6.setCode("COM 8574");
        subject6.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject6);
        
        Subject subject7= new Subject();
        subject7.setCreatedBy("Test");
        subject7.setCreatedDate(new Date());
        subject7.setName("Software Deloper");
        subject7.setCode("COM 1474");
        subject7.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject7);
        
        Subject subject8= new Subject();
        subject8.setCreatedBy("Test");
        subject8.setCreatedDate(new Date());
        subject8.setName("Drawing");
        subject8.setCode("DW 0433");
        subject8.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject8);
        
        Subject subject9= new Subject();
        subject9.setCreatedBy("Test");
        subject9.setCreatedDate(new Date());
        subject9.setName("Mapping");
        subject9.setCode("Geo 557");
        subject9.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject9);
        
        Subject subject10= new Subject();
        subject10.setCreatedBy("Test");
        subject10.setCreatedDate(new Date());
        subject10.setName("Life Skills");
        subject10.setCode("LI 7022");
        subject10.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject10);
        
        Subject subject11= new Subject();
        subject11.setCreatedBy("Test");
        subject11.setCreatedDate(new Date());
        subject11.setName("Physical Science");
        subject11.setCode("PHY 1522");
        subject11.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject11);
        
        Subject subject12= new Subject();
        subject12.setCreatedBy("Test");
        subject12.setCreatedDate(new Date());
        subject12.setName("Management Science");
        subject12.setCode("MGN 1877");
        subject12.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject12);

    }
}
