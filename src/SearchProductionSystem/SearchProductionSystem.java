package SearchProductionSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchProductionSystem {

    private String[] array;


    public SearchProductionSystem(String[] array) {
        this.array = array;
    }

    public List<List<String>> search(String searchWord) {
        List<List<String>> result = new ArrayList<>();
        Arrays.sort(array);
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < searchWord.length(); i++) {
            builder.append(searchWord.charAt(i));
            int index = Arrays.binarySearch(array, builder.toString());

            if (index < 0) {
                index = -(index + 1);
            }

            List<String> suggestions = new ArrayList<>();
            for (int a = index; a < Math.min(index + 3, array.length); a++) {
                if (array[a].contains(builder.toString())) {
                    suggestions.add(array[a]);
                    continue;
                }
                break;
            }

            result.add(suggestions);
        }

        return result;
    }

    public static void main(String[] args) {
        SearchProductionSystem search = new SearchProductionSystem(
                new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad", "moute", "mouted", "moutedd",
                        "mouteddd"});

        System.out.println(search.search("mouse"));
    }

}

