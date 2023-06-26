package Inheritance.Lab.StackOfStrings;

public class Main {
    public static void main(String[] args) {


        StackOfStrings sos = new StackOfStrings();
        sos.push("one");
        sos.push("tow");
        sos.push("three");

        System.out.println(sos.isEmpty());
        System.out.println(sos.peek());

        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
    }
}
