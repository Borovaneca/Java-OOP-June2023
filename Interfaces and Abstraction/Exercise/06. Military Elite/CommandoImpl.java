package MilitaryElite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {

    private List<MissionImpl> missionsList;

    public CommandoImpl(int id, String firstName, String lastName, double salary, String corp) {

        super(id, firstName, lastName, salary, corp);
        this.missionsList = new ArrayList<>();
    }

    @Override
    public void addMission(MissionImpl mission) {

        missionsList.add(mission);
    }

    @Override
    public Collection<MissionImpl> getMission() {

        return Collections.unmodifiableList(missionsList);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Name: %s %s Id: %d Salary: %.2f", this.getFirstName(), this.getLastName(), this.getId(), this.getSalary()))
                .append(System.lineSeparator())
                .append("Corps: ")
                .append(corp)
                .append(System.lineSeparator())
                .append("Missions:")
                .append(System.lineSeparator());

        for (MissionImpl mission : missionsList) {
            sb.append(" ")
                    .append(mission.toString())
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
