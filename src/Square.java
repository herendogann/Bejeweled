import java.util.ArrayList;
import java.util.Collections;

public class Square extends Jewel{
    public static void square(String[][] gameGrid, int y, int x, ArrayList<String> score_list) {
        String left = "";
        String left2 = "";
        String right = "";
        String right2 = "";

        if (x > 0) {left = gameGrid[y][x - 1];}
        if (x > 1) {left2 = gameGrid[y][x - 2];}
        if (x < gameGrid[y].length - 1) {right = gameGrid[y][x + 1];}
        if (x < gameGrid[y].length - 2) {right2 = gameGrid[y][x + 2];}

        String[][] directions = {{left, left2}, {right, right2}};
        boolean match = false;
        for (int d = 0; d < directions.length; d++) {
            if (directions[d][0].equals("S") && directions[d][1].equals("S")){
                gameGrid[y][x] = " ";
                if (d == 0) {
                    gameGrid[y][x - 1] = " ";
                    gameGrid[y][x - 2] = " ";
                } else {
                    gameGrid[y][x + 1] = " ";
                    gameGrid[y][x + 2] = " ";
                }
                int score = 45;
                Collections.addAll(score_list,"S", "S", "S");
                print_grid(gameGrid);
                write("monitoring.txt","Score: " + score + " points" + "\n\n");
                match = true;
            } if (match) {break;}
        } if (!match) {
            int score = 0;
            print_grid(gameGrid);
            write("monitoring.txt","Score: " + score + " points" + "\n\n");
        }
    }
}