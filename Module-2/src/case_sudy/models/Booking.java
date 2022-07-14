package case_sudy.models;

public class Booking {
    private int idBooking;
    private String dayStart;
    private String dayEnd;
    private int deposit;
    private String idCustomer;
    private String nameService;
    private String typeService;

    public Booking(int idBooking, String dayStart, String dayEnd, int deposit, String idCustomer, String nameService, String typeService) {
        this.idBooking = idBooking;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.deposit = deposit;
        this.idCustomer = idCustomer;
        this.nameService = nameService;
        this.typeService = typeService;
    }

    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }

    public String getDayStart() {
        return dayStart;
    }

    public void setDayStart(String dayStart) {
        this.dayStart = dayStart;
    }

    public String getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(String dayEnd) {
        this.dayEnd = dayEnd;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idBooking=" + getIdBooking() +
                ", dayStart='" + getDayStart() + '\'' +
                ", dayEnd='" + getDayEnd() + '\'' +
                ", deposit=" + getDeposit() +
                ", idCustomer='" + getIdCustomer() + '\'' +
                ", nameService='" + getNameService() + '\'' +
                ", typeService='" + getTypeService() + '\'' +
                '}';
    }
}
