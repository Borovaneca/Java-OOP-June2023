
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        String card = scanner.nextLine();
        String cardType = scanner.nextLine();

        Cards cardValue = Cards.valueOf(card);
        Deck deckPower = Deck.valueOf(cardType);

        System.out.printf("Card name: %s of %s; Card power: %d%n", card, cardType, cardValue.getPower() + deckPower.getPower());

    }
}
