package bank.entities.bank;

import bank.entities.client.Client;
import bank.entities.loan.Loan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static bank.common.ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CLIENT;
import static bank.common.ExceptionMessages.BANK_NAME_CANNOT_BE_NULL_OR_EMPTY;

public abstract class BaseBank implements Bank {

    private String name;
    private int capacity;
    private Collection<Loan> loans;
    private Collection<Client> clients;

    public BaseBank(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.loans = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(BANK_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Client> getClients() {
        return this.clients;
    }

    @Override
    public Collection<Loan> getLoans() {
        return this.loans;
    }

    @Override
    public void addClient(Client client) {
        if (this.capacity == this.clients.size()) {
            throw new IllegalArgumentException("No enough capacity for this client.");
        } else {
            this.clients.add(client);
        }
    }

    @Override
    public void removeClient(Client client) {
        this.clients.remove(client);
    }

    @Override
    public void addLoan(Loan loan) {
        this.loans.add(loan);
    }

    @Override
    public int sumOfInterestRates() {
        return this.loans.stream().mapToInt(Loan::getInterestRate).sum();
    }

    @Override
    public String getStatistics() {

        return String.format("Name: %s, Type: %s", this.name, this.getClass().getSimpleName()) + System.lineSeparator() +
                "Clients: " +
                (this.clients.isEmpty() ? "none" : String.join(", ", this.clients.stream().map(Client::getName).collect(Collectors.toList()))) +
                System.lineSeparator() +
                String.format("Loans: %d, Sum of interest rates: %d", this.loans.size(), this.loans.stream().mapToInt(Loan::getInterestRate).sum());
    }
}
