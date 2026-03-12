import java.util.Random;
class Deck {
    private Card[] cards;
    private int currentCard = 0;
    private String[] suits = {"Spades", "Clubs", "Hearts", "Diamonds"};
    private String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9","10", "Jack", "Queen", "King"};
    Deck() {
        cards = new Card[52];
        int counter = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                cards[counter++] = new Card(suit, rank);
            }
        }
    }
    public void displayDeck() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }
    public Card drawCard() {
        if (currentCard < cards.length) {
            return cards[currentCard++];
        }
        return null;
    }
    public void shuffle() {
        Random random = new Random();
        for (int i = 0; i < cards.length; i++) {
            int j = random.nextInt(cards.length);
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }
}