/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.mb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import za.gov.sars.common.SystemUserType;
import za.gov.sars.domain.Employee;
import za.gov.sars.domain.School;
import za.gov.sars.domain.Student;
import za.gov.sars.service.EmployeeServiceLocal;
import za.gov.sars.service.SchoolServiceLocal;
import za.gov.sars.service.StudentServiceLocal;

/**
 *
 * @author S2028398
 */
@ManagedBean
@ViewScoped
public class LandingBean extends BaseBean {

    @Autowired
    private SchoolServiceLocal schoolService;
    @Autowired
    private EmployeeServiceLocal employeeService;
    @Autowired
    private StudentServiceLocal studentService;

    private Employee staffs;
    private Student schoolStd;
    private School school;

    @PostConstruct
    public void init() {
        school = schoolService.listAll().get(schoolService.listAll().size() - 1);
        if (getActiveUser().getSystemUserType().equals(SystemUserType.EMPLOYEE) || getActiveUser().getSystemUserType().equals(SystemUserType.SYSTEM_ADMIN)) {
            staffs = employeeService.findEmployeeByEmployeeNum(getActiveUser().getIdentifier());
        } else if (getActiveUser().getSystemUserType().equals(SystemUserType.LEARNER)) {
            schoolStd = studentService.findStudentByStudentNum(getActiveUser().getIdentifier());
        }
    }

    public Employee getStaffs() {
        return staffs;
    }

    public void setStaffs(Employee staffs) {
        this.staffs = staffs;
    }

    public Student getSchoolStd() {
        return schoolStd;
    }

    public void setSchoolStd(Student schoolStd) {
        this.schoolStd = schoolStd;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

   
}
