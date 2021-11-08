/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.mb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import za.gov.sars.common.AddressType;
import za.gov.sars.common.EmployeeType;
import za.gov.sars.common.GenderType;
import za.gov.sars.common.PersonType;
import za.gov.sars.domain.Address;
import za.gov.sars.domain.ContactDetails;
import za.gov.sars.domain.Employee;
import za.gov.sars.domain.Grade;
import za.gov.sars.domain.School;
import za.gov.sars.domain.Subject;
import za.gov.sars.service.EmployeeServiceLocal;
import za.gov.sars.service.GradeServiceLocal;
import za.gov.sars.service.SchoolServiceLocal;
import za.gov.sars.service.SubjectServiceLocal;

/**
 *
 * @author S2028398
 */
@ManagedBean
@ViewScoped
public class EmployeeBean extends BaseBean {

    @Autowired
    private EmployeeServiceLocal employeeService;
    @Autowired
    private GradeServiceLocal gradeservice;
    @Autowired
    private SubjectServiceLocal subjectService;
    @Autowired
    private SchoolServiceLocal schoolService;

    private List<Employee> employees = new ArrayList<>();
    private List<Grade> grades = new ArrayList<>();
    private List<Subject> subjects = new ArrayList<>();

    private List<AddressType> addressTypes;
    private List<GenderType> genders;
    private List<EmployeeType> employeeTypes;
    private List<PersonType> personTypes;

    private Employee staff;
    private School school;

    @PostConstruct
    public void init() {
        this.resetView(false).setList(true);

        employees = employeeService.listAll();
        grades = gradeservice.listAll();
        subjects = subjectService.listAll();
        addressTypes = Arrays.asList(AddressType.values());
        employeeTypes = Arrays.asList(EmployeeType.values());
        personTypes = Arrays.asList(PersonType.values());
        genders = Arrays.asList(GenderType.values());
        school = schoolService.listAll().get(schoolService.listAll().size() - 1);
    }

    public void addOrUpdate(Employee emp) {
        this.resetView(false).setAdd(true);
        if (emp != null) {
            emp.setUpdatedBy(getActiveUser().getIdentifier());
            emp.setUpdatedDate(new Date());
            staff = emp;

        } else {

            staff = new Employee();
            staff.setCreatedBy(getActiveUser().getIdentifier());
            staff.setCreatedDate(new Date());
            staff.setSchool(school);
            staff.setPersonType(PersonType.EMPLOYEE);

            Address addresspost = new Address();
            addresspost.setAddressType(AddressType.POSTAL);
            addresspost.setCreatedBy(getActiveUser().getIdentifier());
            addresspost.setCreatedDate(new Date());

            Address addressres = new Address();
            addressres.setAddressType(AddressType.RESIDENTIAL);
            addressres.setCreatedBy(getActiveUser().getIdentifier());
            addressres.setCreatedDate(new Date());

            staff.addAddress(addresspost);
            staff.addAddress(addressres);

            ContactDetails contactDetail = new ContactDetails();
            contactDetail.setCreatedBy(getActiveUser().getIdentifier());
            contactDetail.setCreatedDate(new Date());
            staff.setContactDetails(contactDetail);

            employees.add(0, staff);
        }
    }

    public void save(Employee emp) {
        if (emp.getId() != null) {
            employeeService.update(emp);
        } else {
            employeeService.save(emp);
        }
        this.resetView(false).setList(true);
    }

    public void delete(Employee emp) {
        employeeService.deleteById(emp.getId());
        synchronize(emp);
        this.resetView(false).setList(true);
    }

    public void synchronize(Employee emp) {
        Iterator<Employee> employeeList = employees.iterator();
        while (employeeList.hasNext()) {
            if (employeeList.next().getId().equals(emp.getId())) {
                employeeList.remove();
            }
        }
    }

    public void cancel(Employee emp) {
        if (emp.getId() == null) {
            if (employees.contains(emp)) {
                employees.remove(emp);
            }
        }
        this.resetView(false).setList(true);
    }

    public void employeeTypeListener() {
        if ((staff.getEmployeeType().equals(EmployeeType.EDUCATOR)) || (staff.getEmployeeType().equals(EmployeeType.HOD)) || (staff.getEmployeeType().equals(EmployeeType.PRINCIPAL))) {
            setVisible(true);
        } else {
            setVisible(false);
        }
    }

    public EmployeeServiceLocal getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeServiceLocal employeeService) {
        this.employeeService = employeeService;
    }

    public GradeServiceLocal getGradeservice() {
        return gradeservice;
    }

    public void setGradeservice(GradeServiceLocal gradeservice) {
        this.gradeservice = gradeservice;
    }

    public SubjectServiceLocal getSubjectService() {
        return subjectService;
    }

    public void setSubjectService(SubjectServiceLocal subjectService) {
        this.subjectService = subjectService;
    }

    public SchoolServiceLocal getSchoolService() {
        return schoolService;
    }

    public void setSchoolService(SchoolServiceLocal schoolService) {
        this.schoolService = schoolService;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<AddressType> getAddressTypes() {
        return addressTypes;
    }

    public void setAddressTypes(List<AddressType> addressTypes) {
        this.addressTypes = addressTypes;
    }

    public List<GenderType> getGenders() {
        return genders;
    }

    public void setGenders(List<GenderType> genders) {
        this.genders = genders;
    }

    public List<EmployeeType> getEmployeeTypes() {
        return employeeTypes;
    }

    public void setEmployeeTypes(List<EmployeeType> employeeTypes) {
        this.employeeTypes = employeeTypes;
    }

    public List<PersonType> getPersonTypes() {
        return personTypes;
    }

    public void setPersonTypes(List<PersonType> personTypes) {
        this.personTypes = personTypes;
    }

    public Employee getStaff() {
        return staff;
    }

    public void setStaff(Employee staff) {
        this.staff = staff;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    
}
