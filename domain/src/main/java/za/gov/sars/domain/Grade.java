/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.envers.Audited;

/**
 *
 * @author S2028398
 */
@Entity
@Audited
@Table(name = "grade")
public class Grade extends BaseEntity {

    @Column(name = "designation")
    private String designation;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private School school;
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Student> students = new ArrayList<>();
    @ManyToMany(mappedBy = "grades", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Employee> teachers = new ArrayList<>();

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Employee> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Employee> teachers) {
        this.teachers = teachers;
    }
    
    
}
