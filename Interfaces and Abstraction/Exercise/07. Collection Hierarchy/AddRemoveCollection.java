package Collection;

public class AddRemoveCollection extends Collection implements AddRemovable {

    public AddRemoveCollection() {
        super();
    }


    @Override
    public String remove() {
        return items.remove(items.size() - 1);
    }

    @Override
    public int add(String item) {
        items.add(0, item);
        return 0;
    }
}
