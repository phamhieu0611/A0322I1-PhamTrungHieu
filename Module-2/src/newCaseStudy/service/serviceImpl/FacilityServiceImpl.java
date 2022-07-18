package newCaseStudy.service.serviceImpl;

import newCaseStudy.model.facility.Facility;
import newCaseStudy.reponsitory.FacilityReponsitory;
import newCaseStudy.reponsitory.reponsitoryImpl.FacilityReponsitoryImpl;
import newCaseStudy.service.FacilityService;

public class FacilityServiceImpl implements FacilityService {
    private FacilityReponsitory facilityReponsitory = new FacilityReponsitoryImpl();

    @Override
    public void addFacility(Facility facility) {
        facilityReponsitory.addFacility(facility);
    }

    @Override
    public Facility getFacility(int id) {
        return this.facilityReponsitory.getFacility(id);
    }

    @Override
    public void displayFacility() {
        this.facilityReponsitory.displayFacility();
    }

    @Override
    public void setFacility(int id, Facility facility) {
        this.facilityReponsitory.setFacility(id, facility);
    }

    @Override
    public int sizeFacility() {
        return this.facilityReponsitory.sizeFacility();
    }

    @Override
    public void displayListFacilityMain() {
        this.facilityReponsitory.displayListFacilityMain();
    }
}
