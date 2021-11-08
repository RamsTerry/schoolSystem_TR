/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.service;


import java.util.Date;
import za.gov.sars.common.AddressType;
import za.gov.sars.domain.Address;
import za.gov.sars.domain.ContactDetails;
import za.gov.sars.domain.School;
import za.gov.sars.persistance.SchoolRepository;

/**
 *
 * @author S2028398
 */
public class SchoolHelper {

    public static void addSchool(SchoolRepository schoolRepository){
         School school = new School();
         school.setCreatedBy("Test");
         school.setCreatedDate(new Date());
         school.setName("Java Tech School");
         school.setRegistrationNumber("Sch72779");
         
         ContactDetails contactD = new ContactDetails();
         contactD.setCreatedBy("Test");
         contactD.setCreatedDate(new Date());
         contactD.setCellphoneNumber("082 557 8235");
         contactD.setTelephoneNumber("011 5744 553");
         contactD.setEmailAddress("javat@gmail.com");
         
         school.setContactDetail(contactD);
         
        Address addressress = new Address();
        addressress.setCreatedBy("Test");
        addressress.setCreatedDate(new Date());
        addressress.setAddressType(AddressType.RESIDENTIAL);
        addressress.setAddressLine1("Java Tech School");
        addressress.setAddressLine2("Block J");
        addressress.setStreet("4023 Street");
        addressress.setArea("Thohoyandou");
        addressress.setCode("0950");
        
        Address addresspos = new Address();
        addresspos.setCreatedBy("Test");
        addresspos.setCreatedDate(new Date());
        addresspos.setAddressType(AddressType.POSTAL);
        addresspos.setAddressLine2("P.O BOX 447 ");
        addresspos.setArea("Thohoyandou");
        addresspos.setCode("0950");
         
        school.addAddress(addressress);
        school.addAddress(addresspos);
        
        schoolRepository.save(school);
     }   
}
