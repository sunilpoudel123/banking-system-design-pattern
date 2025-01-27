package edu.mum.cs.cs525.labs.exercises.project.business.ccard.interest;

import edu.mum.cs.cs525.labs.exercises.project.business.framework.InterestStrategy;

import static edu.mum.cs.cs525.labs.exercises.project.business.ccard.ApplicationConfiguration.SILVER_CARD;

public class SilverCardInterest implements InterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        return balance * SILVER_CARD.getMonthlyInterestRate();
    }
}
