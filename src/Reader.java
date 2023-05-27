import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Reader {
    public static String[][] text_reader(String fileName) {
        String[][] empty_array = new String[100][100];
        int j = 0;
        try {
            Scanner scanner = new Scanner(new FileReader(fileName));
            while (scanner.hasNextLine()) {
                String[] text_array = scanner.nextLine().split(" ");
                for (int i = 0; i < text_array.length; i++) {
                    empty_array[j][i] = text_array[i];
                }
                j++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int row = 0;
        for (int y = 0; y < 100; y++) {
            if (empty_array[y][0] != null) {
                row++;
            }
        }
        int column = 0;
        for (int x = 0; x < 100; x++) {
            if (empty_array[0][x] != null) {
                column++;
            }
        }
        String[][] array = new String[row][column];
        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array[y].length; x++) {
                array[y][x] = empty_array[y][x];
            }
        } return array;
    }
}