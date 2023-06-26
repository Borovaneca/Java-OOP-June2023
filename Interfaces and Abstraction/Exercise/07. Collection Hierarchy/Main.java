package Collection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        String[] inputData = scanner.nextLine().split(" ");
        printIndexes(addCollection, inputData);
        printIndexes(addRemoveCollection, inputData);
        printIndexes(myList, inputData);

        int itemsToRemove = Integer.parseInt(scanner.nextLine());
        printRemove(addRemoveCollection, itemsToRemove);
        printRemove(myList, itemsToRemove);
    }

    private static void printRemove(AddRemovable collection, int rotation) {
        for (int i = 0; i < rotation; i++) {
            System.out.print(collection.remove() + " ");
        }
        System.out.println();
    }

    private static void printIndexes(Addable addCollection, String[] inputData) {
        for (String item : inputData) {
            System.out.print(addCollection.add(item) + " ");
        }
        System.out.println();
    }
}
