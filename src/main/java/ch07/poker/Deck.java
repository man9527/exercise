package ch07.poker;

import java.util.ArrayList;
import java.util.List;

public class Deck <T extends Card> {
    private List<Card> cards = new ArrayList<>(52);

    public Deck() {
        //TODO: generate init deck

    }

    private void shuffle() {

    }

    public Card assignCard() {
        return cards.get(0);
    }
}
