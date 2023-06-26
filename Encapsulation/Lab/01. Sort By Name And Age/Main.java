package Encapsulation.Lab.SortByNameAndAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Person> persons = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] inputData = br.readLine().split("\\s+");
            String firstName = inputData[0];
            String lastName = inputData[1];
            int age = Integer.parseInt(inputData[2]);
            Person current = new Person(firstName, lastName, age);
            persons.add(current);
        }

        Collections.sort(persons, (firstPerson, secondPerson) -> {
            int sComp = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());
            if (sComp != 0) {
                return sComp;
            } else {
                return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
            }
        });

        persons.forEach(System.out::print);
    }
}
