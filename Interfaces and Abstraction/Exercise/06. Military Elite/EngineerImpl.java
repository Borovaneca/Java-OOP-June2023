package MilitaryElite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {

    List<RepairImpl> repairsList;

    public EngineerImpl(int id, String firstName, String lastName, double salary, String corp) {

        super(id, firstName, lastName, salary, corp);
        this.repairsList = new ArrayList<>();
    }

    @Override
    public void addRepair(RepairImpl repair) {

        repairsList.add(repair);
    }

    @Override
    public Collection<RepairImpl> getRepairs() {

        return Collections.unmodifiableList(repairsList);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Name: %s %s Id: %d Salary: %.2f", this.getFirstName(), this.getLastName(), this.getId(), this.getSalary()))
                .append(System.lineSeparator())
                .append("Corps: ")
                .append(corp)
                .append(System.lineSeparator())
                .append("Repairs:")
                .append(System.lineSeparator());


        for (RepairImpl repair : repairsList) {
            sb.append(" ")
                    .append(repair.toString())
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
