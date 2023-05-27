public class Main extends Reader{
    public static void main(String[] args) {
        String[][] gameGrid = text_reader(args[0]);
        String[][] commands = text_reader(args[1]);
        Game.game(gameGrid,commands);
    }
}