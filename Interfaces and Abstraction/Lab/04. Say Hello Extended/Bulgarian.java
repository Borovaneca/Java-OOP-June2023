package sayHello;

public class Bulgarian extends BasePerson{

    private String name;

    protected Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
