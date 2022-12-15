import java.util.Arrays;

public class RemoveWhitespaces {

    public static void main(String[] args) {
        System.out.println(removeWhiteSpaces("\tAll greek to me.".toCharArray()));
    }

    // 1) All greek 2) All greek to me.
    // 1) Allgreek  2) Allgreektome.
    private static String removeWhiteSpaces(char[] sentence) {
        int read = 0, write = 0;

        while (read < sentence.length) {
            if (sentence[read] == ' ' || sentence[read] == '\t') {
                read++;
                continue;
            }

            sentence[write] = sentence[read];
            write++;
            read++;
        }

        return String.valueOf(Arrays.copyOfRange(sentence, 0, write));
    }
}
