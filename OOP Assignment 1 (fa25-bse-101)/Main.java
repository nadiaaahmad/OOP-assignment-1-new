public class Main {
    public static void main(String[] args) {
        String[] names = {"Shahid", "Hassan", "Ahmad"};
        int totalRounds = 5;
        Game game = new Game(names, totalRounds);
        game.playGame();
    }
}