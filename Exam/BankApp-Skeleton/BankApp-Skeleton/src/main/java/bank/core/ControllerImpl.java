package bank.core;

import bank.entities.bank.Bank;
import bank.entities.bank.BranchBank;
import bank.entities.bank.CentralBank;
import bank.entities.client.Adult;
import bank.entities.client.Client;
import bank.entities.client.Student;
import bank.entities.loan.Loan;
import bank.entities.loan.MortgageLoan;
import bank.entities.loan.StudentLoan;
import bank.repositories.LoanRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static bank.common.ConstantMessages.*;
import static bank.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private LoanRepository loans;
    private Map<String, Bank> banks;

    public ControllerImpl() {
        this.loans = new LoanRepository();
        this.banks = new HashMap<>();
    }

    @Override
    public String addBank(String type, String name) {
        Bank bank = null;
        if (type.equals("BranchBank")) {
            bank = new BranchBank(name);
        } else if (type.equals("CentralBank")) {
            bank = new CentralBank(name);
        } else {
            throw new NullPointerException(INVALID_BANK_TYPE);
        }

        this.banks.put(name, bank);

        return String.format(SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String addLoan(String type) {
        Loan loan = null;
        if (type.equals("StudentLoan")) {
            loan = new StudentLoan();
        } else if (type.equals("MortgageLoan")) {
            loan = new MortgageLoan();
        } else {
            throw new IllegalArgumentException(INVALID_LOAN_TYPE);
        }
        this.loans.addLoan(loan);
        return String.format(SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String returnedLoan(String bankName, String loanType) {
        Loan first = this.loans.findFirst(loanType);
        if (first == null) {
            throw new IllegalArgumentException(String.format(NO_LOAN_FOUND, loanType));
        }

        Bank bank = this.banks.get(bankName);
        this.loans.removeLoan(first);
        bank.addLoan(first);
        return String.format(SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, loanType, bank.getName());
    }

    @Override
    public String addClient(String bankName, String clientType, String clientName, String clientID, double income) {
        Client client = null;
        if (clientType.equals("Student")) {
            client = new Student(clientName, clientID, income);
        } else if (clientType.equals("Adult")) {
            client = new Adult(clientName, clientID, income);
        } else {
            throw new IllegalArgumentException(INVALID_CLIENT_TYPE);
        }

        Bank bank = this.banks.get(bankName);
        boolean isUnsuitable = clientType.equals("Adult") && bank.getClass().getSimpleName().equals("BranchBank") ||
                clientType.equals("Student") && bank.getClass().getSimpleName().equals("CentralBank");

        if (isUnsuitable) {
        return UNSUITABLE_BANK;
        }
        bank.addClient(client);
        return String.format(SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, clientType, bankName);
    }

    @Override
    public String finalCalculation(String bankName) {
        Bank bank = this.banks.get(bankName);
        double clientsSum = bank.getClients().stream().mapToDouble(Client::getIncome).sum();
        double loansSum = bank.getLoans().stream().mapToDouble(Loan::getAmount).sum();
        double sum = clientsSum + loansSum;

        return String.format(FUNDS_BANK, bankName, sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        this.banks.values().forEach(b -> output.append(b.getStatistics()).append(System.lineSeparator()));
        return output.toString().trim();
    }
}
