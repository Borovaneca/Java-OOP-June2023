package bank.entities.bank;

public class BranchBank extends BaseBank {

    private static final int INITIAL_CAPACITY = 25;

    public BranchBank(String name) {
        super(name, INITIAL_CAPACITY);
    }
}
