package insurance_management.account;

import insurance_management.model.User;
import insurance_management.model.insurance.Insurance;

public class Enterprise extends Account {
    private static final double PROFIT_MARGIN = 0.10;

    public Enterprise(User user) {
        super(user);
    }

    @Override
    public void addInsurance(Insurance insurance) {
        double finalPrice = insurance.calculate() * (1 + PROFIT_MARGIN);
        insurance.setPrice(finalPrice);
        getInsurances().add(insurance);
    }

}
