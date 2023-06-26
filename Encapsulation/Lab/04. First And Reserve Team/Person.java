
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    public void setFirstName(String firstName) {
        validateNameLength(firstName, "First");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        validateNameLength(lastName, "Last");
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    private void validateNameLength(String name, String messagePrefix) {
        if (name.length() < 3) {
            throw new IllegalArgumentException(String.format("%s name cannot be less than 3 symbols", messagePrefix));
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %.2f leva", firstName, lastName, salary);
    }
}
