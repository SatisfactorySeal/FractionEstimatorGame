public class Game {
    public static void main(String[] args) {
        new GameFrame();
        FractionRow row = new FractionRow(5, 10);
        row.printFractionsData();
    }
}
