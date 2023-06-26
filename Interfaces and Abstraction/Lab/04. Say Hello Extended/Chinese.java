package sayHello;

public class Chinese extends BasePerson {


    private String name;

    protected Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello(){
        return "Djydjybydjy";
    }
}
