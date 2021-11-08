/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import za.gov.sars.common.TestDataSourceConfiguration;
import za.gov.sars.persistance.AssesmentRepository;
import za.gov.sars.persistance.AttendenceRepository;
import za.gov.sars.persistance.EmployeeRepository;
import za.gov.sars.persistance.FacilityRepository;
import za.gov.sars.persistance.GradeRepository;
import za.gov.sars.persistance.SchoolRepository;
import za.gov.sars.persistance.StudentRepository;
import za.gov.sars.persistance.SubjectRepository;
import za.gov.sars.persistance.SystemUserRepository;


/**
 *
 * @author S2028398
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestDataSourceConfiguration.class)
public class ServiceLayerTestCase {

    @Autowired
    private AttendenceRepository attendanceRepository;
    @Autowired
    private AssesmentRepository assesmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private FacilityRepository facilityRepository;
    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private SystemUserRepository systemUserRepository;

    public ServiceLayerTestCase() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void TestA() {
        SchoolHelper.addSchool(schoolRepository);
    }

    @Test
    public void TestB() {
        GradeHelper.addGrade(gradeRepository, schoolRepository);
    }

    @Test
    public void TestC() {
        SubjectHelper.addSubject(subjectRepository, schoolRepository);

    }

    @Test
    public void TestD() {
        EmployeeHelper.addEmployee(employeeRepository, gradeRepository, subjectRepository, schoolRepository);

    }

    @Test
    public void TestE() {

        StudentHelper.addStudent(studentRepository, gradeRepository, subjectRepository, schoolRepository);
    }

    @Test
    public void TestF() {

        SystemUserHelper.addSystemUser(systemUserRepository, employeeRepository, studentRepository);
    }

    @Test
    public void TestG() {
        FacilityHelper.addFacility(facilityRepository, schoolRepository);
    }

    @Test
    public void TestH() {
        AttendanceHelper.addAttendance(attendanceRepository, studentRepository, employeeRepository, gradeRepository, subjectRepository,facilityRepository, schoolRepository);
    }

    @Test
    public void TestI() {
        AssesmentHelper.addAssesment(assesmentRepository, employeeRepository, studentRepository,subjectRepository);

    }
}
