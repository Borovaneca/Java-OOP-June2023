package Inheritance.Lab.SingleInheritance;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList<Object> {

    public Object getRandomElement() {
        Random random = new Random();
        return super.remove(random.nextInt(size()));
    }
}
