package SplitWise;

import java.util.Date;
import java.util.List;

//Create and Manage Account
//Create groups and add members into it
//Add expense in group
class User {
    int userId;
    String userName;
    String email;
    String password;
    void createUser() {

    }
    void updateUser() {

    }
    void deleteUser() {

    }
}

class Account {
    int accountId;
    User user;
    int balance;
    Date createdDate;
    List<Split> splitList;
    void createAccount() {

    }
    void updateAccount() {

    }
    void deleteAccount() {

    }
    void depositMoney() {

    }
    void settleUp() {

    }
}

class Group {
    int groupId;
    String groupName;
    String description;
    List<Account> accountList;
    List<Expense> expenseList;
    void createGroup() {

    }
    void updateGroup() {

    }
    void deleteGroup() {

    }
    void addAccount() {

    }
}
class Expense {
    int expenseId;
    double amount;
    Account payedBy;
    List<Split> splitList;

    void equalSplit() {

    }
    void percentageSplit() {

    }
}

class Split {
    int splitId;
    Account owedBy;
    Account owedTo;
    Double amount;
    Double percentage;
}

interface SplitStrategy {
    void split(Double amount,List<Split>splitList);
}

class EqualSplit implements SplitStrategy {

    @Override
    public void split(Double amount, List<Split> splitList) {

    }
}

class PercentageSplit implements SplitStrategy {
    @Override
    public void split(Double amount, List<Split> splitList) {

    }
}

class ExactSplit implements SplitStrategy {
    @Override
    public void split(Double amount, List<Split> splitList) {

    }
}


public class main {
    public static void main(String []args) {

    }
}
