package book.chapter1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Given two strings, write a method to decide if one is a permutation of the other.
// Case-sensitive and space taken into consideration.
public class StringPermutation {

    public static void main(String[] args) {
        System.out.println("dog -> god: " + isPermutationWithSortedStrings("dog", "god"));
        System.out.println("\"dog \" -> \"God\": " + isPermutationWithSortedStrings("dog ", "God"));

        System.out.println("dog -> god: " + isPermutationWithHashTable("dog", "god"));
        System.out.println("\"dog \" -> \"God\": " + isPermutationWithHashTable("dog ", "God"));

        System.out.println("\"dogg\" -> \"godl\": " + permutation("dogg", "godl"));
    }

    // O(nlog(n)) time -> quickSort? clean and simple
    private static boolean isPermutationWithSortedStrings(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        return sortString(str1).equals(sortString(str2));
    }

    private static String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }

    private static boolean isPermutationWithHashTable(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Integer> count1 = new HashMap<>();

        for (char c : str1.toCharArray()) {
            count1.merge(c, 1, Integer::sum);
        }

        Map<Character, Integer> count2 = new HashMap<>();

        for (char c : str2.toCharArray()) {
            count2.merge(c, 1, Integer::sum);
        }

        for (Map.Entry<Character, Integer> entrySet : count1.entrySet()) {
            if (!count2.get(entrySet.getKey()).equals(entrySet.getValue())) return false;
        }

        return true;
    }

    private static boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[128]; // Assumption
        char[] s_array = s.toCharArray();
        for (char c : s_array) { // count number of each char in s.
            letters[c]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int c = t.charAt(i);
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }

        return true;
    }
}
