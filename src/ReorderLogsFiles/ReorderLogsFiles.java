package ReorderLogsFiles;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogsFiles {

    private String[] array;

    public ReorderLogsFiles(String[] array) {
        this.array = array;
    }

    public void reorder() {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int indexContent_a = a.indexOf(" ");
                int indexContent_b = b.indexOf(" ");

                char charA = a.charAt(indexContent_a + 1);
                char charB = b.charAt(indexContent_b + 1);

                // Digit and Digit
                if (Character.isDigit(charA) && Character.isDigit(charB)) {
                    return 0;
                }

                // Digit and Letter
                if (Character.isDigit(charA)) {
                    return 1;
                }

                // Letter and Digit
                if (Character.isDigit(charB)) {
                    return -1;
                }

                // Letter and Letter
                int compare = a.substring(indexContent_a + 1).compareTo(b.substring(indexContent_b + 1));

                if (compare == 0) {
                    return a.substring(0, indexContent_a - 1).compareTo(b.substring(0, indexContent_b - 1));
                }

                return compare;
            }
        };

        Arrays.sort(array, comparator);
    }

    public String[] getArray() {
        return array;
    }

    public static void main(String[] args) {
        ReorderLogsFiles logsFiles = new ReorderLogsFiles(
                new String[]{"let4 1 8 1 2", "let1 art can", "let3 dog dog", "let4 1 1 1 1"});
        logsFiles.reorder();
    }
}
