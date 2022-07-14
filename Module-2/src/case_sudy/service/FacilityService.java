package case_sudy.service;

import case_sudy.models.Facility;

public interface FacilityService extends Service{
    void addFacility(Facility facility);
    Facility getFacility(int id);
    void displayFacility();
    void setFacility(int id, Facility facility);
    int sizeFacility();
    void displayListFacilityMain();
}
