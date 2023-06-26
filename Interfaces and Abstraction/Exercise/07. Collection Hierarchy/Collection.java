package Collection;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {

    protected int maxSize;
    protected List<String> items;

    public Collection() {
        this.items = new ArrayList<>();
        this.maxSize = 100;
    }
}
