import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public static void write(String fileName, String output) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, true);
            writer.write(output);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void print_grid(String[][] gameGrid) {
        for (String[] line : gameGrid) {
            for (String cell : line) {
                if (cell != null) {
                    System.out.print(cell + " ");
                }
            }
            System.out.print("\n");
        }
    }
}