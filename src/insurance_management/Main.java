package insurance_management;

import java.util.Date;
import java.util.Scanner;

import insurance_management.account.Account;
import insurance_management.account.Enterprise;
import insurance_management.account.Individual;
import insurance_management.manager.AccountManager;
import insurance_management.model.BusinessAddress;
import insurance_management.model.HomeAddress;
import insurance_management.model.User;
import insurance_management.model.insurance.CarInsurance;
import insurance_management.model.insurance.HealthInsurance;

public class Main {
    public static void main(String[] args) {

        User user1 = new User("Ahmet", "Yılmaz", "ahmet@gmail.com", "1234", "Mühendis", 30);
        User user2 = new User("Ayşe", "Kaya", "ayse@gmail.com", "5678", "Avukat", 45);

        // hesaplar oluştur
        Individual individual = new Individual(user1);
        Enterprise enterprise = new Enterprise(user2);

        // adres ekle
        individual.addAddress(new HomeAddress("İstanbul", "Kadıköy", "Moda Caddesi", 10));
        enterprise.addAddress(new BusinessAddress("Ankara", "Çankaya", "Atatürk Bulvarı", "ABC Şirketi"));

        // sigorta ekle
        individual.addInsurance(new HealthInsurance("Özel Sağlık", 1000, new Date(), new Date(), 30));
        enterprise.addInsurance(new CarInsurance("Araç Sigortası", 2000, new Date(), new Date(), 5));

        // AccountManager'a ekle
        AccountManager accountManager = new AccountManager();
        accountManager.addAccount(individual);
        accountManager.addAccount(enterprise);

        // klavyeden giriş
        Scanner scanner = new Scanner(System.in);
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Şifre: ");
        String password = scanner.nextLine();

        Account account = accountManager.login(email, password);
        if (account != null) {
            System.out.println("\nGiriş başarılı!");
            account.showUserInfo();
        }
        scanner.close();
    }
}
