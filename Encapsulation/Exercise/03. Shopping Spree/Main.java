
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] peopleInfo = scanner.nextLine().split(";");
        Map<String, Person> peopleMap = new LinkedHashMap<>();

        for (String personString : peopleInfo) {
            String[] personData = personString.split("=");
            String name = personData[0];
            double money = Double.parseDouble(personData[1]);
            try {
                Person person = new Person(name, money);
                peopleMap.put(name, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String[] productsInfo = scanner.nextLine().split(";");
        Map<String, Product> productsMap = new LinkedHashMap<>();

        for (String productString : productsInfo) {
            String[] productData = productString.split("=");
            String name = productData[0];
            double cost = Double.parseDouble(productData[1]);
            try {
                Product product = new Product(name, cost);
                productsMap.put(name, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        System.out.println();
        String input;

        while (!(input = scanner.nextLine()).equals("END")) {
            String personName = input.split("\\s+")[0];
            String productName = input.split("\\s+")[1];

            Person buyer = peopleMap.get(personName);
            Product product = productsMap.get(productName);

            try {
                buyer.buyProduct(product);
                System.out.printf("%s bought %s\n", personName, productName);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        peopleMap.values().forEach(System.out::println);
    }
}