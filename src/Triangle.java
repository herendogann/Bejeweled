import java.util.ArrayList;
import java.util.Collections;

public class Triangle extends Jewel{
    public static void triangle(String[][] gameGrid, int y, int x, ArrayList<String> score_list) {
        String up = "";
        String up2 = "";
        String down = "";
        String down2 = "";

        if (y > 0) {up = gameGrid[y - 1][x];}
        if (y > 1) {up2 = gameGrid[y - 2][x];}
        if (y < gameGrid.length - 1) {down = gameGrid[y + 1][x];}
        if (y < gameGrid.length - 2) {down2 = gameGrid[y + 2][x];}

        String[][] directions = {{up, up2}, {down, down2}};
        boolean match = false;
        for (int d = 0; d < directions.length; d++) {
            if (directions[d][0].equals("T") && directions[d][1].equals("T")) {
                gameGrid[y][x] = " ";
                if (d == 0) {
                    gameGrid[y - 1][x] = " ";
                    gameGrid[y - 2][x] = " ";
                } else {
                    gameGrid[y + 1][x] = " ";
                    gameGrid[y + 2][x] = " ";
                }
                int score = 45;
                Collections.addAll(score_list,"T", "T", "T");
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