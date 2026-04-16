package insurance_management.account;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import insurance_management.enums.AuthenticationStatus;
import insurance_management.exception.InvalidAuthenticationException;
import insurance_management.manager.AddressManager;
import insurance_management.model.Address;
import insurance_management.model.User;
import insurance_management.model.insurance.Insurance;

public abstract class Account implements Comparable<Account> {
    private User user;
    private ArrayList<Insurance> insurance;
    private AuthenticationStatus authenticationStatus;

    public Account(User user) {
        this.user = user;
        this.authenticationStatus = AuthenticationStatus.FAIL;
        this.insurance = new ArrayList<>();
    }

    public void login(String email, String password) throws InvalidAuthenticationException {
        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
            this.authenticationStatus = AuthenticationStatus.SUCCESS;
            user.setLastLoginDate(new Date());
        } else {
            throw new InvalidAuthenticationException("Invalid email or password");
        }
    }

    public final void showUserInfo() {
        System.out.println("Ad       : " + user.getFirstName());
        System.out.println("Soyad    : " + user.getLastName());
        System.out.println("Email    : " + user.getEmail());
        System.out.println("Meslek   : " + user.getOccupation());
        System.out.println("Yaş      : " + user.getAge());
        System.out.println("Son Giriş: " + user.getLastLoginDate());
        System.out.println("Adresler :");
        for (Address a : user.getAddresses()) {
            System.out.println("  - " + a.getFullAddress());
        }
        System.out.println("Sigortalar:");
        for (Insurance i : insurance) {
            System.out.println("  - " + i);
        }
    }

    public void addAddress(Address address) {
        AddressManager.addAddress(user, address);
    }

    public void removeAddress(Address address) {
        AddressManager.removeAddress(user, address);
    }

    public abstract void addInsurance(Insurance insurance);

    public AuthenticationStatus getAuthenticationStatus() {
        return authenticationStatus;
    }

    public User getUser() {
        return user;
    }

    public ArrayList<Insurance> getInsurances() {
        return insurance;
    }

    @Override
    public int compareTo(Account other) {
        return this.user.getEmail().compareTo(other.user.getEmail());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Account other = (Account) obj;
        return Objects.equals(user.getEmail(), other.user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(user.getEmail());
    }
}
