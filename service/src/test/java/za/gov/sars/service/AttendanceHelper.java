/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.service;

import java.util.Date;
import za.gov.sars.common.AttendenceStatus;
import za.gov.sars.domain.Attendence;
import za.gov.sars.persistance.AttendenceRepository;
import za.gov.sars.persistance.EmployeeRepository;
import za.gov.sars.persistance.FacilityRepository;
import za.gov.sars.persistance.GradeRepository;
import za.gov.sars.persistance.SchoolRepository;
import za.gov.sars.persistance.StudentRepository;
import za.gov.sars.persistance.SubjectRepository;

/**
 *
 * @author S2028398
 */
public class AttendanceHelper {

    public static void addAttendance(AttendenceRepository attendenceRepository, StudentRepository studentRepository, EmployeeRepository employeeRepository, GradeRepository gradeRepository, SubjectRepository subjectRepository,FacilityRepository facilityRepository,SchoolRepository schoolRepository) {

        Attendence attendence = new Attendence();
        attendence.setCreatedBy("Test");
        attendence.setCreatedDate(new Date());
        attendence.setName("Java Core OOP Principle");
        attendence.setDescription("Java OOP principle attendance");
        attendence.setStatus(AttendenceStatus.AVAILABLE);
        attendence.setAttendanceDate(new Date());
        attendence.setGrade(gradeRepository.findAll().get(gradeRepository.findAll().size()-5));
        attendence.setSubject(subjectRepository.findAll().get(subjectRepository.findAll().size()-2));
        attendence.setFacility(facilityRepository.findAll().get(facilityRepository.findAll().size()-1));
        attendence.setTeacher(employeeRepository.findAll().get(employeeRepository.findAll().size() - 1));
        attendenceRepository.save(attendence);

        Attendence attendence2 = new Attendence();
        attendence2.setCreatedBy("Test");
        attendence2.setCreatedDate(new Date());
        attendence2.setName("MSQL Database");
        attendence2.setDescription("Database attendance");
        attendence2.setStatus(AttendenceStatus.POSTPONED);
        attendence2.setAttendanceDate(new Date());
        attendence2.setGrade(gradeRepository.findAll().get(gradeRepository.findAll().size()-7));
        attendence2.setSubject(subjectRepository.findAll().get(subjectRepository.findAll().size()-4));
        attendence2.setFacility(facilityRepository.findAll().get(facilityRepository.findAll().size()-2));
        attendence2.setTeacher(employeeRepository.findAll().get(employeeRepository.findAll().size() - 3));
        attendenceRepository.save(attendence2);

        Attendence attendence3 = new Attendence();
        attendence3.setCreatedBy("Test");
        attendence3.setCreatedDate(new Date());
        attendence3.setName("Spring Hibernate");
        attendence3.setDescription("Hibarnate class attendance");
        attendence3.setStatus(AttendenceStatus.CANCELLED);
        attendence3.setAttendanceDate(new Date());
        attendence2.setGrade(gradeRepository.findAll().get(gradeRepository.findAll().size()-4));
        attendence2.setSubject(subjectRepository.findAll().get(subjectRepository.findAll().size()-3));
        attendence3.setFacility(facilityRepository.findAll().get(facilityRepository.findAll().size()-3));
        attendence3.setTeacher(employeeRepository.findAll().get(employeeRepository.findAll().size() - 2));
        attendenceRepository.save(attendence3);
    }
}
