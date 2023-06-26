package Inheritance.Lab.StackOfStrings;
import java.util.ArrayList;

public class StackOfStrings {

    private ArrayList<String> data;


    StackOfStrings() {
        this.data = new ArrayList<>();
    }
    public void push(String item) {
        data.add(item);
    }

    public String pop() {
       return data.remove(data.size() - 1);
    }

    public String peek() {
        return data.get(data.size() - 1);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}
