package collection.map;

import java.util.HashMap;
import java.util.Map;

public class UpdateMapValue {

    public static void main(String[] args) {
        String article = "apple banana cat dog egg fly garden apple egg egg fly egg cat";
        String[] wordsArray = article.split(" ");
        Map<String, Integer> wordsCount = new HashMap<>();
        // 自己做判断
//        for (String word : wordsArray) {
//            if (!wordsCount.containsKey(word)) {
//                wordsCount.put(word, 1);
//            } else {
//                wordsCount.put(word, wordsCount.get(word)+1);
//            }
//        }
        //使用getOrDefault
//        for (String word : wordsArray) {
//            wordsCount.put(word, wordsCount.getOrDefault(word, 0) + 1);
//        }
        //使用putIfAbsent
//        for (String word : wordsArray) {
//            wordsCount.putIfAbsent(word, 0);
//            wordsCount.put(word, wordsCount.get(word) + 1);
//        }

        //使用merge
        for (String word : wordsArray) {
            wordsCount.merge(word, 1, Integer::sum);
        }

        for (Map.Entry<String, Integer> entry : wordsCount.entrySet()) {
            System.out.println(entry.getKey() + "出现" + entry.getValue() + "次");
        }

    }
}
