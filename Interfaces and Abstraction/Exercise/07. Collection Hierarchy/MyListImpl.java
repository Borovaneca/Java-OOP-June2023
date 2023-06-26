package Collection;

public class MyListImpl extends Collection implements MyList {

    public MyListImpl() {
        super();
    }

    @Override
    public String remove() {
        return items.remove(0);
    }

    @Override
    public int add(String item) {
        items.add(0, item);
        return 0;
    }

    @Override
    public int getUsed() {
        return items.size();
    }
}
