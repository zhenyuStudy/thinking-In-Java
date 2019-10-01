import java.util.HashMap;
import java.util.Map;

public class WordCount {

    public static void main(String[] args) {
        String article = "apple banana cat dog egg fly garden apple egg egg fly egg cat";
        String[] wordsArray = article.split(" ");
        Map<String, Integer> wordsCount = new HashMap<>();
        for (String word : wordsArray) {
            if (!wordsCount.containsKey(word)) {
                wordsCount.put(word, 1);
            } else {
                wordsCount.put(word, wordsCount.get(word)+1);
            }
        }
        for (Map.Entry<String, Integer> entry : wordsCount.entrySet()) {
            System.out.println(entry.getKey() + "出现" + entry.getValue() + "次");
        }
    }
}