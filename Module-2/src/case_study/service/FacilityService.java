package case_study.service;

import case_study.models.facility.Facility;

public interface FacilityService extends Service{
    void addFacility(Facility facility);
    Facility getFacility(int id);
    void displayFacility();
    void setFacility(int id, Facility facility);
    int sizeFacility();
    void displayListFacilityMain();
}
