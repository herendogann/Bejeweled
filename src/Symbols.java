import java.util.ArrayList;
import java.util.Collections;

public class Symbols extends Jewel{
    public static void left_diagonal(String[][] gameGrid, int y, int x, ArrayList<String> score_list, String[] symbols) {
        String up_left = "";
        String up_left2 = "";
        String down_right = "";
        String down_right2 = "";

        if (y > 0 && x > 0) {up_left = gameGrid[y - 1][x - 1];}
        if (y > 1 && x > 1) {up_left2 = gameGrid[y - 2][x - 2];}
        if (y < gameGrid.length - 1 && x < gameGrid[y].length) {down_right = gameGrid[y + 1][x + 1];}
        if (y < gameGrid.length - 2 && x < gameGrid[y].length - 2) {down_right2 = gameGrid[y + 2][x + 2];}

        String[][] directions = {{up_left, up_left2}, {down_right, down_right2}};
        boolean match = false;

        for (int d = 0; d < directions.length; d++) {
        for (String symbol1 : symbols) {
            for (String symbol2 : symbols) {

                    if (directions[d][0].equals(symbol1) && directions[d][1].equals(symbol2)) {
                        gameGrid[y][x] = " ";
                        if (d == 0) {
                            gameGrid[y - 1][x - 1] = " ";
                            gameGrid[y - 2][x - 2] = " ";
                        } else {
                            gameGrid[y + 1][x + 1] = " ";
                            gameGrid[y + 2][x + 2] = " ";
                        }
                        int score = 60;
                        Collections.addAll(score_list, "\\", symbol1, symbol2);
                        print_grid(gameGrid);
                        write("monitoring.txt","Score: " + score + " points" + "\n\n");
                        match = true;
                    }
                }
            } if (match) {break;}
        } if (!match) {
            int score = 0;
            print_grid(gameGrid);
            write("monitoring.txt","Score: " + score + " points" + "\n\n");
        }
    }

    public static void right_diagonal(String[][] gameGrid, int y, int x, ArrayList<String> score_list, String[] symbols) {
        String up_right = "";
        String up_right2 = "";
        String down_left = "";
        String down_left2 = "";

        if (y > 0 && x < gameGrid[y].length - 1) {up_right = gameGrid[y - 1][x + 1];}
        if (y > 1 && x < gameGrid[y].length - 2) {up_right2 = gameGrid[y - 2][x + 2];}
        if (y < gameGrid.length - 1 && x > 0) {down_left = gameGrid[y + 1][x - 1];}
        if (y < gameGrid.length - 2 && x > 1) {down_left2 = gameGrid[y + 2][x - 2];}

        String[][] directions = {{up_right, up_right2}, {down_left, down_left2}};
        boolean match = false;
        for (int d = 0; d < directions.length; d++) {
            for (String symbol1 : symbols) {
                for (String symbol2 : symbols) {
                    if (directions[d][0].equals(symbol1) && directions[d][1].equals(symbol2)) {
                        gameGrid[y][x] = " ";
                        if (d == 0) {
                            gameGrid[y - 1][x + 1] = " ";
                            gameGrid[y - 2][x + 2] = " ";
                        } else {
                            gameGrid[y + 1][x - 1] = " ";
                            gameGrid[y + 2][x - 2] = " ";
                        }
                        int score = 60;
                        Collections.addAll(score_list, "/", symbol1, symbol2);
                        print_grid(gameGrid);
                        write("monitoring.txt","Score: " + score + " points" + "\n\n");
                        match = true;
                    }
                }
            }
            if (match) {break;}
        } if (!match) {
            int score = 0;
            print_grid(gameGrid);
            write("monitoring.txt","Score: " + score + " points" + "\n\n");
        }
    }

    public static void vertical(String[][] gameGrid, int y, int x, ArrayList<String> score_list, String[] symbols) {
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
        for (String symbol1 : symbols) {
            for (String symbol2 : symbols) {
                    if (directions[d][0].equals(symbol1) && directions[d][1].equals(symbol2)) {
                        gameGrid[y][x] = " ";
                        if (d == 0) {
                            gameGrid[y - 1][x] = " ";
                            gameGrid[y - 2][x] = " ";
                        } else {
                            gameGrid[y + 1][x] = " ";
                            gameGrid[y + 2][x] = " ";
                        }
                        int score = 60;
                        Collections.addAll(score_list, "|", symbol1, symbol2);
                        print_grid(gameGrid);
                        write("monitoring.txt","Score: " + score + " points" + "\n\n");
                        match = true;
                    }
                }
            } if (match) {break;}
        } if (!match) {
            int score = 0;
            Writer.print_grid(gameGrid);
            Writer.write("monitoring.txt","Score: " + score + " points" + "\n\n");
        }
    }

    public static void horizontal(String[][] gameGrid, int y, int x, ArrayList<String> score_list, String[] symbols) {
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
        for (String symbol1 : symbols) {
            for (String symbol2 : symbols) {
                    if (directions[d][0].equals(symbol1) && directions[d][1].equals(symbol2)) {
                        gameGrid[y][x] = " ";
                        if (d == 0) {
                            gameGrid[y][x - 1] = " ";
                            gameGrid[y][x - 2] = " ";
                        } else {
                            gameGrid[y][x + 1] = " ";
                            gameGrid[y][x + 2] = " ";
                        }
                        int score = 60;
                        Collections.addAll(score_list, "-", symbol1, symbol2);
                        print_grid(gameGrid);
                        write("monitoring.txt","Score: " + score + " points" + "\n\n");
                        match = true;
                    }
                }
            } if (match) {break;}
        } if (!match) {
            int score = 0;
            print_grid(gameGrid);
            write("monitoring.txt","Score: " + score + " points" + "\n\n");
        }
    }

    public static void plus(String[][] gameGrid, int y, int x, ArrayList<String> score_list, String[] symbols) {
        String left = "";
        String left2 = "";
        String right = "";
        String right2 = "";
        String up = "";
        String up2 = "";
        String down = "";
        String down2 = "";

        if (x > 0) {left = gameGrid[y][x - 1];}
        if (x > 1) {left2 = gameGrid[y][x - 2];}
        if (x < gameGrid[y].length - 1) {right = gameGrid[y][x + 1];}
        if (x < gameGrid[y].length - 2) {right2 = gameGrid[y][x + 2];}
        if (y > 0) {up = gameGrid[y - 1][x];}
        if (y > 1) {up2 = gameGrid[y - 2][x];}
        if (y < gameGrid.length - 1) {down = gameGrid[y + 1][x];}
        if (y < gameGrid.length - 2) {down2 = gameGrid[y + 2][x];}

        String[][] directions = {{left, left2}, {right, right2}, {up, up2}, {down, down2}};
        boolean match = false;
        for (int d = 0; d < directions.length; d++) {
        for (String symbol1 : symbols) {
            for (String symbol2 : symbols) {

                    if (directions[d][0].equals(symbol1) && directions[d][1].equals(symbol2)) {
                        gameGrid[y][x] = " ";
                        if (d == 0) {
                            gameGrid[y][x - 1] = " ";
                            gameGrid[y][x - 2] = " ";
                        } else if (d == 1){
                            gameGrid[y][x + 1] = " ";
                            gameGrid[y][x + 2] = " ";
                        } else if (d == 2){
                            gameGrid[y - 1][x] = " ";
                            gameGrid[y - 2][x] = " ";
                        } else {
                            gameGrid[y + 1][x] = " ";
                            gameGrid[y + 2][x] = " ";
                        }
                        int score = 60;
                        Collections.addAll(score_list, "-", symbol1, symbol2);
                        print_grid(gameGrid);
                        write("monitoring.txt","Score: " + score + " points" + "\n\n");
                        match = true;
                    }
                }
            } if (match) {break;}
        } if (!match) {
            int score = 0;
            print_grid(gameGrid);
            write("monitoring.txt","Score: " + score + " points" + "\n\n");
        }
    }
}