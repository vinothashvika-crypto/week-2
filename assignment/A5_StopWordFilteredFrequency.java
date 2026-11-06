import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Week 2 Assignment 5 - Stop-Word-Filtered Word Frequency Report
 */
public class A5_StopWordFilteredFrequency {

    static final String[] STOP_WORDS = {"the", "was", "and", "a", "is", "of", "in"};

    static boolean isStopWord(String word) {
        for (String stop : STOP_WORDS) {
            if (stop.equals(word)) return true;
        }
        return false;
    }

    static void printFilteredWordFrequency(String feedback) {
        // Normalize: lowercase and strip common punctuation
        String cleaned = feedback.toLowerCase()
                .replace(".", " ").replace(",", " ")
                .replace("!", " ").replace("?", " ")
                .replace(";", " ").replace(":", " ");

        // LinkedHashMap keeps first-seen order, so ties print in reading order
        Map<String, Integer> counts = new LinkedHashMap<String, Integer>();
        for (String word : cleaned.trim().split("\\s+")) {
            if (word.isEmpty() || isStopWord(word)) continue;
            Integer current = counts.get(word);
            counts.put(word, current == null ? 1 : current + 1);
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(counts.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return b.getValue() - a.getValue(); // descending by count (stable sort keeps ties in order)
            }
        });
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String feedback = "The mentor was great, the session was great and clear.";
        System.out.println("Feedback: \"" + feedback + "\"");
        printFilteredWordFrequency(feedback);
    }
}
