package MilitaryElite;

public class MissionImpl implements Mission {

    private String missionCodeName;
    private State state;

    public MissionImpl(String missionCodeName, String missionState) {

        this.missionCodeName = missionCodeName;
        parseState(missionState);
    }

    @Override
    public String getMissionCodeName() {

        return missionCodeName;
    }

    @Override
    public State getState() {

        return state;
    }


    private void parseState(String state) {

        if (!state.equals("inProgress") && !state.equals("finished")) {
            throw new IllegalArgumentException("Invalid mission state!");
        }

        this.state = State.valueOf(state);
    }

    @Override
    public String toString() {

        return String.format("Code Name: %s State: %s", missionCodeName, state.toString());
    }
}
