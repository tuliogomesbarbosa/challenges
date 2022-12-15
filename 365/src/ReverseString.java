import java.util.Arrays;

public class ReverseString {


    public static void main(String[] args) {
        char[] chars = "Hello world.".toCharArray();
        System.out.println(reverseWords(chars));

        chars = "Hello world.".toCharArray();
        reverseInPlace(chars, 0 , chars.length-1);
        System.out.println(Arrays.toString(chars));
    }

    /**
     * "Hello world." -> "world. Hello"
     * Stages: 1) ".dlrow olleH"; 2) "world. Hello"
     */
    private static String reverseWords(char[] sentence) {
        if (sentence == null || sentence.length == 0) {
            return "";
        }

        int length = sentence.length;
        reverseInPlace(sentence, 0, sentence.length - 1);

        // sentence is now ".dlrow olleH"

        int start = 0, end = 0;

        while (start < length - 1) {

            // if string have some leading spaces
            while (sentence[start] == ' ') {
                start++;
            }

            end = start + 1;
            while (end < length && sentence[end] != ' ') {
                end++;
            }

            reverseInPlace(sentence, start, end - 1);
            start = end;
        }

        return String.valueOf(sentence);
    }

    private static void reverseInPlace(char[] original, int start, int end) {
        while (start <= end) {
            char tmp = original[start];
            original[start] = original[end];
            original[end] = tmp;
            start++;
            end--;
        }
    }
}
