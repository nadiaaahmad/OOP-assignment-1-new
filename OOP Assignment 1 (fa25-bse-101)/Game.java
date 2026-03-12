class Game {
    private Deck deck;
    private Player[] players;
    private int rounds;
    Game(String[] names, int rounds) {
        players = new Player[names.length];
        for (int i = 0; i < names.length; i++) {
            players[i] = new Player(names[i]);
        }
        this.rounds = rounds;
        deck = new Deck();
    }
    public void playGame() {
        deck.shuffle();

        for (int round = 0; round < rounds; round++) {
            System.out.println("=== Round " + (round + 1) + " ===");
            int highest = -1;
            boolean cardsAvailable = true;
            for (Player p : players) {
                Card card = deck.drawCard();
                if (card == null) {
                    System.out.println("No more cards in deck! Game ending early.");
                    cardsAvailable = false;
                    break;
                }
                p.drawCard(card);
                System.out.println(p.getName() + " drew " + card);
                if (card.getValue() > highest) highest = card.getValue();
            }
            if (!cardsAvailable) break;
            System.out.print("Round Winner(s): ");
            for (Player p : players) {
                if (p.getCard().getValue() == highest) {
                    p.addPoint();
                    System.out.print(p.getName() + " ");
                }
            }
            System.out.println("\n");
        }
        System.out.println("=== Final Scores ===");
        int maxScore = -1;
        for (Player p : players) {
            System.out.println(p);
            if (p.getScore() > maxScore) maxScore = p.getScore();
        }
        System.out.print("Overall Winner(s): ");
        for (Player p : players) {
            if (p.getScore() == maxScore) System.out.print(p.getName() + " ");
        }
        System.out.println();
    }
}