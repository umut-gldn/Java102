package insurance_management.manager;

import java.util.TreeSet;

import insurance_management.account.Account;
import insurance_management.exception.InvalidAuthenticationException;

public class AccountManager {

    private TreeSet<Account> accounts = new TreeSet<>();

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account login(String email, String password) {
        for (Account account : accounts) {
            if (account.getUser().getEmail().equals(email)) {
                try {
                    account.login(email, password);
                    return account;
                } catch (InvalidAuthenticationException e) {
                    System.out.println("Giriş başarısız: " + e.getMessage());
                    return null;
                }
            }
        }
        System.out.println("Bu maile ait hesap bulunamadı");
        return null;
    }

    public TreeSet<Account> getAccounts() {
        return accounts;
    }

}
