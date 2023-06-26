package Collection;

public class AddCollection extends Collection implements Addable {

    public AddCollection() {
        super();
    }

    @Override
    public int add(String string) {
        items.add(string);
        return items.indexOf(string);
    }
}
