package insurance_management.manager;

import insurance_management.model.Address;
import insurance_management.model.User;

public class AddressManager {

    public static void addAddress(User user, Address address) {
        user.getAddresses().add(address);
    }

    public static void removeAddress(User user, Address address) {
        user.getAddresses().remove(address);
    }

}
