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
import za.gov.sars.common.SystemUserStatus;
import za.gov.sars.common.SystemUserType;
import za.gov.sars.domain.Address;
import za.gov.sars.domain.ContactDetails;
import za.gov.sars.domain.Employee;
import za.gov.sars.domain.School;
import za.gov.sars.domain.Student;
import za.gov.sars.domain.SystemUser;
import za.gov.sars.service.EmployeeServiceLocal;
import za.gov.sars.service.SchoolServiceLocal;
import za.gov.sars.service.StudentServiceLocal;
import za.gov.sars.service.SystemUserServiceLocal;

/**
 *
 * @author S2028398
 */
@ManagedBean
@ViewScoped
public class SystemUserBean extends BaseBean {

    @Autowired //to be able to allow the communication in between
    private SystemUserServiceLocal systemUserService;
    @Autowired
    private EmployeeServiceLocal employeeService;
    @Autowired
    private StudentServiceLocal studentService;
    @Autowired
    private SchoolServiceLocal schoolService;

    private List<SystemUser> systemUsers = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    private List<AddressType> addressTypes;
    private List<GenderType> genders;
    private List<SystemUserType> systemUserTypes;
    private List<SystemUserStatus> systemUserStatus;

    private School school;
    private SystemUser systemUser;
    private Employee staff;
    private Student student;

    @PostConstruct
    public void init() {
        this.resetView(false).setList(true);
        systemUsers = systemUserService.listAll();
        employees = employeeService.listAll();
        students = studentService.listAll();
        addressTypes = Arrays.asList(AddressType.values());
        genders = Arrays.asList(GenderType.values());
        systemUserTypes = Arrays.asList(SystemUserType.values());
        systemUserStatus = Arrays.asList(SystemUserStatus.values());
        school = schoolService.listAll().get(schoolService.listAll().size() - 1);
    }

    public void addorUpdate(SystemUser user) {
        this.resetView(false).setAdd(true);
        if (user != null) {
            if (user.getSystemUserType().equals(SystemUserType.EMPLOYEE)) {
                staff = employeeService.findEmployeeByEmployeeNum(user.getIdentifier());
            } else if (user.getSystemUserType().equals(SystemUserType.SYSTEM_ADMIN)) {
                staff = employeeService.findEmployeeByEmployeeNum(user.getIdentifier());
            } else if (user.getSystemUserType().equals(SystemUserType.LEARNER)) {
                student = studentService.findStudentByStudentNum(user.getIdentifier());
            }
            user.setUpdatedBy(getActiveUser().getIdentifier());
            user.setUpdatedDate(new Date());
            systemUser = user;
        } else {
            systemUser = new SystemUser();
            systemUser.setCreatedBy("");
            systemUser.setCreatedDate(new Date());
            systemUser.setSchool(school);
            systemUser.setPersonType(PersonType.SYSTEM_USER);

            systemUsers.add(0, systemUser);
        }
    }

    public void save(SystemUser user) {
        if (user.getPassword().equals(user.getConfirmPassword())) {
            if (user.getId() != null) {
                user.setCreatedBy(getActiveUser().getIdentifier());
                user.setUpdatedDate(new Date());
                systemUserService.update(user);
            } else {

                if (useExist(user)) {
                    if (user.getSystemUserType().equals(SystemUserType.EMPLOYEE) || user.getSystemUserType().equals(SystemUserType.SYSTEM_ADMIN)) {

                        staff = employeeService.findEmployeeByEmployeeNum(user.getIdentifier());
                        user.setFirstName(staff.getFirstName());
                        user.setLastName(staff.getLastName());
                        user.setIdentityNumber(staff.getIdentityNumber());
                        user.setGenderType(staff.getGenderType());

                        for (Address address : staff.getAddressList()) {
                            Address address1c = new Address();
                            address1c.setCreatedBy(getActiveUser().getIdentifier());
                            address1c.setCreatedDate(new Date());
                            address1c.setAddressType(address.getAddressType());
                            address1c.setAddressLine1(address.getAddressLine1());
                            address1c.setAddressLine2(address.getAddressLine2());
                            address1c.setStreet(address.getStreet());
                            address1c.setArea(address.getArea());
                            address1c.setCode(address.getCode());
                            user.addAddress(address1c);
                        }
                        ContactDetails contactDetail = new ContactDetails();
                        contactDetail.setCreatedBy(getActiveUser().getIdentifier());
                        contactDetail.setCreatedDate(new Date());
                        contactDetail.setCellphoneNumber(staff.getContactDetails().getCellphoneNumber());
                        contactDetail.setTelephoneNumber(staff.getContactDetails().getTelephoneNumber());
                        contactDetail.setEmailAddress(staff.getContactDetails().getEmailAddress());
                        user.setContactDetails(contactDetail);

                        systemUserService.save(user);
                    } else if (user.getSystemUserType().equals(SystemUserType.LEARNER)) {
                        student = studentService.findStudentByStudentNum(user.getIdentifier());
                        user.setFirstName(student.getFirstName());
                        user.setLastName(student.getLastName());
                        user.setIdentityNumber(student.getIdentityNumber());
                        user.setGenderType(student.getGenderType());

                        for (Address address : student.getAddressList()) {
                            Address address1 = new Address();
                            address1.setCreatedBy(getActiveUser().getIdentifier());
                            address1.setCreatedDate(new Date());
                            address1.setAddressType(address.getAddressType());
                            address1.setAddressLine1(address.getAddressLine1());
                            address1.setAddressLine2(address.getAddressLine2());
                            address1.setStreet(address.getStreet());
                            address1.setArea(address.getArea());
                            address1.setCode(address.getCode());
                            user.addAddress(address1);
                        }
                        ContactDetails contactDetail2 = new ContactDetails();
                        contactDetail2.setCreatedBy(getActiveUser().getIdentifier());
                        contactDetail2.setCreatedDate(new Date());
                        contactDetail2.setCellphoneNumber(student.getContactDetails().getCellphoneNumber());
                        contactDetail2.setTelephoneNumber(student.getContactDetails().getTelephoneNumber());
                        contactDetail2.setEmailAddress(student.getContactDetails().getEmailAddress());
                        user.setContactDetails(contactDetail2);
                        systemUserService.save(user);
                    }
                } else {
                    addWarningMessage("The person you try to register to register Already Exist as User!");
                }
            }
            this.resetView(false).setList(true);

        } else {
            addWarningMessage("Password provided is not the same as the confirmation password,check your password please!");
        }
    }

    public void delete(SystemUser user) {

        systemUserService.deleteById(user.getId());
        this.resetView(false).setList(true);
    }

    public void synchronize(SystemUser user) {
        Iterator<SystemUser> userList = systemUsers.iterator();
        while (userList.hasNext()) {
            if (userList.next().getId().equals(user.getId())) {
                userList.remove();
            }
        }
    }

    public void cancel(SystemUser user) {
        if (user.getId() == null) {
            if (systemUsers.contains(user)) {
                systemUsers.remove(user);
            }
        }
        this.resetView(false).setList(true);
    }

    public List<String> getIdentifier() {
        List<String> allIdentities = new ArrayList<>();
        for (SystemUser user : systemUserService.listAll()) {
            allIdentities.add(user.getIdentifier());
        }
        return allIdentities;
    }

    public void systemUserTypeListener() {
        if (systemUser.getSystemUserType().equals(SystemUserType.EMPLOYEE) || systemUser.getSystemUserType().equals(SystemUserType.SYSTEM_ADMIN)) {
            setVisibleTab(false);
            setVisible(true);
        } else if (systemUser.getSystemUserType().equals(SystemUserType.LEARNER)) {
            setVisibleTab(true);
            setVisible(false);
        }
    }

    public boolean useExist(SystemUser user) {
        for (SystemUser sysUser : systemUserService.listAll()) {
            if (user.getIdentifier().equals(sysUser.getIdentifier())) {
                return true;
            }
        }
        return false;
    }

    public List<SystemUser> getSystemUsers() {
        return systemUsers;
    }

    public void setSystemUsers(List<SystemUser> systemUsers) {
        this.systemUsers = systemUsers;
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

    public List<SystemUserType> getSystemUserTypes() {
        return systemUserTypes;
    }

    public void setSystemUserTypes(List<SystemUserType> systemUserTypes) {
        this.systemUserTypes = systemUserTypes;
    }

    public List<SystemUserStatus> getSystemUserStatus() {
        return systemUserStatus;
    }

    public void setSystemUserStatus(List<SystemUserStatus> systemUserStatus) {
        this.systemUserStatus = systemUserStatus;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public SystemUser getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }

    public Employee getStaff() {
        return staff;
    }

    public void setStaff(Employee staff) {
        this.staff = staff;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

   
}
