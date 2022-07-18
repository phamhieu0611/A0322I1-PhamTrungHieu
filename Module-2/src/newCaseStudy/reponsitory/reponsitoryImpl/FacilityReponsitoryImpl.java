package newCaseStudy.reponsitory.reponsitoryImpl;

import newCaseStudy.model.facility.Facility;
import newCaseStudy.model.facility.House;
import newCaseStudy.model.facility.Room;
import newCaseStudy.model.facility.Villa;
import newCaseStudy.reponsitory.FacilityReponsitory;

import java.util.LinkedHashMap;
import java.util.Map;

public class FacilityReponsitoryImpl implements FacilityReponsitory {
    private static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    public static Room room;
    public static House house;
    public static Villa villa;
    static {
        room = new Room("Rent room", "Month", 150.75, 22.5, 4, "Free wifi");
        house = new House("Rent House", "year", 225.50, 64.1, 7, "Gold", 2);
        villa = new Villa("Rent Vilaa", "Week", 775.50, 172.25, 14, "Diamond", 40.05, 4);
    }
    public FacilityReponsitoryImpl(Map<Facility, Integer> facilityIntegerMap){
        this.facilityIntegerMap = facilityIntegerMap;
    }
    public FacilityReponsitoryImpl(){
        this.facilityIntegerMap.put(room, 15);
        this.facilityIntegerMap.put(house, 9);
        this.facilityIntegerMap.put(villa, 7);
    }
    @Override
    public void addFacility(Facility facility) {
        if (facilityIntegerMap.get(facility) != null){
            int use = facilityIntegerMap.get(facility);
        }else {
            facilityIntegerMap.put(facility, 1);
        }
    }

    @Override
    public Facility getFacility(int index) {
        int id = 0;
        for (Facility key: facilityIntegerMap.keySet()){
            if (index == id){
                return key;
            }id++;
        }
        return null;
    }

    @Override
    public void displayFacility() {
        int id = 1;
        for (Facility key: facilityIntegerMap.keySet()){
            System.out.println("ID: "+(id++)+"\nFacility: "+key+"\nUsed: "+facilityIntegerMap.get(key));
        }
    }

    @Override
    public void setFacility(int index, Facility facility) {
        if (getFacility(index) == null){
            throw new NullPointerException();
        }if (facility instanceof Room){
            Facility roomEdit = getFacility(index);
            roomEdit = facility;
        }if (facility instanceof  House){
            Facility houseEdit = getFacility(index);
            houseEdit = facility;
        }if (facility instanceof  Villa){
            Facility villaEdit = getFacility(index);
            villaEdit = facility;
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
