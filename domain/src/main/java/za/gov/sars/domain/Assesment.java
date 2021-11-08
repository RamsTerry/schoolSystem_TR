/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.domain;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.envers.Audited;

/**
 *
 * @author S2028398
 */
@Entity
@Audited
@Table(name = "assesment")
public class Assesment extends BaseEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "due_date")
    private Date dueDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "first_submission_date")
    private Date firstSubmissionDate;
    @Column(name = "full_mark")
    private int fullMark;
    @Column(name = "pass_mark")
    private int passMark;
    @Column(name = "student_mark")
    private int studentMark;
    @Column(name = "totalMark")
    private int totalMark;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Grade grade;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Subject subject;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Student student;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Employee teacher;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private School school;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getFirstSubmissionDate() {
        return firstSubmissionDate;
    }

    public void setFirstSubmissionDate(Date firstSubmissionDate) {
        this.firstSubmissionDate = firstSubmissionDate;
    }

    public int getFullMark() {
        return fullMark;
    }

    public void setFullMark(int fullMark) {
        this.fullMark = fullMark;
    }

    public int getPassMark() {
        return passMark;
    }

    public void setPassMark(int passMark) {
        this.passMark = passMark;
    }

    public int getStudentMark() {
        return studentMark;
    }

    public void setStudentMark(int studentMark) {
        this.studentMark = studentMark;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Employee getTeacher() {
        return teacher;
    }

    public void setTeacher(Employee teacher) {
        this.teacher = teacher;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
    
    
}
