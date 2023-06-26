package MilitaryElite;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {

    Corp corp;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, String corp) {

        super(id, firstName, lastName, salary);
        setCorp(corp);
    }

    private void setCorp(String corp) {

        if (!corp.equals("Airforces") && !corp.equals("Marines")) {
            throw new IllegalArgumentException("Invalid corp!");
        }

        this.corp = Corp.valueOf(corp);
    }

    @Override
    public Corp getCrop() {

        return corp;
    }
}
