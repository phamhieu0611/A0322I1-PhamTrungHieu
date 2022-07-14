package case_sudy.repository;

import case_sudy.models.Facility;
import case_sudy.models.House;
import case_sudy.models.Room;
import case_sudy.models.Villa;

import java.util.LinkedHashMap;
import java.util.Map;

public class FacilityRepositoryImpl implements FacilityRepository{
    private Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    public static Room room;
    public static Villa villa;
    public static House house;
    static {
        room = new Room("NameService", "month", 15, 4, 50, 15, "Free Wifi");
        villa = new Villa("nameService", "month", 105, 12, 350, "Diamond", 75, 5, 150);
        house = new House("nameService", "month", 62, 7, 150, "Gold", 75, 3);
    }
    public FacilityRepositoryImpl(Map<Facility, Integer> facilityMap) {
        this.facilityIntegerMap = facilityMap;
    }
    public FacilityRepositoryImpl(){
        this.facilityIntegerMap.put(room, 10);
        this.facilityIntegerMap.put(villa, 10);
        this.facilityIntegerMap.put(house, 10);
    }
    @Override
    public void addFacility(Facility facility) {
        if (facilityIntegerMap.get(facility) != null){
            int use = facilityIntegerMap.get(facility);
            facilityIntegerMap.put(facility, (use+1));
        }else {
            facilityIntegerMap.put(facility, 1);
        }
    }

    @Override
    public Facility getFacility(int index) {
        int id = 0;
        for (Facility key: facilityIntegerMap.keySet()){
            if (index == id) {
                return key;
            }id++;
        }
        return null;
    }

    @Override
    public void displayFacility() {
        int id = 0;
        for (Facility key : facilityIntegerMap.keySet()){
            System.out.println("Id: "+(id++)+" Facility: "+key+" USED: "+facilityIntegerMap.get(key));
        }
    }

    @Override
    public void setFacility(int index, Facility facility) {
        if (getFacility(index) == null){
            throw new NullPointerException();
        }if (facility instanceof Room){
            Facility roomEdit = getFacility(index);
            roomEdit = facility;
        }if (facility instanceof Villa){
            Facility villaEdit = getFacility(index);
            villaEdit = facility;
        }if (facility instanceof House){
            Facility houseEdit = getFacility(index);
            houseEdit = facility;
        }
    }

    @Override
    public int sizeFacility() {
        return facilityIntegerMap.size();
    }

    @Override
    public void displayListFacilityMain() {
        boolean check = false;
        int id = 0;
        for (Facility key : facilityIntegerMap.keySet()){
            if (facilityIntegerMap.get(key) > 4){
                check = true;
                break;
            }
        }if (check){
            for (Facility key : facilityIntegerMap.keySet()) {
                if (facilityIntegerMap.get(key)>4) {
                    System.out.println("ID Facility: " + (id ++) + " Facility: " + key + " USED: " + facilityIntegerMap.get(key));
                }
            }
        }else {
            System.out.println("All facility are fine");
        }
    }
}
