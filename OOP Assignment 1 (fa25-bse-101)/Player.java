class Player {
    private String name;
    private int score = 0;
    private Card card;
    Player(String name) {
        this.name = name;
    }
    public void drawCard(Card c) {
        this.card = c;
    }
    public Card getCard() {
        return card;
    }
    public void addPoint() {
        score++;
    }
    public int getScore() {
        return score;
    }
    public String getName() {
        return name;
    }
    public String toString() {
        return String.format("%s : %d", name, score);
    }
}