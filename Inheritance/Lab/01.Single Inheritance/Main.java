package Inheritance.Lab.SingleInheritance;

public class Main {
    public static void main(String[] args) {


        RandomArrayList randomArrayList = new RandomArrayList();

        Dog dog = new Dog();
        dog.eat();
        dog.bark();
        randomArrayList.add(dog);

        Cat cat = new Cat();
        cat.eat();
        cat.meow();
        randomArrayList.add(cat);

        Dog dog2 = new Dog();
        dog2.eat();
        dog2.bark();
        randomArrayList.add(dog2);
        System.out.println(randomArrayList.getRandomElement());

    }
}
