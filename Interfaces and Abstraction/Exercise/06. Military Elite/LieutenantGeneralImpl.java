package MilitaryElite;

import java.util.*;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {

    private List<Soldier> privatesList;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {

        super(id, firstName, lastName, salary);
        this.privatesList = new ArrayList<>();
    }

    public void addPrivate(Soldier soldier) {

        privatesList.add(soldier);
    }

    @Override
    public List<Soldier> getPrivates() {

        return Collections.unmodifiableList(privatesList);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        
        sb.append(String.format("Name: %s %s Id: %d Salary: %.2f", getFirstName(), getLastName(), getId(), getSalary()))
                .append(System.lineSeparator())
                .append("Privates:")
                .append(System.lineSeparator());

        for (Soldier soldier : privatesList) {
            sb.append(" ")
                    .append(soldier.toString())
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
