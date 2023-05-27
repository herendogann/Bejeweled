import java.util.ArrayList;

public class Player implements Comparable<Player> {
    private String name;
    private int score;
    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public String getName() {return name;}
    public int getScore() {return score;}

    public static ArrayList<Player> sorted_leaderboards(String playerName, int playerScore) {
        String[][] leaderboards = Reader.text_reader("leaderboard.txt");
        ArrayList<Player> sorted_leaderboards = new ArrayList<>();
        for (String[] player : leaderboards) {
            sorted_leaderboards.add(new Player(player[0], Integer.parseInt(player[1])));
        } sorted_leaderboards.add(new Player(playerName, playerScore));
        sorted_leaderboards.sort(Player::compareTo);
        return sorted_leaderboards;
    }

    public int compareTo(Player player) {return player.score - this.score;}

    public static void ranking(String playerName, int total_score) {
        ArrayList<Player> sorted_leaderboards = Player.sorted_leaderboards(playerName, total_score);
        for (int i = 0; i < sorted_leaderboards.size(); i++) {
            if (sorted_leaderboards.get(i).getName().equals(playerName)) {
                Writer.write("monitoring.txt","Your rank is " + (i + 1) + "/" + sorted_leaderboards.size() + ", ");
                if (i == 0) {
                    Writer.write("monitoring.txt","your score is " + (total_score - sorted_leaderboards.get(i + 1).getScore())
                            + " points higher than " + sorted_leaderboards.get(i + 1).getName() + "\n\n");
                } else if (i == sorted_leaderboards.size() - 1) {
                    Writer.write("monitoring.txt","your score is " + (sorted_leaderboards.get(i - 1).getScore() - total_score)
                            + " points lower than " + sorted_leaderboards.get(i - 1).getName() + "\n\n");
                } else {
                    Writer.write("monitoring.txt","your score is " + (sorted_leaderboards.get(i - 1).getScore() - total_score)
                            + " points lower than " + sorted_leaderboards.get(i - 1).getName() + " and " + (total_score - sorted_leaderboards.get(i + 1).getScore())
                            + " points higher than " + sorted_leaderboards.get(i + 1).getName() + "\n\n");
                }
            }
        }
    }
}