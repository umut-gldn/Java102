package insurance_management.model.insurance;

import java.util.Date;

public class TravelInsurance extends Insurance {
    private String destination;

    public TravelInsurance(String name, double price, Date startDate, Date endDate, String destination) {
        super(name, price, startDate, endDate);
        this.destination = destination;
    }

    @Override
    public double calculate() {
        if (destination.equalsIgnoreCase("yurtdışı")) {
            return getPrice() * 2;
        }
        return getPrice();
    }

}
