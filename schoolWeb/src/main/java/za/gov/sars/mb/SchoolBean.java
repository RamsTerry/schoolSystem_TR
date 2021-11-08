/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.mb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import za.gov.sars.common.AddressType;
import za.gov.sars.domain.Address;
import za.gov.sars.domain.ContactDetails;
import za.gov.sars.domain.Employee;
import za.gov.sars.domain.Facility;
import za.gov.sars.domain.Grade;
import za.gov.sars.domain.School;
import za.gov.sars.domain.Student;
import za.gov.sars.domain.Subject;
import za.gov.sars.service.EmployeeServiceLocal;
import za.gov.sars.service.FacilityServiceLocal;
import za.gov.sars.service.GradeServiceLocal;
import za.gov.sars.service.SchoolServiceLocal;
import za.gov.sars.service.StudentServiceLocal;
import za.gov.sars.service.SubjectServiceLocal;

/**
 *
 * @author S2028398
 */
@ManagedBean
@ViewScoped
public class SchoolBean extends BaseBean{ 
    @Autowired
    private SchoolServiceLocal schoolService;
    @Autowired
    private EmployeeServiceLocal employeeService;
    @Autowired
    private StudentServiceLocal studentService;
    @Autowired
    private SubjectServiceLocal subjectService;
    @Autowired
    private GradeServiceLocal gradeService;
    @Autowired
    private FacilityServiceLocal facilityService;
    
    private List<Employee> employees = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Subject> subjects = new ArrayList<>();
    private List<Grade> grades = new ArrayList<>();
    private List<Facility> facilities = new ArrayList<>();
    
    private School school;
    
    @PostConstruct
    public void init() {
        this.resetView(false).setList(true);
        school = schoolService.listAll().get(schoolService.listAll().size() - 1);
        employees = employeeService.listAll();
        students = studentService.listAll();
        grades=gradeService.listAll();
        subjects=subjectService.listAll();
        facilities=facilityService.listAll();    
    }
    
    public void addOrUpdate(School sc) {
        this.resetView(false).setAdd(true);
        if (sc != null) {
            sc.setUpdatedBy(getActiveUser().getIdentifier());
            sc.setUpdatedDate(new Date());
            school = sc;
        } else {
            school = new School();
            school.setCreatedBy(getActiveUser().getIdentifier());
            school.setCreatedDate(new Date());
            
            Address addresspost = new Address();
            addresspost.setAddressType(AddressType.POSTAL);
            addresspost.setCreatedBy(getActiveUser().getIdentifier());
            addresspost.setCreatedDate(new Date());

            Address addressres = new Address();
            addressres.setAddressType(AddressType.RESIDENTIAL);
            addressres.setCreatedBy(getActiveUser().getIdentifier());
            addressres.setCreatedDate(new Date());

            school.addAddress(addresspost);
            school.addAddress(addressres);

            ContactDetails contactDetail = new ContactDetails();
            contactDetail.setCreatedBy(getActiveUser().getIdentifier());
            contactDetail.setCreatedDate(new Date());
            school.setContactDetail(contactDetail);
        }
    }
        public void save(School sch) {
        if (sch.getId() != null) {
            schoolService.update(sch);
        } else {
            schoolService.save(sch);
        }
        this.resetView(false).setList(true);
    }
        
        public void delete(School sch) {

        schoolService.deleteById(sch.getId());
        this.resetView(false).setList(true);
    }
        
        public void cancel(School sch) {
        school = schoolService.listAll().get(schoolService.listAll().size() - 1);
        this.resetView(false).setList(true);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

   
}
