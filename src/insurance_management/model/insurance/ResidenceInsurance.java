package insurance_management.model.insurance;

import java.util.Date;

public class ResidenceInsurance extends Insurance {
    private double squareMeters;

    public ResidenceInsurance(String name, double price,Date startDate,Date endDate, double squareMeters) {
        super(name, price, startDate, endDate);
        this.squareMeters = squareMeters;
    }

    @Override
    public double calculate() {
        return getPrice() * (1 + squareMeters * 0.001);
    }

}
