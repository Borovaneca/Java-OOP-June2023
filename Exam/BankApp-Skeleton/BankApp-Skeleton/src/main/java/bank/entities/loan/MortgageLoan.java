package bank.entities.loan;

public class MortgageLoan extends BaseLoan {
    private static final int INITIAL_INTEREST_RATE = 3;
    private static final double INITIAL_AMOUNT = 50000;

    public MortgageLoan() {
        super(INITIAL_INTEREST_RATE, INITIAL_AMOUNT);
    }
}
