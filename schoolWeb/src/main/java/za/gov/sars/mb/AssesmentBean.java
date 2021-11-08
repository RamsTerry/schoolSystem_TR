/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.mb;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import za.gov.sars.domain.Assesment;
import za.gov.sars.domain.Employee;
import za.gov.sars.domain.Student;
import za.gov.sars.service.AssesmentServiceLocal;
import za.gov.sars.service.EmployeeServiceLocal;
import za.gov.sars.service.StudentServiceLocal;

/**
 *
 * @author S2028398
 */
@ManagedBean
@ViewScoped
public class AssesmentBean extends BaseBean {

    @Autowired
    private AssesmentServiceLocal assesmentServices;
    @Autowired
    private StudentServiceLocal studentService;
    @Autowired
    private EmployeeServiceLocal employeeService;

    private List<Assesment> assesments = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    private Assesment assesment;
    private Employee teacher;
    private Student student;

    @PostConstruct
    public void init() {
        this.resetView(false).setList(true);
        assesments = assesmentServices.listAll();
        if (getActiveUser().isLearner()) {
            student = studentService.findStudentByStudentNum(getActiveUser().getIdentifier());
        } else {
            teacher = employeeService.findEmployeeByEmployeeNum(getActiveUser().getIdentifier());
        }
        if (teacher != null) {
            assesments = assesmentServices.findAssesmentByEmployeeNum(teacher.getEmployeeId());
        } else if (student != null) {
            assesments = assesmentServices.findAssesmentByStudentNum(student.getStudentId());
        }
    }

    public void addorUpdate(Assesment assessm) {
        this.resetView(false).setAdd(true);
        if (assessm != null) {
            assessm.setUpdatedBy(getActiveUser().getIdentifier());
            assessm.setUpdatedDate(new Date());
            assesment = assessm;
        } else {
            assesment = new Assesment();
            assesment.setCreatedBy(getActiveUser().getIdentifier());
            assesment.setCreatedDate(new Date());
            assesment.setTeacher(teacher);

            assesments.add(0, assesment);
        }
    }

    public void save(Assesment assessm) {
        if (assessm.getId() != null) {
            assessm.setUpdatedBy(getActiveUser().getIdentifier());
            assessm.setUpdatedDate(new Date());
            assesmentServices.update(assessm);
        } else {
            assesmentServices.save(assessm);
        }
        this.resetView(false).setList(true);
    }

    public void delete(Assesment assessm) {
        assesmentServices.deleteById(assessm.getId());
        synchronize(assessm);
        this.resetView(false).setList(true);
    }

    public void synchronize(Assesment assessm) {

        Iterator<Assesment> assessmentList = assesments.iterator();

        while (assessmentList.hasNext()) {

            if (assessmentList.next().getId().equals(assessm.getId())) {

                assessmentList.remove();
            }
        }
    }

    public void cancel(Assesment assessm) {
        if (assessm.getId() == null) {
            if (assesments.contains(assessm)) {

                assesments.remove(assessm);
            }
        }

        this.resetView(false).setList(true);

    }

    public List<Assesment> getAssesments() {
        return assesments;
    }

    public AssesmentServiceLocal getAssesmentServices() {
        return assesmentServices;
    }

    public void setAssesmentServices(AssesmentServiceLocal assesmentServices) {
        this.assesmentServices = assesmentServices;
    }

    public StudentServiceLocal getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentServiceLocal studentService) {
        this.studentService = studentService;
    }

    public EmployeeServiceLocal getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeServiceLocal employeeService) {
        this.employeeService = employeeService;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Assesment getAssesment() {
        return assesment;
    }

    public void setAssesment(Assesment assesment) {
        this.assesment = assesment;
    }

    public Employee getTeacher() {
        return teacher;
    }

    public void setTeacher(Employee teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

   
}
