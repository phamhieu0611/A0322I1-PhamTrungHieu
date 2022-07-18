package newCaseStudy.service;


import newCaseStudy.model.facility.Facility;

public interface FacilityService extends Service{
    void addFacility(Facility facility);
    Facility getFacility(int id);
    void displayFacility();
    void setFacility(int id, Facility facility);
    int sizeFacility();
    void displayListFacilityMain();
}
