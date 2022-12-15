import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveStringDuplications {


    public static void main(String[] args) {
        System.out.println(removeDuplicates("dabcace".toCharArray()));
    }

    private static String removeDuplicates(char[] sentence) {
        // 1. use a hash set and two pointers
        Set<Character> uniqueChars = new HashSet<>();
        int read = 0, write = 0;
        // dabcace

        while (read < sentence.length) {
            if (!uniqueChars.contains(sentence[read])) {
                uniqueChars.add(sentence[read]);
                sentence[write] = sentence[read];
                read++;
                write++;
            } else {
                read++;
            }
        }

        return String.valueOf(Arrays.copyOfRange(sentence, 0, write));
    }
}