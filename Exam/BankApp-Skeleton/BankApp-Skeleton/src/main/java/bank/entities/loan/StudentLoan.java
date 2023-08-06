package bank.entities.loan;

public class StudentLoan extends BaseLoan {

    private static final int INITIAL_INTEREST_RATE = 1;
    private static final double INITIAL_AMOUNT = 10000;

    public StudentLoan() {
        super(INITIAL_INTEREST_RATE, INITIAL_AMOUNT);
    }
}
