/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.mb;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import za.gov.sars.domain.Address;
import za.gov.sars.domain.ContactDetails;
import za.gov.sars.domain.Employee;
import za.gov.sars.domain.Student;
import za.gov.sars.domain.SystemUser;
import za.gov.sars.service.EmployeeServiceLocal;
import za.gov.sars.service.StudentServiceLocal;
import za.gov.sars.service.SystemUserServiceLocal;

/**
 *
 * @author S2028398
 */
@ManagedBean
@ViewScoped
public class ProfileBean extends BaseBean {

    @Autowired //to be able to allow the communication in between
    private EmployeeServiceLocal employeeService;
    @Autowired //to be able to allow the communication in between
    private StudentServiceLocal studentService;
    @Autowired //to be able to allow the communication in between
    private SystemUserServiceLocal systemUserService;

    private Employee staff;
    private Student student;
    private SystemUser systemUser;

    @PostConstruct
    public void init() {
        staff = employeeService.findEmployeeByEmployeeNum(getActiveUser().getIdentifier());
        student = studentService.findStudentByStudentNum(getActiveUser().getIdentifier());
        systemUser = systemUserService.findSystemUserByIdentifier(getActiveUser().getIdentifier());
    }

    public void saveEmployee(Employee emp, SystemUser user) {
        if (user.getPassword().equals(user.getConfirmPassword())) {
            employeeService.update(emp);

            user.setFirstName(emp.getFirstName());
            user.setLastName(emp.getLastName());
            user.setIdentityNumber(emp.getIdentityNumber());
            user.setIdentifier(emp.getEmployeeId());
            user.setGenderType(emp.getGenderType());

            for (Address address : emp.getAddressList()) {
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
            contactDetail.setCellphoneNumber(emp.getContactDetails().getCellphoneNumber());
            contactDetail.setTelephoneNumber(emp.getContactDetails().getTelephoneNumber());
            contactDetail.setEmailAddress(emp.getContactDetails().getEmailAddress());
            user.setContactDetails(contactDetail);
            systemUserService.update(user);
        } else {
            addWarningMessage("The password provided is not the same as the confirmation, please check and try again");
        }
    }

    public void saveStudent(Student std, SystemUser user) {
        if (user.getPassword().equals(user.getConfirmPassword())) {
            studentService.update(std);
            systemUserService.update(user);

            user.setFirstName(std.getFirstName());
            user.setLastName(std.getLastName());
            user.setIdentityNumber(std.getIdentityNumber());
            user.setIdentifier(std.getStudentId());
            user.setGenderType(std.getGenderType());

            for (Address address : std.getAddressList()) {
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
            contactDetail.setCellphoneNumber(std.getContactDetails().getCellphoneNumber());
            contactDetail.setTelephoneNumber(std.getContactDetails().getTelephoneNumber());
            contactDetail.setEmailAddress(std.getContactDetails().getEmailAddress());
            user.setContactDetails(contactDetail);
            systemUserService.update(user);
        } else {
            addWarningMessage("The password provided is not the same as the confirmation, please check and try again");
        }
    }

    public void cancel() {
        redirecting("/landing");
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

    public SystemUser getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }

   
}
