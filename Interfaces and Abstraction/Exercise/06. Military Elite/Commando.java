package MilitaryElite;

import java.util.Collection;

public interface Commando extends SpecialisedSoldier {

    Collection<MissionImpl> getMission();

    void addMission(MissionImpl mission);
}
