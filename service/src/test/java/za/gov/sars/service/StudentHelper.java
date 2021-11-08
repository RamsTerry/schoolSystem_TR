/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.service;

import java.util.Date;
import za.gov.sars.common.AddressType;
import za.gov.sars.common.GenderType;
import za.gov.sars.common.PersonType;
import za.gov.sars.domain.Address;
import za.gov.sars.domain.ContactDetails;
import za.gov.sars.domain.Student;
import za.gov.sars.persistance.GradeRepository;
import za.gov.sars.persistance.SchoolRepository;
import za.gov.sars.persistance.StudentRepository;
import za.gov.sars.persistance.SubjectRepository;

/**
 *
 * @author S2028398
 */
public class StudentHelper {
  public static void addStudent(StudentRepository studentRepository, GradeRepository gradeRepository, SubjectRepository subjectRepository,SchoolRepository schoolRepository) {

        Student student = new Student();
        student.setCreatedBy("Test");
        student.setCreatedDate(new Date());
        student.setPersonType(PersonType.LEARNER);
        student.setFirstName("Mulalo");
        student.setLastName("Mudau");
        student.setIdentityNumber("9887998528885");
        student.setStudentId("14014293");
        student.setGenderType(GenderType.FEMALE);
        student.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        student.setGrade(gradeRepository.findAll().get(gradeRepository.findAll().size()-1));
        student.setSubjects(subjectRepository.findAll());
        
        ContactDetails contactDetail = new ContactDetails();
        contactDetail.setCreatedBy("Test");
        contactDetail.setCreatedDate(new Date());
        contactDetail.setCellphoneNumber("0799035403");
        contactDetail.setTelephoneNumber("0144544745");
        contactDetail.setEmailAddress("tramurebiwa.sars.gov.za");
        student.setContactDetails(contactDetail);
        
        Address address1 = new Address();
        address1.setCreatedBy("Test");
        address1.setCreatedDate(new Date());
        address1.setAddressType(AddressType.RESIDENTIAL);
        address1.setAddressLine1("ngwenani 002");
        address1.setAddressLine2("P.O BOX 25");
        address1.setStreet("Ext 9");
        address1.setArea("Vuwani");
        address1.setCode("001");

        Address address2 = new Address();
        address2.setCreatedBy("Test");
        address2.setCreatedDate(new Date());
        address2.setAddressType(AddressType.POSTAL);
        address2.setAddressLine2("218 Soweto");
        address2.setStreet("16th stand");
        address2.setArea("Tshiawelo");
        address2.setCode("200");

        student.addAddress(address1);
        student.addAddress(address2);
        studentRepository.save(student);

        Student student1 = new Student();
        student1.setCreatedBy("Test");
        student1.setCreatedDate(new Date());
        student1.setPersonType(PersonType.LEARNER);
        student1.setFirstName("Terry");
        student1.setLastName("Ramurebiwa");
        student1.setIdentityNumber("9503146171081");
        student1.setStudentId("14055487");
        student1.setGenderType(GenderType.MALE);
        student1.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        student1.setGrade(gradeRepository.findAll().get(gradeRepository.findAll().size()-3));
        student1.setSubjects(subjectRepository.findAll());

        ContactDetails contactDetail1 = new ContactDetails();
        contactDetail1.setCreatedBy("Test");
        contactDetail1.setCreatedDate(new Date());
        contactDetail1.setCellphoneNumber("061557443");
        contactDetail1.setTelephoneNumber("011044735");
        contactDetail1.setEmailAddress("treal.sars.gov.za");
        student1.setContactDetails(contactDetail1);

        Address address4 = new Address();
        address4.setCreatedBy("Test");
        address4.setCreatedDate(new Date());
        address4.setAddressType(AddressType.RESIDENTIAL);
        address4.setAddressLine1("ngwenani 002");
        address4.setAddressLine2("P.O BOX 25");
        address4.setStreet("Ext 9");
        address4.setArea("Vuwani");
        address4.setCode("001");

        Address address5 = new Address();
        address5.setCreatedBy("Test");
        address5.setCreatedDate(new Date());
        address5.setAddressType(AddressType.POSTAL);
        address5.setAddressLine2("218 mavhoi");
        address5.setStreet("16th stand");
        address5.setArea("thondo");
        address5.setCode("2090");

        student1.addAddress(address4);
        student1.addAddress(address5);
        studentRepository.save(student1);
        
        Student student2 = new Student();
        student2.setCreatedBy("Test");
        student2.setCreatedDate(new Date());
        student2.setPersonType(PersonType.LEARNER);
        student2.setFirstName("Tshifhiwa");
        student2.setLastName("Mukatuni");
        student2.setIdentityNumber("8872846171081");
        student2.setStudentId("14550111");
        student2.setGenderType(GenderType.MALE);
        student2.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        student2.setGrade(gradeRepository.findAll().get(gradeRepository.findAll().size()-2));
        student2.setSubjects(subjectRepository.findAll());

        ContactDetails contactDetail2 = new ContactDetails();
        contactDetail2.setCreatedBy("Test");
        contactDetail2.setCreatedDate(new Date());
        contactDetail2.setCellphoneNumber("0713664035");
        contactDetail2.setTelephoneNumber("0152235545");
        contactDetail2.setEmailAddress("mukatunit.sars.gov.za");
        student2.setContactDetails(contactDetail2);

        Address addressstd2 = new Address();
        addressstd2.setCreatedBy("Test");
        addressstd2.setCreatedDate(new Date());
        addressstd2.setAddressType(AddressType.RESIDENTIAL);
        addressstd2.setAddressLine1("Matavhela 102");
        addressstd2.setAddressLine2("P.O BOX 2533");
        addressstd2.setStreet("Zone 2");
        addressstd2.setArea("Matavhela 2");
        addressstd2.setCode("0055");

        Address addressstd3 = new Address();
        addressstd3.setCreatedBy("Test");
        addressstd3.setCreatedDate(new Date());
        addressstd3.setAddressType(AddressType.POSTAL);
        addressstd3.setAddressLine2("218 Alexandra");
        addressstd3.setStreet("14 stand");
        addressstd3.setArea("Ruth");
        addressstd3.setCode("2080");

        student2.addAddress(addressstd2);
        student2.addAddress(addressstd3);
        studentRepository.save(student2);
        
        Student student3 = new Student();
        student3.setCreatedBy("Test");
        student3.setCreatedDate(new Date());
        student3.setPersonType(PersonType.LEARNER);
        student3.setFirstName("Mudau");
        student3.setLastName("Viollah");
        student3.setIdentityNumber("96021036171081");
        student3.setStudentId("14558873");
        student3.setGenderType(GenderType.FEMALE);
        student3.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        student3.setGrade(gradeRepository.findAll().get(gradeRepository.findAll().size()-4));
        student3.setSubjects(subjectRepository.findAll());

        ContactDetails contactDetail3 = new ContactDetails();
        contactDetail3.setCreatedBy("Test");
        contactDetail3.setCreatedDate(new Date());
        contactDetail3.setCellphoneNumber("0847035540");
        contactDetail3.setTelephoneNumber("0152658771");
        contactDetail3.setEmailAddress("vmudau.sars.gov.za");
        student3.setContactDetails(contactDetail3);

        Address addressstd32 = new Address();
        addressstd32.setCreatedBy("Test");
        addressstd32.setCreatedDate(new Date());
        addressstd32.setAddressType(AddressType.RESIDENTIAL);
        addressstd32.setAddressLine1("Hamasakona 102");
        addressstd32.setAddressLine2("P.O BOX 253");
        addressstd32.setStreet("Ext 2");
        addressstd32.setArea("Maskona 2");
        addressstd32.setCode("0071");

        Address addressstd34 = new Address();
        addressstd34.setCreatedBy("Test");
        addressstd34.setCreatedDate(new Date());
        addressstd34.setAddressType(AddressType.POSTAL);
        addressstd34.setAddressLine2("277 Midrend");
        addressstd34.setStreet("House 255");
        addressstd34.setArea("Oliven");
        addressstd34.setCode("2077");

        student3.addAddress(addressstd32);
        student3.addAddress(addressstd34);
        studentRepository.save(student3);
    }   
}
