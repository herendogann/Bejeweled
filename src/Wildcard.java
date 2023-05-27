import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Wildcard extends Jewel{
    public static void wildcard(String[][] gameGrid, int y, int x, ArrayList<String> score_list, HashMap<String, Integer> jewels_scores, String[] jewels) {
        String up = "";
        String up2 = "";
        String down = "";
        String down2 = "";
        String left = "";
        String left2 = "";
        String right = "";
        String right2 = "";
        String up_left = "";
        String up_left2 = "";
        String down_right = "";
        String down_right2 = "";
        String up_right = "";
        String up_right2 = "";
        String down_left = "";
        String down_left2 = "";

        if (y > 0) {up = gameGrid[y - 1][x];}
        if (y > 1) {up2 = gameGrid[y - 2][x];}
        if (y < gameGrid.length - 1) {down = gameGrid[y + 1][x];}
        if (y < gameGrid.length - 2) {down2 = gameGrid[y + 2][x];}
        if (x > 0) {left = gameGrid[y][x - 1];}
        if (x > 1) {left2 = gameGrid[y][x - 2];}
        if (x < gameGrid[y].length - 1) {right = gameGrid[y][x + 1];}
        if (x < gameGrid[y].length - 2) {right2 = gameGrid[y][x + 2];}
        if (y > 0 && x > 0) {up_left = gameGrid[y - 1][x - 1];}
        if (y > 1 && x > 1) {up_left2 = gameGrid[y - 2][x - 2];}
        if (y < gameGrid.length - 1 && x < gameGrid[y].length) {down_right = gameGrid[y + 1][x + 1];}
        if (y < gameGrid.length - 2 && x < gameGrid[y].length - 2) {down_right2 = gameGrid[y + 2][x + 2];}
        if (y > 0 && x < gameGrid[y].length - 1) {up_right = gameGrid[y - 1][x + 1];}
        if (y > 1 && x < gameGrid[y].length - 2) {up_right2 = gameGrid[y - 2][x + 2];}
        if (y < gameGrid.length - 1 && x > 0) {down_left = gameGrid[y + 1][x - 1];}
        if (y < gameGrid.length - 2 && x > 1) {down_left2 = gameGrid[y + 2][x - 2];}

        String[][] directions = {{up, up2}, {down, down2}, {left, left2}, {right, right2},
                {up_left, up_left2}, {down_right, down_right2}, {up_right, up_right2}, {down_left, down_left2}};
        boolean match = false;
        for (int d = 0; d < directions.length; d++) {
            for (int i = 1; i < jewels.length; i++) {
                if (directions[d][0].equals(jewels[i]) && directions[d][1].equals(jewels[i])) {
                    boom(gameGrid, y, x, d);
                    Collections.addAll(score_list, jewels[i], jewels[i], "W");
                    int score = jewels_scores.get(jewels[i]) * 2 + 10;
                    print_grid(gameGrid);
                    write("monitoring.txt","Score: " + score + " points" + "\n\n");
                    match = true;
                } else if ((directions[d][0].equals("W") && directions[d][1].equals(jewels[i])) || (directions[d][0].equals(jewels[i]) && directions[d][1].equals("W"))) {
                    boom(gameGrid, y, x, d);
                    Collections.addAll(score_list, jewels[i], "W", "W");
                    int score = jewels_scores.get(jewels[i]) + 20;
                    print_grid(gameGrid);
                    write("monitoring.txt","Score: " + score + " points" + "\n\n");
                    match = true;
                } else if (directions[d][0].equals("W") && directions[d][1].equals("W")) {
                    boom(gameGrid, y, x, d);
                    Collections.addAll(score_list, jewels[i], "W", "W");
                    int score = 30;
                    print_grid(gameGrid);
                    write("monitoring.txt","Score: " + score + " points" + "\n\n");
                    match = true;
                }
            } if (match) {break;}
        } if (!match) {
            int score = 0;
            print_grid(gameGrid);
            write("monitoring.txt","Score: " + score + " points" + "\n\n");
        }
    }
    public static void boom(String[][] gameGrid, int y, int x, int d) {
        gameGrid[y][x] = " ";
        if (d == 0) {
            gameGrid[y - 1][x] = " ";
            gameGrid[y - 2][x] = " ";
        } else if (d == 1) {
            gameGrid[y + 1][x] = " ";
            gameGrid[y + 2][x] = " ";
        } else if (d == 2) {
            gameGrid[y][x - 1] = " ";
            gameGrid[y][x - 2] = " ";
        } else if (d == 3) {
            gameGrid[y][x + 1] = " ";
            gameGrid[y][x + 2] = " ";
        } else if (d == 4) {
            gameGrid[y - 1][x - 1] = " ";
            gameGrid[y - 2][x - 2] = " ";
        } else if (d == 5) {
            gameGrid[y + 1][x + 1] = " ";
            gameGrid[y + 2][x + 2] = " ";
        } else if (d == 6) {
            gameGrid[y - 1][x + 1] = " ";
            gameGrid[y - 2][x + 2] = " ";
        } else if (d == 7){
            gameGrid[y + 1][x - 1] = " ";
            gameGrid[y + 2][x - 2] = " ";
        }
    }
}