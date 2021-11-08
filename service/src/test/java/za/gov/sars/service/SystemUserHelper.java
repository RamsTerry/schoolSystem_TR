/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.service;

import java.util.Date;
import za.gov.sars.common.EmployeeType;
import za.gov.sars.common.PersonType;
import za.gov.sars.common.SystemUserStatus;
import za.gov.sars.common.SystemUserType;
import za.gov.sars.domain.Address;
import za.gov.sars.domain.ContactDetails;
import za.gov.sars.domain.Employee;
import za.gov.sars.domain.Student;
import za.gov.sars.domain.SystemUser;
import za.gov.sars.persistance.EmployeeRepository;
import za.gov.sars.persistance.StudentRepository;
import za.gov.sars.persistance.SystemUserRepository;

/**
 *
 * @author S2028398
 */
public class SystemUserHelper {
    public static void addSystemUser(SystemUserRepository systemUserRepository, EmployeeRepository employeeRepository, StudentRepository studentRepository) {
        int userCount = 1;

        for (Employee employeec : employeeRepository.findAll()) {

            if (employeec.getEmployeeType().equals(EmployeeType.ADMIN)) {

                SystemUser systemUser1 = new SystemUser();
                systemUser1.setCreatedBy("Test");
                systemUser1.setCreatedDate(new Date());
                systemUser1.setPersonType(PersonType.SYSTEM_USER);
                systemUser1.setSystemUserStatus(SystemUserStatus.ACTIVE);
                systemUser1.setSystemUserType(SystemUserType.SYSTEM_ADMIN);
                systemUser1.setUsername("admin" + userCount);
                systemUser1.setPassword("admin" + userCount);
                systemUser1.setFirstName(employeec.getFirstName());
                systemUser1.setLastName(employeec.getLastName());
                systemUser1.setIdentityNumber(employeec.getIdentityNumber());
                systemUser1.setIdentifier(employeec.getEmployeeId());
                systemUser1.setGenderType(employeec.getGenderType());
                systemUser1.setSchool(employeec.getSchool());

                for (Address address : employeec.getAddressList()) {
                    Address addressp = new Address();
                    addressp.setCreatedBy("Test");
                    addressp.setCreatedDate(new Date());
                    addressp.setAddressType(address.getAddressType());
                    addressp.setAddressLine1(address.getAddressLine1());
                    addressp.setAddressLine2(address.getAddressLine2());
                    addressp.setStreet(address.getStreet());
                    addressp.setArea(address.getArea());
                    addressp.setCode(address.getCode());
                    systemUser1.addAddress(addressp);
                }
                ContactDetails contactDetail = new ContactDetails();
                contactDetail.setCreatedBy("Test");
                contactDetail.setCreatedDate(new Date());
                contactDetail.setCellphoneNumber(employeec.getContactDetails().getCellphoneNumber());
                contactDetail.setTelephoneNumber(employeec.getContactDetails().getTelephoneNumber());
                contactDetail.setEmailAddress(employeec.getContactDetails().getEmailAddress());
                systemUser1.setContactDetails(contactDetail);

                systemUserRepository.save(systemUser1);
                userCount++;
            }
            
                if (employeec.getEmployeeType().equals(EmployeeType.EDUCATOR)) {

                SystemUser systemUser2 = new SystemUser();
                systemUser2.setCreatedBy("Test");
                systemUser2.setCreatedDate(new Date());
                systemUser2.setPersonType(PersonType.SYSTEM_USER);
                systemUser2.setSystemUserStatus(SystemUserStatus.ACTIVE);
                systemUser2.setSystemUserType(SystemUserType.EMPLOYEE);
                systemUser2.setUsername("Employee" + userCount);
                systemUser2.setPassword("Employee" + userCount);
                systemUser2.setFirstName(employeec.getFirstName());
                systemUser2.setLastName(employeec.getLastName());
                systemUser2.setIdentityNumber(employeec.getIdentityNumber());
                systemUser2.setIdentifier(employeec.getEmployeeId());
                systemUser2.setGenderType(employeec.getGenderType());
                systemUser2.setSchool(employeec.getSchool());

                for (Address address : employeec.getAddressList()) {
                    Address addressp = new Address();
                    addressp.setCreatedBy("Test");
                    addressp.setCreatedDate(new Date());
                    addressp.setAddressType(address.getAddressType());
                    addressp.setAddressLine1(address.getAddressLine1());
                    addressp.setAddressLine2(address.getAddressLine2());
                    addressp.setStreet(address.getStreet());
                    addressp.setArea(address.getArea());
                    addressp.setCode(address.getCode());
                    systemUser2.addAddress(addressp);
                }
                ContactDetails contactDetail = new ContactDetails();
                contactDetail.setCreatedBy("Test");
                contactDetail.setCreatedDate(new Date());
                contactDetail.setCellphoneNumber(employeec.getContactDetails().getCellphoneNumber());
                contactDetail.setTelephoneNumber(employeec.getContactDetails().getTelephoneNumber());
                contactDetail.setEmailAddress(employeec.getContactDetails().getEmailAddress());
                systemUser2.setContactDetails(contactDetail);

                systemUserRepository.save(systemUser2);
                userCount++;
            }

        }

         userCount = 1;

        for (Student student : studentRepository.findAll()) {

                SystemUser systemUser = new SystemUser();
                systemUser.setCreatedBy("Test");
                systemUser.setCreatedDate(new Date());
                systemUser.setPersonType(PersonType.SYSTEM_USER);
                systemUser.setSystemUserStatus(SystemUserStatus.ACTIVE);
                systemUser.setSystemUserType(SystemUserType.LEARNER);
                systemUser.setUsername("Learner" + userCount);
                systemUser.setPassword("Learner" + userCount);
                systemUser.setFirstName(student.getFirstName());
                systemUser.setLastName(student.getLastName());
                systemUser.setIdentityNumber(student.getIdentityNumber());
                systemUser.setIdentifier(student.getStudentId());
                systemUser.setGenderType(student.getGenderType());
                systemUser.setSchool(student.getSchool());

                for (Address address : student.getAddressList()) {
                    Address addressp = new Address();
                    addressp.setCreatedBy("Test");
                    addressp.setCreatedDate(new Date());
                    addressp.setAddressType(address.getAddressType());
                    addressp.setAddressLine1(address.getAddressLine1());
                    addressp.setAddressLine2(address.getAddressLine2());
                    addressp.setStreet(address.getStreet());
                    addressp.setArea(address.getArea());
                    addressp.setCode(address.getCode());
                    systemUser.addAddress(addressp);
                }
                ContactDetails contactDetail = new ContactDetails();
                contactDetail.setCreatedBy("Test");
                contactDetail.setCreatedDate(new Date());
                contactDetail.setCellphoneNumber(student.getContactDetails().getCellphoneNumber());
                contactDetail.setTelephoneNumber(student.getContactDetails().getTelephoneNumber());
                contactDetail.setEmailAddress(student.getContactDetails().getEmailAddress());
                systemUser.setContactDetails(contactDetail);

                systemUserRepository.save(systemUser);
                userCount++;
        }
    } 
}
