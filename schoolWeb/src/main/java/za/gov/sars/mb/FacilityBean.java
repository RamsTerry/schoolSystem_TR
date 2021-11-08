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
import za.gov.sars.domain.Facility;
import za.gov.sars.domain.School;
import za.gov.sars.service.FacilityServiceLocal;
import za.gov.sars.service.SchoolServiceLocal;

/**
 *
 * @author S2028398
 */
@ManagedBean
@ViewScoped
public class FacilityBean extends BaseBean {

    @Autowired
    private FacilityServiceLocal facilityService;
    @Autowired
    private SchoolServiceLocal schoolService;

    private List<Facility> facilities = new ArrayList<>();

    private Facility facility;

    @PostConstruct
    public void init() {
        this.resetView(false).setList(true);
        facilities = facilityService.listAll();
    }

    public void addOrUpdate(Facility fc) {
        this.resetView(false).setAdd(true);
        if (fc != null) {
            fc.setUpdatedBy(getActiveUser().getIdentifier());
            fc.setUpdatedDate(new Date());
            facility = fc;
        } else {
            facility = new Facility();
            facility.setCreatedBy(getActiveUser().getIdentifier());
            facility.setCreatedDate(new Date());

            facilities.add(0, facility);
        }
    }

    public void save(Facility fc) {
        if (fc.getId() != null) {
            facilityService.update(fc);
        } else {
            facilityService.save(fc);
        }
        this.resetView(false).setList(true);
    }

    public void delete(Facility fc) {

        facilityService.deleteById(fc.getId());
        synchronize(fc);
        this.resetView(false).setList(true);
    }

    public void synchronize(Facility fc) {
        Iterator<Facility> facilityList = facilities.iterator();
        while (facilityList.hasNext()) {
            if (facilityList.next().getId().equals(fc.getId())) {
                facilityList.remove();
            }
        }
    }

    public void cancel(Facility fc) {
        if (fc.getId() == null) {
            if (facilities.contains(fc)) {

                facilities.remove(fc);
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

    public SchoolServiceLocal getSchoolService() {
        return schoolService;
    }

    public void setSchoolService(SchoolServiceLocal schoolService) {
        this.schoolService = schoolService;
    }

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }
}
