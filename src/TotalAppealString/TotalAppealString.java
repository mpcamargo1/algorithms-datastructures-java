package TotalAppealString;

import java.util.HashMap;
import java.util.Map;

public class TotalAppealString {

    private String string;

    public TotalAppealString (String s) {
        this.string = s;
    }

    public long appealSum() {
        if (string == null || string.isBlank()) {
            return 0;
        }

        long accumulator = 0;

        Map<Character, Integer> lastSeenMap = new HashMap<>();
        int length = string.length();

        for (int i = 0; i < string.length(); i++) {
            long lastSeen = lastSeenMap.getOrDefault(string.charAt(i), -1);

            long appeal = (i - lastSeen) * (length - i);
            accumulator += appeal;

            lastSeenMap.put(string.charAt(i), i);
        }

        return accumulator;
    }

    public static void main(String[] args) {
        String test = "abbabc";

        TotalAppealString appeal = new TotalAppealString(test);
        System.out.println(appeal.appealSum());
    }



}
