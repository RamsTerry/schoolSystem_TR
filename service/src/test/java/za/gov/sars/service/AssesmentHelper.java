/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.service;

import java.util.Date;
import za.gov.sars.domain.Assesment;
import za.gov.sars.persistance.AssesmentRepository;
import za.gov.sars.persistance.EmployeeRepository;
import za.gov.sars.persistance.StudentRepository;
import za.gov.sars.persistance.SubjectRepository;

/**
 *
 * @author S2028398
 */
public class AssesmentHelper {
    public static void addAssesment(AssesmentRepository assesmentRepository,EmployeeRepository employeeRepository, StudentRepository studentRepository,SubjectRepository subjectRepository) {
        
        Assesment assesment = new Assesment();
        assesment.setCreatedBy("Test");
        assesment.setCreatedDate(new Date());
        assesment.setName("Test 1 Assesment 1");
        assesment.setDescription("A test assesment 1 for tes case with full mark 100% and pass mark 60%");
        assesment.setFullMark(100);
        assesment.setPassMark(60);
        assesment.setDueDate(new Date());
        assesment.setTeacher(employeeRepository.findAll().get(employeeRepository.findAll().size()-1));
        assesment.setStudent(studentRepository.findAll().get(studentRepository.findAll().size()-2));
        assesment.setSubject(subjectRepository.findAll().get(subjectRepository.findAll().size()-2));
        assesmentRepository.save(assesment);
        
        Assesment assesment1 = new Assesment();
        assesment1.setCreatedBy("Test");
        assesment1.setCreatedDate(new Date());
        assesment1.setName("Test 2 Assesmrent 2");
        assesment1.setDescription("A test assesment 2 for tes case with full mark 20 and pass mark 12");
        assesment1.setFullMark(20);
        assesment1.setPassMark(12);
        assesment1.setDueDate(new Date());
        assesment1.setTeacher(employeeRepository.findAll().get(employeeRepository.findAll().size()-1));
        assesment1.setStudent(studentRepository.findAll().get(studentRepository.findAll().size()-1));
        assesment1.setSubject(subjectRepository.findAll().get(subjectRepository.findAll().size()-2));
        assesmentRepository.save(assesment1);
        
        Assesment assesment2 = new Assesment();
        assesment2.setCreatedBy("Test");
        assesment2.setCreatedDate(new Date());
        assesment2.setName("Test 3 Assesmrent 3");
        assesment2.setDescription("A test assesment 3 for tes case with full mark 50 and pass mark 30");
        assesment2.setFullMark(50);
        assesment2.setPassMark(30);
        assesment2.setDueDate(new Date());
        assesment2.setSubject(subjectRepository.findAll().get(subjectRepository.findAll().size()-2));
        assesment2.setTeacher(employeeRepository.findAll().get(employeeRepository.findAll().size()-1));
        assesment2.setStudent(studentRepository.findAll().get(studentRepository.findAll().size()-1));
        assesmentRepository.save(assesment2);
        
        Assesment assesment3 = new Assesment();
        assesment3.setCreatedBy("Test");
        assesment3.setCreatedDate(new Date());
        assesment3.setName("Test 4 Assesmrent 4");
        assesment3.setDescription("A test assesment 3 for tes case with full mark 80 and pass mark 45");
        assesment3.setFullMark(80);
        assesment3.setPassMark(45);
        assesment3.setDueDate(new Date());
        assesment3.setSubject(subjectRepository.findAll().get(subjectRepository.findAll().size()-2));
        assesment3.setTeacher(employeeRepository.findAll().get(employeeRepository.findAll().size()-1));
        assesment3.setStudent(studentRepository.findAll().get(studentRepository.findAll().size()-2));
        assesmentRepository.save(assesment3);
        
    } 
}
