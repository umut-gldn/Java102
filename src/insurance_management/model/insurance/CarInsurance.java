package insurance_management.model.insurance;

import java.util.Date;
public class CarInsurance extends Insurance {
    private int carAge;

    public CarInsurance(String name, double price, Date startDate, Date endDate, int carAge) {
        super(name, price, startDate, endDate);
        this.carAge = carAge;
    }
    @Override
    public double calculate() {
        return getPrice() * (1 + carAge * 0.05);
    }

}
