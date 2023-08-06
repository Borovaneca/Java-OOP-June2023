package bank.entities.client;

public class Adult extends BaseClient {

    private static final int INITIAL_INTEREST = 4;

    public Adult(String name, String ID, double income) {
        super(name, ID, INITIAL_INTEREST, income);
    }

    @Override
    public void increase() {
        this.setIncome(this.getIncome() + 2);
    }
}
