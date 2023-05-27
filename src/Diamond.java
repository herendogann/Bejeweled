import java.util.ArrayList;
import java.util.Collections;

public class Diamond extends Jewel {

    public static void diamond(String[][] gameGrid, int y, int x, ArrayList<String> score_list) {
        String up_left = "";
        String up_left2 = "";
        String down_right = "";
        String down_right2 = "";
        String up_right = "";
        String up_right2 = "";
        String down_left = "";
        String down_left2 = "";

        if (y > 0 && x > 0) {up_left = gameGrid[y - 1][x - 1];}
        if (y > 1 && x > 1) {up_left2 = gameGrid[y - 2][x - 2];}
        if (y < gameGrid.length - 1 && x < gameGrid[y].length) {down_right = gameGrid[y + 1][x + 1];}
        if (y < gameGrid.length - 2 && x < gameGrid[y].length - 2) {down_right2 = gameGrid[y + 2][x + 2];}
        if (y > 0 && x < gameGrid[y].length - 1) {up_right = gameGrid[y - 1][x + 1];}
        if (y > 1 && x < gameGrid[y].length - 2) {up_right2 = gameGrid[y - 2][x + 2];}
        if (y < gameGrid.length - 1 && x > 0) {down_left = gameGrid[y + 1][x - 1];}
        if (y < gameGrid.length - 2 && x > 1) {down_left2 = gameGrid[y + 2][x - 2];}

        String[][] directions = {{up_left, up_left2}, {down_right, down_right2}, {up_right, up_right2}, {down_left, down_left2}};
        boolean match = false;
        for (int d = 0; d < directions.length; d++) {
            if (directions[d][0].equals("D") && directions[d][1].equals("D")) {
                gameGrid[y][x] = " ";
                if (d == 0) {
                    gameGrid[y - 1][x - 1] = " ";
                    gameGrid[y - 2][x - 2] = " ";
                } else if (d == 1) {
                    gameGrid[y + 1][x + 1] = " ";
                    gameGrid[y + 2][x + 2] = " ";
                } else if (d == 2) {
                    gameGrid[y - 1][x + 1] = " ";
                    gameGrid[y - 2][x + 2] = " ";
                } else {
                    gameGrid[y + 1][x - 1] = " ";
                    gameGrid[y + 2][x - 2] = " ";
                }
                int score = 90;
                Collections.addAll(score_list,"D", "D", "D");
                print_grid(gameGrid);
                write("monitoring.txt","Score: " + score + " points" + "\n\n");
                match = true;
            } if (match) {break;}
        } if (!match) {
            int score = 0;
            print_grid(gameGrid);
            write("monitoring.txt","Score: " + score + " points"+ "\n\n");
        }
    }
}