package insurance_management.model;

public class HomeAddress implements Address {

    private String city;
    private String district;
    private String street;
    private int doorNumber;

    public HomeAddress(String city, String district, String street, int doorNumber) {
        this.city = city;
        this.district = district;
        this.street = street;
        this.doorNumber = doorNumber;

    }

    @Override
    public String getFullAddress() {
        return street + " No:" + doorNumber + " " + district + "/" + city + " (Ev)";
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getDistrict() {

        return district;
    }

}
