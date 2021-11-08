/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.service;

import java.util.Date;
import za.gov.sars.common.AddressType;
import za.gov.sars.common.EmployeeType;
import za.gov.sars.common.GenderType;
import za.gov.sars.common.PersonType;
import za.gov.sars.domain.Address;
import za.gov.sars.domain.ContactDetails;
import za.gov.sars.domain.Employee;
import za.gov.sars.persistance.EmployeeRepository;
import za.gov.sars.persistance.GradeRepository;
import za.gov.sars.persistance.SchoolRepository;
import za.gov.sars.persistance.SubjectRepository;

/**
 *
 * @author S2028398
 */
public class EmployeeHelper {
  public static void addEmployee(EmployeeRepository employeeRepository, GradeRepository gradeRepository, SubjectRepository subjectRepository, SchoolRepository schoolRepository) {

        Employee employee1 = new Employee();
        employee1.setCreatedBy("Test");
        employee1.setCreatedDate(new Date());
        employee1.setPersonType(PersonType.EMPLOYEE);
        employee1.setEmployeeType(EmployeeType.EDUCATOR);
        employee1.setFirstName("Percy");
        employee1.setLastName("Ramurebiwa");
        employee1.setIdentityNumber("9887998528885");
        employee1.setEmployeeId("17889887");
        employee1.setSaceRegNumber("00078669");
        employee1.setGenderType(GenderType.MALE);
        employee1.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        employee1.setGrades(gradeRepository.findAll());
        employee1.setSubjectList(subjectRepository.findAll());

        ContactDetails contactDetail = new ContactDetails();
        contactDetail.setCreatedBy("Test");
        contactDetail.setCreatedDate(new Date());
        contactDetail.setCellphoneNumber("0799035403");
        contactDetail.setEmailAddress("pramurebiwa.sars.gov.za");
        contactDetail.setTelephoneNumber("0115543411");
        employee1.setContactDetails(contactDetail);

        Address address1 = new Address();
        address1.setCreatedBy("Test");
        address1.setCreatedDate(new Date());
        address1.setAddressType(AddressType.RESIDENTIAL);
        address1.setAddressLine1("6176 Aldo Magano 2090");
        address1.setAddressLine2("Aldo Magano");
        address1.setStreet("Block J");
        address1.setArea("Thohoyandou");
        address1.setCode("0950");

        Address address2 = new Address();
        address2.setCreatedBy("Test");
        address2.setCreatedDate(new Date());
        address2.setAddressType(AddressType.POSTAL);
        address2.setAddressLine2("P.O BOX 4023");
        address2.setStreet("16th Ruth");
        address2.setArea("Ngovhela");
        address2.setCode("2090");

        employee1.addAddress(address1);
        employee1.addAddress(address2);
        employeeRepository.save(employee1);
        //////////////////////////////////////////////////////////////////admin

        Employee employee2 = new Employee();
        employee2.setCreatedBy("Test");
        employee2.setCreatedDate(new Date());
        employee2.setPersonType(PersonType.EMPLOYEE);
        employee2.setFirstName("Ndivhuwo");
        employee2.setLastName("Tshiedza");
        employee2.setIdentityNumber("900990899852");
        employee2.setEmployeeId("17889888");
        employee2.setEmployeeType(EmployeeType.ADMIN);
        employee2.setGenderType(GenderType.MALE);
        employee2.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));

        ContactDetails contactDetail1 = new ContactDetails();
        contactDetail1.setCreatedBy("Test");
        contactDetail1.setCreatedDate(new Date());
        contactDetail1.setCellphoneNumber("0714478811");
        contactDetail1.setEmailAddress("ntshiedza.sars.gov.za");
        contactDetail1.setTelephoneNumber("0115544755");
        employee2.setContactDetails(contactDetail1);

        Address addressr = new Address();
        addressr.setCreatedBy("Test");
        addressr.setCreatedDate(new Date());
        addressr.setAddressType(AddressType.RESIDENTIAL);
        addressr.setAddressLine1("2090 street");
        addressr.setAddressLine2("Muledane");
        addressr.setStreet("Block N");
        addressr.setArea("Thohoyandou");
        addressr.setCode("0950");

        Address addressp = new Address();
        addressp.setCreatedBy("Test");
        addressp.setCreatedDate(new Date());
        addressp.setAddressType(AddressType.POSTAL);
        addressp.setAddressLine2("P.O BOX 447 ");
        addressp.setStreet("16th Ruth");
        addressp.setArea("Alexandra");
        addressp.setCode("2090");
        
        employee1.addAddress(addressr);
        employee1.addAddress(addressp);
        employeeRepository.save(employee2);
        ///////////////////////////////////////////////////////////clerk

        Employee employee3 = new Employee();
        employee3.setCreatedBy("Test");
        employee3.setCreatedDate(new Date());
        employee3.setPersonType(PersonType.EMPLOYEE);
        employee3.setFirstName("Mashudu");
        employee3.setLastName("Mulaudzi");
        employee3.setIdentityNumber("94444746171081");
        employee3.setEmployeeId("7788978");
        employee3.setEmployeeType(EmployeeType.CLERK);
        employee3.setGenderType(GenderType.FEMALE);
        employee3.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));

        ContactDetails contactDetail2 = new ContactDetails();
        contactDetail2.setCreatedBy("Test");
        contactDetail2.setCreatedDate(new Date());
        contactDetail2.setCellphoneNumber("0736772755");
        contactDetail2.setEmailAddress("mmudau.sars.gov.za");
        contactDetail2.setTelephoneNumber("00021145");
        employee3.setContactDetails(contactDetail2);

        Address address4 = new Address();
        address4.setCreatedBy("Test");
        address4.setCreatedDate(new Date());
        address4.setAddressType(AddressType.RESIDENTIAL);
        address4.setAddressLine1("87 STREET");
        address4.setAddressLine2("Manini");
        address4.setStreet("Manini");
        address4.setArea("Thohoyandou");
        address4.setCode("0950");

        Address address6 = new Address();
        address6.setCreatedBy("Test");
        address6.setCreatedDate(new Date());
        address6.setAddressType(AddressType.POSTAL);
        address6.setAddressLine2("P.O BOX 447");
        address6.setStreet("Codesa");
        address6.setArea("Hamutsa");
        address6.setCode("2090");

        employee3.addAddress(address4);
        employee3.addAddress(address6);
        employeeRepository.save(employee3);
        ////////////////////////////////////////////////general
        Employee employee4 = new Employee();
        employee4.setCreatedBy("Test");
        employee4.setCreatedDate(new Date());
        employee4.setPersonType(PersonType.EMPLOYEE);
        employee4.setFirstName("Kelly");
        employee4.setLastName("Mphephu");
        employee4.setIdentityNumber("71042567171081");
        employee4.setEmployeeId("7788978");
        employee4.setEmployeeType(EmployeeType.GENERAL_WORKER);
        employee4.setGenderType(GenderType.FEMALE);
        employee4.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));

        ContactDetails contactDetail21 = new ContactDetails();
        contactDetail21.setCreatedBy("Test");
        contactDetail21.setCreatedDate(new Date());
        contactDetail21.setCellphoneNumber("0736772755");
        contactDetail21.setEmailAddress("km.sars.gov.za");
        contactDetail21.setTelephoneNumber("0102588785");
        employee3.setContactDetails(contactDetail21);

        Address address41 = new Address();
        address41.setCreatedBy("Test");
        address41.setCreatedDate(new Date());
        address41.setAddressType(AddressType.RESIDENTIAL);
        address41.setAddressLine1("87 STREET Marundu");
        address41.setAddressLine2("");
        address41.setStreet("Marundu");
        address41.setArea("Tshirangadzi");
        address41.setCode("0970");

        Address address61 = new Address();
        address61.setCreatedBy("Test");
        address61.setCreatedDate(new Date());
        address61.setAddressType(AddressType.POSTAL);
        address61.setAddressLine2("P.O BOX 488");
        address61.setStreet("Lwams");
        address61.setArea("Ltown");
        address61.setCode("2010");

        employee3.addAddress(address41);
        employee3.addAddress(address61);
        employeeRepository.save(employee3);

    }  
}
