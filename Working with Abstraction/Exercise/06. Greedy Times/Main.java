package WorkingWithAbstraction.Exercise.greedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long capacity = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(capacity);
        Item item;

        for (int i = 0; i < safe.length; i += 2) {
            String itemName = safe[i];
            long amount = Long.parseLong(safe[i + 1]);

            try {
                item = createItem(itemName, amount);
            } catch (IllegalArgumentException e) {
                continue;
            }
            bag.add(item);
        }
        System.out.println(bag);
    }

    private static Item createItem(String itemName, long amount) {
        ItemType itemType;
        if (itemName.length() == 3) {
            itemType = ItemType.CASH;
        } else if (itemName.length() >= 4 && itemName.toLowerCase().endsWith("gem")) {
            itemType = ItemType.GEM;
        } else if (itemName.equalsIgnoreCase("Gold")) {
            itemType = ItemType.GOLD;
        } else {
            throw new IllegalArgumentException("Not a valid type!");
        }

        return new Item(itemType, itemName, amount);
    }
}

