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
import za.gov.sars.common.GenderType;
import za.gov.sars.common.PersonType;
import za.gov.sars.domain.Address;
import za.gov.sars.domain.ContactDetails;
import za.gov.sars.domain.Grade;
import za.gov.sars.domain.School;
import za.gov.sars.domain.Student;
import za.gov.sars.domain.Subject;
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
public class StudentBean extends BaseBean {

    @Autowired
    private StudentServiceLocal studentService;
    @Autowired
    private GradeServiceLocal gradeService;
    @Autowired
    private SubjectServiceLocal subjectService;
    @Autowired
    private SchoolServiceLocal schoolService;

    private List<Student> students = new ArrayList<>();
    private List<Grade> grades = new ArrayList<>();
    private List<Subject> subjects = new ArrayList<>();

    private List<PersonType> personType;
    private List<GenderType> genders;
    private List<AddressType> addressTypes;

    private Student student;
    private School school;

    @PostConstruct
    public void init() {
        this.resetView(false).setList(true);
        students = studentService.listAll();
        grades = gradeService.listAll();
        subjects = subjectService.listAll();
        personType = Arrays.asList(PersonType.values());
        genders = Arrays.asList(GenderType.values());
        addressTypes = Arrays.asList(AddressType.values());
        school = schoolService.listAll().get(schoolService.listAll().size() - 1);
    }

    public void addOrUpdate(Student st) {
        this.resetView(false).setAdd(true);
        if (st != null) {
            st.setUpdatedBy(getActiveUser().getIdentifier());
            st.setUpdatedDate(new Date());
            student = st;
        } else {
            student = new Student();
            student.setCreatedBy(getActiveUser().getIdentifier());
            student.setCreatedDate(new Date());
            student.setSchool(school);
            student.setPersonType(PersonType.LEARNER);

            Address addresspost = new Address();
            addresspost.setAddressType(AddressType.POSTAL);
            addresspost.setCreatedBy(getActiveUser().getIdentifier());
            addresspost.setCreatedDate(new Date());

            Address addressres = new Address();
            addressres.setAddressType(AddressType.RESIDENTIAL);
            addressres.setCreatedBy(getActiveUser().getIdentifier());
            addressres.setCreatedDate(new Date());

            student.addAddress(addresspost);
            student.addAddress(addressres);

            ContactDetails contactDetail = new ContactDetails();
            contactDetail.setCreatedBy(getActiveUser().getIdentifier());
            contactDetail.setCreatedDate(new Date());
            student.setContactDetails(contactDetail);

            students.add(0, student);
        }
    }

    public void save(Student st) {

        if (st.getId() != null) {
            studentService.update(st);

        } else {
            studentService.save(st);
        }
        this.resetView(false).setList(true);
    }

    public void delete(Student st) {
        studentService.deleteById(st.getId());
        synchronize(st);
        this.resetView(false).setList(true);
    }

    public void synchronize(Student st) {
        Iterator<Student> studentList = students.iterator();
        while (studentList.hasNext()) {
            if (studentList.next().getId().equals(st.getId())) {
                studentList.remove();
            }
        }
    }

    public void cancel(Student st) {
        if (st.getId() == null) {
            if (students.contains(st)) {
                students.remove(st);
            }
        }
        this.resetView(false).setList(true);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
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

    public List<PersonType> getPersonType() {
        return personType;
    }

    public void setPersonType(List<PersonType> personType) {
        this.personType = personType;
    }

    public List<GenderType> getGenders() {
        return genders;
    }

    public void setGenders(List<GenderType> genders) {
        this.genders = genders;
    }

    public List<AddressType> getAddressTypes() {
        return addressTypes;
    }

    public void setAddressTypes(List<AddressType> addressTypes) {
        this.addressTypes = addressTypes;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

   
}
