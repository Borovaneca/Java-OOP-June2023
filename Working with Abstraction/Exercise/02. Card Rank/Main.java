
import java.util.Arrays;
import java.util.Comparator;
//import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);


        System.out.println("Card Ranks:");
        Arrays.stream(Cards.values()).sorted(Comparator.comparing(Enum::ordinal))
                .forEach(d -> System.out.printf("Ordinal value: %d; Name value: %s\n", d.ordinal(), d.name()));
//
//        String card = scanner.nextLine();
//        String cardType = scanner.nextLine();
//
//        Cards cardValue = Cards.valueOf(card);
//        Deck deckPower = Deck.valueOf(cardType);
//
//        System.out.printf("Card name: %s of %s; Card power: %d%n", card, cardType, cardValue.getPower() + deckPower.getPower());

    }
}
