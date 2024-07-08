package test;

/**
 * @Author: zhqihang
 * @Date: 2024/04/17
 * @Project: coding
 * @Description: ...
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        String input = scanner.nextLine();
        String[] cards = input.split(" ");

        List<String> remainingCards = eliminate(cards);

        if (remainingCards.isEmpty()) {
            System.out.println("0");
        } else {
            for (String card : remainingCards) {
                System.out.print(card + " ");
            }
        }
    }

    private static List<String> eliminate(String[] cards) {
        List<String> remainingCards = new ArrayList<>();

        int count = 1;
        String prevCard = cards[0];

        for (int i = 1; i < cards.length; i++) {
            if (cards[i].equals(prevCard)) {
                count++;
            } else {
                if (count < 3) {
                    for (int j = 0; j < count; j++) {
                        remainingCards.add(prevCard);
                    }
                }
                count = 1;
                prevCard = cards[i];
            }
        }

        if (count < 3) {
            for (int j = 0; j < count; j++) {
                remainingCards.add(prevCard);
            }
        }

        if (remainingCards.size() < cards.length) {
            String[] remainingCardsArray = remainingCards.toArray(new String[0]);
            return eliminate(remainingCardsArray);
        } else {
            return remainingCards;
        }
    }
}

