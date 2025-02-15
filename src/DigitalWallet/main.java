package DigitalWallet;


import java.util.Date;
import java.util.List;

enum CurrencyType {
    INR,GBR,DOLLAR
}

class User {
    String id;
    String name;
    String email;
    String password;
    List<Account> accountList;

    void addAccount(String user_id, Account account)  {
    }
    void deleteAccount(String user_id, Account account) {

    }
    void updatePersonalInfo() {

    }
}

class Account {
    String accountId;
    String accountName;
    User user;
    Long accountNumber;
    Double balance;
    CurrencyType currencyType;
    List<Transaction> tranactionList;

    void deposit(String accountId,Double amount) {

    }
    void withDraw(String accountId,Double amount) {
        
    }

}

class Transaction {
    String id;
    Account account;
    Account sourceAccount;
    Account destAccount;
    Long amount;
    CurrencyType currencyType;
    Date createdAt;
}


abstract class PaymentType {
    String id;
    User user;
    String details;

}
class CreditCard extends PaymentType {
    String cardNumber;
    Date expiryDate;
    Integer cvv;
}

class BankAccount extends PaymentType {
    String accountId;
    String accountName;
    String bankName;
    Long accountNumber;
}


public class main {
}
