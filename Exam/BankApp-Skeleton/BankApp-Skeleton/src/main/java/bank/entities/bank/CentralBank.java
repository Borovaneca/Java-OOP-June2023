package bank.entities.bank;

public class CentralBank extends BaseBank {

    private static final int INITIAL_CAPACITY = 50;

    public CentralBank(String name) {
        super(name, INITIAL_CAPACITY);
    }
}
