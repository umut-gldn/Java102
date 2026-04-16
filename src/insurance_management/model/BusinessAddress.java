package insurance_management.model;

public class BusinessAddress implements Address {
    private String city;
    private String district;
    private String street;
    private String companyName;

    public BusinessAddress(String city, String district, String street, String companyName) {
        this.city = city;
        this.district = district;
        this.street = street;
        this.companyName = companyName;

    }

    @Override
    public String getFullAddress() {
        return companyName + " - " + street + " " + district + "/" + city + " (İş)";

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
