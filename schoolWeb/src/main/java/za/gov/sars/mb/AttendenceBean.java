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
import za.gov.sars.common.AttendenceStatus;
import za.gov.sars.domain.Attendence;
import za.gov.sars.domain.Employee;
import za.gov.sars.domain.Facility;
import za.gov.sars.domain.Student;
import za.gov.sars.service.AttendenceServiceLocal;
import za.gov.sars.service.EmployeeServiceLocal;
import za.gov.sars.service.FacilityServiceLocal;
import za.gov.sars.service.StudentServiceLocal;

/**
 *
 * @author S2028398
 */
@ManagedBean
@ViewScoped
public class AttendenceBean extends BaseBean {

    @Autowired
    private AttendenceServiceLocal attendenceService;
    @Autowired
    private EmployeeServiceLocal employeeService;
    @Autowired
    private FacilityServiceLocal facilityService;
    @Autowired
    private StudentServiceLocal studentService;
    
    private List<Attendence> attendences = new ArrayList<>();
    private List<Facility> Facilities = new ArrayList<>();
    
    private List<AttendenceStatus> attendanceStatuses = new ArrayList<>();
    
    private Attendence attendence;
    private Employee teacher;
    private Student student;
    
    @PostConstruct
    public void init() {
        this.resetView(false).setList(true);
        attendences = attendenceService.listAll();
        if (getActiveUser().isLearner()) {
            student = studentService.findStudentByStudentNum(getActiveUser().getIdentifier());
        } else {
            teacher = employeeService.findEmployeeByEmployeeNum(getActiveUser().getIdentifier());
        }              
        Facilities = facilityService.listAll();
        attendanceStatuses = Arrays.asList(AttendenceStatus.values());        
    }


    public void addOrUpdate(Attendence attend) {
        this.resetView(false).setAdd(true);
        if (attend != null) {
            attend.setUpdatedBy(getActiveUser().getIdentifier());
            attend.setUpdatedDate(new Date());
            attendence = attend;
        } else {
            attendence = new Attendence();
            attendence.setCreatedBy(getActiveUser().getIdentifier());
            attendence.setCreatedDate(new Date());
            
            attendences.add(0, attendence);
        }
    }

    public void save(Attendence attend) {
        if (attend.getId() != null) {
            attend.setUpdatedBy(getActiveUser().getIdentifier());
            attend.setUpdatedDate(new Date());
            attendenceService.update(attend);
        } else {
            attendenceService.save(attend);
        }
        this.resetView(false).setList(true);
    }

    public void delete(Attendence attend) {
        attendenceService.deleteById(attend.getId());
        synchronize(attend);
        this.resetView(false).setList(true);
    }

    public void synchronize(Attendence attend) {
        Iterator<Attendence> attenceList = attendences.iterator();
        while (attenceList.hasNext()) {
            if (attenceList.next().getId().equals(attend.getId())) {
                attenceList.remove();
            }
        }
    }

    public void cancel(Attendence attend) {
        if (attend.getId() == null) {
            if (attendences.contains(attend)) {
                attendences.remove(attend);
            }
        }
        this.resetView(false).setList(true);
    }

    public FacilityServiceLocal getFacilityService() {
        return facilityService;
    }

    public void setFacilityService(FacilityServiceLocal facilityService) {
        this.facilityService = facilityService;
    }

    public List<Attendence> getAttendences() {
        return attendences;
    }

    public void setAttendences(List<Attendence> attendences) {
        this.attendences = attendences;
    }

    public List<Facility> getFacilities() {
        return Facilities;
    }

    public void setFacilities(List<Facility> Facilities) {
        this.Facilities = Facilities;
    }

    public Attendence getAttendence() {
        return attendence;
    }

    public void setAttendence(Attendence attendence) {
        this.attendence = attendence;
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

    public List<AttendenceStatus> getAttendanceStatuses() {
        return attendanceStatuses;
    }

    public void setAttendanceStatuses(List<AttendenceStatus> attendanceStatuses) {
        this.attendanceStatuses = attendanceStatuses;
    }


}
