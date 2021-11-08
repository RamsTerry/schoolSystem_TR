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
import za.gov.sars.domain.Grade;
import za.gov.sars.domain.School;
import za.gov.sars.service.GradeServiceLocal;
import za.gov.sars.service.SchoolServiceLocal;

/**
 *
 * @author S2028398
 */
@ManagedBean
@ViewScoped
public class GradeBean extends BaseBean {

    @Autowired
    private GradeServiceLocal gradeService;
    @Autowired
    private SchoolServiceLocal schoolService;

    private List<Grade> grades = new ArrayList<>();

    private Grade grade;
    private School school;

    @PostConstruct
    public void init() {
        this.resetView(false).setList(true);
        grades = gradeService.listAll();
        school = schoolService.listAll().get(schoolService.listAll().size() - 1);
    }

    public void addOrUpdate(Grade gr) {
        this.resetView(false).setAdd(true);
        if (gr != null) {
            gr.setUpdatedBy(getActiveUser().getIdentifier());
            gr.setUpdatedDate(new Date());
            grade = gr;
        } else {
            grade = new Grade();
            grade.setCreatedBy(getActiveUser().getIdentifier());
            grade.setCreatedDate(new Date());

            grades.add(0, grade);

        }
    }

    public void save(Grade gr) {
        if (gr.getId() != null) {
            gradeService.update(gr);
        } else {
            gradeService.save(gr);
        }
        this.resetView(false).setList(true);
    }

    public void delete(Grade gr) {
        gradeService.deleteById(gr.getId());
        synchronize(gr);
        this.resetView(false).setList(true);
    }

    public void synchronize(Grade gr) {
        Iterator<Grade> gradeList = grades.iterator();
        while (gradeList.hasNext()) {
            if (gradeList.next().getId().equals(gr.getId())) {
                gradeList.remove();
            }
        }
    }

    public void cancel(Grade gr) {
        if (gr.getId() == null) {
            if (grades.contains(gr)) {
                grades.remove(gr);
            }
        }
        this.resetView(false).setList(true);
    }

    public GradeServiceLocal getGradeService() {
        return gradeService;
    }

    public void setGradeService(GradeServiceLocal gradeService) {
        this.gradeService = gradeService;
    }

    public SchoolServiceLocal getSchoolService() {
        return schoolService;
    }

    public void setSchoolService(SchoolServiceLocal schoolService) {
        this.schoolService = schoolService;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    
}
