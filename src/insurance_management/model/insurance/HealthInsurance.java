package insurance_management.model.insurance;

import java.util.Date;

public class HealthInsurance extends Insurance {
    private int age;

    public HealthInsurance(String name, double price, Date startDate, Date endDate, int age) {
        super(name, price, startDate, endDate);
        this.age = age;
    }

    @Override
    public double calculate() {
        return getPrice() * (1 + age * 0.01);
    }

}
