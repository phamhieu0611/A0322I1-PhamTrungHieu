package case_sudy.repository;

import case_sudy.models.Facility;

public interface FacilityRepository{
    void addFacility(Facility facility);
    Facility getFacility(int id);
    void displayFacility();
    void setFacility(int id, Facility facility);
    int sizeFacility();
    void displayListFacilityMain();

}
