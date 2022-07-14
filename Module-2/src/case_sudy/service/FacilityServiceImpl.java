package case_sudy.service;

import case_sudy.models.Facility;
import case_sudy.repository.FacilityRepository;
import case_sudy.repository.FacilityRepositoryImpl;


public class FacilityServiceImpl implements FacilityService{
    private FacilityRepository repository = new FacilityRepositoryImpl();

    @Override
    public void addFacility(Facility facility) {
        repository.addFacility(facility);
    }

    @Override
    public Facility getFacility(int id) {
        return this.repository.getFacility(id);
    }

    @Override
    public void displayFacility() {
        this.repository.displayFacility();
    }

    @Override
    public void setFacility(int id, Facility facility) {
        this.repository.setFacility(id, facility);
    }

    @Override
    public int sizeFacility() {
        return this.repository.sizeFacility();
    }

    @Override
    public void displayListFacilityMain() {
        this.repository.displayListFacilityMain();
    }
}
