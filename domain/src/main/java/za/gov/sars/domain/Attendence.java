/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.envers.Audited;
import za.gov.sars.common.AttendenceStatus;

/**
 *
 * @author S2028398
 */
@Entity
@Audited
@Table(name = "attendance")
public class Attendence extends BaseEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "attendance_date")
    private Date attendanceDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AttendenceStatus status;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "attendance_student", joinColumns = {
        @JoinColumn(name = "attendance_id")}, inverseJoinColumns = {
        @JoinColumn(name = "student_id")})
    private List<Student> students = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Grade grade;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Subject subject;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Facility facility;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Employee teacher;

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

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public AttendenceStatus getStatus() {
        return status;
    }

    public void setStatus(AttendenceStatus status) {
        this.status = status;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
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

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Employee getTeacher() {
        return teacher;
    }

    public void setTeacher(Employee teacher) {
        this.teacher = teacher;
    }

}
