package bank;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.*;

public class BankTests {

    private Bank expected;

    @Before
    public void createBeans() {
        this.expected = new Bank("Bank", 3);
    }

    @Test
    public void testConstructor() {
        assertEquals("Bank", this.expected.getName());
        assertEquals(3, this.expected.getCapacity());
        assertEquals(0, this.expected.getCount());
    }

    @Test
    public void testSetName() {
        assertEquals("Bank", this.expected.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrow() {
        Bank bank = new Bank(null, 2);
    }

    @Test
    public void testThrowMessageSetName() {
        String expected = "Invalid name!";
        String actual = null;

        try {
            Bank bank = new Bank(null, 3);
        } catch (NullPointerException e) {
            actual = e.getMessage();
        }
        assertEquals(expected, actual);
    }

    @Test
    public void testGetCapacity() {
        assertEquals(3, this.expected.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacity() {
        Bank bank = new Bank("Gencho", -1);
    }

    @Test
    public void testSetCapacityMessage() {
        String expected = "Invalid capacity!";
        String actual = null;
        try {
            Bank bank = new Bank("Pesho", -1);
        } catch (IllegalArgumentException e) {
            actual = e.getMessage();
        }

        assertEquals(expected, actual);
    }

    @Test
    public void testGetCount() {
        Client client = new Client("Ivan");
        this.expected.addClient(client);
        assertEquals(1, this.expected.getCount());
    }

    @Test
    public void testGetCount0() {
        assertEquals(0, this.expected.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddClientShouldThrow() {
        Client client = new Client("Ivan");
        Client client2 = new Client("Ivancho");
        Client client3 = new Client("Ivanov");
        Client client4 = new Client("Spas");
        this.expected.addClient(client);
        this.expected.addClient(client2);
        this.expected.addClient(client3);
        this.expected.addClient(client4);
    }

    @Test
    public void testAddClientThrowMessage() {
        String expected = "The bank has no capacity for more clients!";
        String actual = null;
        try {
            Client client = new Client("Ivan");
            Client client2 = new Client("Ivancho");
            Client client3 = new Client("Ivanov");
            Client client4 = new Client("Spas");
            this.expected.addClient(client);
            this.expected.addClient(client2);
            this.expected.addClient(client3);
            this.expected.addClient(client4);
        } catch (IllegalArgumentException e) {
            actual = e.getMessage();
        }

        assertEquals(expected,actual);
    }

    @Test
    public void testRemoveClient() {
        Client client = new Client("Ivan");
        Client client2 = new Client("Ivancho");
        this.expected.addClient(client);
        this.expected.addClient(client2);
        assertEquals(2, this.expected.getCount());
        this.expected.removeClient("Ivancho");
        assertEquals(1, this.expected.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveClientShouldThrow() {
        Client client = new Client("Ivan");
        Client client2 = new Client("Ivancho");
        this.expected.addClient(client);
        this.expected.addClient(client2);
        this.expected.removeClient("Genadi");
    }

    @Test
    public void testRemoveClientMessageThrow() {
        Client client = new Client("Ivan");
        this.expected.addClient(client);

        String expected = String.format("Client named %s does not exist!", "Spas");
        String actual = null;
        try {
            this.expected.removeClient("Spas");
        } catch (IllegalArgumentException e) {
            actual = e.getMessage();
        }
        assertEquals(expected,actual);
    }

    @Test
    public void testLoanWithdrawShouldBeTrue() {
        Client client = new Client("Ivan");
        this.expected.addClient(client);
        this.expected.loanWithdrawal("Ivan");
        assertFalse(client.isApprovedForLoan());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLoanWithdrawShouldThrow() {
        Client client = new Client("Ivan");
        this.expected.addClient(client);
        this.expected.loanWithdrawal("Spas");
    }

    @Test
    public void testLoanWithdrawMessageShouldThrow() {
        Client client = new Client("Ivan");
        this.expected.addClient(client);
        String expected = String.format("Client named %s does not exist!", "Spas");
        String actual = null;
        try {
            this.expected.loanWithdrawal("Spas");
        } catch (IllegalArgumentException e) {
            actual = e.getMessage();
        }
        assertEquals(expected,actual);
    }

    @Test
    public void testStatistics() {
        Client client = new Client("Ivan");
        Client client2 = new Client("Ivancho");
        Client client3 = new Client("Ivanov");
        this.expected.addClient(client);
        this.expected.addClient(client2);
        this.expected.addClient(client3);
        String expected = String.format("The client %s is at the %s bank!", String.join(", ", List.of(client.getName(), client2.getName(), client3.getName())), "Bank");
        String actual = this.expected.statistics();
        assertEquals(expected, actual);
    }
}
