import java.util.ArrayList;
import java.util.HashMap;

public class Jewel extends Writer{
    static ArrayList<String> score_list = new ArrayList<>();
    static String[] jewels = {"W", "D", "S", "T"};
    static String[] symbols = {"\\", "|", "/", "-", "+"};

    public static HashMap<String, Integer> jewel_scores() {
        HashMap<String, Integer> jewel_scores = new HashMap<>();
        jewel_scores.put("D", 30);
        jewel_scores.put("S", 15);
        jewel_scores.put("T", 15);
        jewel_scores.put("W", 10);
        jewel_scores.put("\\",20);
        jewel_scores.put("-", 20);
        jewel_scores.put("/", 20);
        jewel_scores.put("+", 20);
        jewel_scores.put("|", 20);
        return jewel_scores;
    }
}