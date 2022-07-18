package newCaseStudy.reponsitory;

import newCaseStudy.model.facility.Facility;

public interface FacilityReponsitory {
    void addFacility(Facility facility);
    Facility getFacility(int index);
    void displayFacility();
    void setFacility(int index, Facility facility);
    int sizeFacility();
    void displayListFacilityMain();
}
