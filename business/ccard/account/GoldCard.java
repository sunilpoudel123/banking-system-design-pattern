package edu.mum.cs.cs525.labs.exercises.project.business.ccard.account;

import edu.mum.cs.cs525.labs.exercises.project.business.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.AccountOwnerType;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.InterestStrategy;

import static edu.mum.cs.cs525.labs.exercises.project.business.ccard.ApplicationConfiguration.BRONZE_CARD;
import static edu.mum.cs.cs525.labs.exercises.project.business.ccard.ApplicationConfiguration.GOLD_CARD;

public class GoldCard extends Account {
    String name,expDate,type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public GoldCard(String accountNumber, double balance, InterestStrategy interestStrategy, String email, AccountOwnerType accountOwnerType) {
        super(accountNumber, balance, interestStrategy, email, accountOwnerType);
    }

    @Override
    public String getAccountType() {
        return "Gold Credit Card";
    }

    @Override
    protected double calculateNewBalance() {
        return getPreviousBalance() - getTotalCredits() + getTotalCharges() + GOLD_CARD.getMonthlyInterestRate() * (getPreviousBalance() - getTotalCredits());

    }

    @Override
    protected double calculateTotalDue(double newBalance) {
        return GOLD_CARD.getMinimumPayment() * newBalance;
    }
}

