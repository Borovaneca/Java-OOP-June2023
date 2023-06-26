package Encapsulation.Exercise.AnimalFarm;

public class Chicken {

    private String name;

    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalStateException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalStateException("Age should be between 0 and 15");
        }
        this.age = age;
    }

    private double productPerDay() {
        if (age < 6) {
            return 2.00;
        } else if (age < 12) {
            return 1.00;
        } else {
            return 0.75;
        }
    }

    public double calculateProductPerDay() {
        return productPerDay();
    }


    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", this.name, this.age, productPerDay());
    }
}
