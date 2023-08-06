package bank;

public class Client {
    private String name;
    private boolean approvedForLoan;

    public Client(String name){
        this.setName(name);
        this.setApprovedForLoan(true);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public boolean isApprovedForLoan() {
        return approvedForLoan;
    }

    public void setApprovedForLoan(boolean approvedForCredit) {
        this.approvedForLoan = approvedForCredit;
    }
}
