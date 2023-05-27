public class Game extends Jewel{
    public static void game(String[][] gameGrid, String[][] commands) {
        Writer.write("monitoring.txt", "Game grid:\n\n");
        Writer.print_grid(gameGrid);
        for (String[] command : commands) {
            if (command[1] != null) {
                int y = Integer.parseInt(command[0]);
                int x = Integer.parseInt(command[1]);

                Writer.write("monitoring.txt","Select coordinate or enter E to end the game: " + y + " " + x + "\n\n");
                if (y < gameGrid.length && x < gameGrid[y].length) {
                    String selected_cell = gameGrid[y][x];
                    if (selected_cell.equals("D")) { Diamond.diamond(gameGrid, y, x, score_list);
                    } else if (selected_cell.equals("S")) { Square.square(gameGrid, y, x, score_list);
                    } else if (selected_cell.equals("T")) { Triangle.triangle(gameGrid, y, x, score_list);
                    } else if (selected_cell.equals("W")) { Wildcard.wildcard(gameGrid, y, x, score_list, jewel_scores(), jewels);
                    } else if (selected_cell.equals("\\")){ Symbols.left_diagonal(gameGrid, y, x, score_list, symbols);
                    } else if (selected_cell.equals("/")) { Symbols.right_diagonal(gameGrid, y, x, score_list, symbols);
                    } else if (selected_cell.equals("|")) { Symbols.vertical(gameGrid, y, x, score_list, symbols);
                    } else if (selected_cell.equals("-")) { Symbols.horizontal(gameGrid, y, x, score_list, symbols);
                    } else if (selected_cell.equals("+")) { Symbols.plus(gameGrid, y, x, score_list, symbols);
                    } else if (selected_cell.equals(" ")) { Writer.write("monitoring.txt", "Please enter a valid coordinate\n\n");}
                } else {Writer.write("monitoring.txt","Please enter a valid coordinate\n\n");}
            } else if (command[0].equals("E")) {Writer.write("monitoring.txt","Select coordinate or enter E to end the game: E\n\n");
            } else {
                int total_score = 0;
                String playerName = command[0];
                for (String a : Jewel.score_list) {total_score += Jewel.jewel_scores().get(a);}
                Writer.write("monitoring.txt","Total score: " + total_score + " points\n\n");
                Writer.write("monitoring.txt","Enter name: " + playerName + "\n\n");
                Player.ranking(playerName, total_score);
                Writer.write("leaderboard.txt", "\n" + playerName + " " + total_score);
            }
        } Writer.write("monitoring.txt","Good bye!\n");
    }
}