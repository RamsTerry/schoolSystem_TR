/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.service;

import java.util.Date;
import za.gov.sars.domain.Facility;
import za.gov.sars.persistance.FacilityRepository;
import za.gov.sars.persistance.SchoolRepository;

/**
 *
 * @author S2028398
 */
public class FacilityHelper {

    public static void addFacility(FacilityRepository facilityRepository, SchoolRepository schoolRepository) {

        Facility facility1 = new Facility();
        facility1.setCreatedBy("Test");
        facility1.setCreatedDate(new Date());
        facility1.setName("Staff Room");
        facility1.setLocation("Admin Block Section C");
        facility1.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        facilityRepository.save(facility1);

        Facility facility2 = new Facility();
        facility2.setCreatedBy("Test");
        facility2.setCreatedDate(new Date());
        facility2.setName("Class Room");
        facility2.setLocation("Class Block B");
        facility2.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        facilityRepository.save(facility2);

        Facility facility3 = new Facility();
        facility3.setCreatedBy("Test");
        facility3.setCreatedDate(new Date());
        facility3.setName("Class Room");
        facility3.setLocation("Class Block A");
        facility3.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        facilityRepository.save(facility3);

        Facility facility4 = new Facility();
        facility4.setCreatedBy("Test");
        facility4.setCreatedDate(new Date());
        facility4.setName("Conference Hall");
        facility4.setLocation("Class Block C");
        facility4.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        facilityRepository.save(facility4);

        Facility facility5 = new Facility();
        facility5.setCreatedBy("Test");
        facility5.setCreatedDate(new Date());
        facility5.setName("Class Room");
        facility5.setLocation("Class Block B");
        facility5.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        facilityRepository.save(facility5);

        Facility facility6 = new Facility();
        facility6.setCreatedBy("Test");
        facility6.setCreatedDate(new Date());
        facility6.setName("Strong Room");
        facility6.setLocation("Section B");
        facility6.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        facilityRepository.save(facility6);

        Facility facility7 = new Facility();
        facility7.setCreatedBy("Test");
        facility7.setCreatedDate(new Date());
        facility7.setName("Toilet");
        facility7.setLocation("Section O");
        facility7.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        facilityRepository.save(facility7);

        Facility facility8 = new Facility();
        facility8.setCreatedBy("Test");
        facility8.setCreatedDate(new Date());
        facility8.setName("Offices");
        facility8.setLocation("Block F");
        facility8.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        facilityRepository.save(facility8);
        
        Facility facility9 = new Facility();
        facility9.setCreatedBy("Test");
        facility9.setCreatedDate(new Date());
        facility9.setName("Strong Room");
        facility9.setLocation("Block S");
        facility9.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        facilityRepository.save(facility9);
        
        Facility facility10 = new Facility();
        facility10.setCreatedBy("Test");
        facility10.setCreatedDate(new Date());
        facility10.setName("Computer Room");
        facility10.setLocation("Section C");
        facility10.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        facilityRepository.save(facility10);
    }
}
