package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Anagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> wordCountS = new HashMap<>();
        Map<Character, Integer> wordCountT = new HashMap<>();

        for (char c : s.toCharArray()) {
            wordCountS.merge(c, 1, Integer::sum);
        }

        wordCountS.forEach((key, value) -> System.out.println(key + " " + value));

        for (char c : t.toCharArray()) {
            wordCountT.merge(c, 1, Integer::sum);
        }

        System.out.println();

        wordCountT.forEach((key, value) -> System.out.println(key + " " + value));

        for (Map.Entry<Character, Integer> entry : wordCountS.entrySet()) {
            if (!Objects.equals(entry.getValue(), wordCountT.get(entry.getKey()))) {
                return false;
            }
        }

        return true;
    }
}
