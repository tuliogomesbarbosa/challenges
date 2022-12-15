package arrays;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        // [["bat"],["nat","tan"],["ate","eat","tea"]]
        groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}).forEach(l -> System.out.printf(l + " "));
        System.out.println();
        // [[""]]
        groupAnagrams(new String[]{""}).forEach(System.out::println);
        // [["a"]]
        groupAnagrams(new String[]{"a"}).forEach(System.out::println);
        // [["",""]]
        groupAnagrams(new String[]{"",""}).forEach(System.out::println);
    }

    // O(m * nlog(n)) -> O(m) = strs size, n = each string size (for sorting)
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> response = new ArrayList<>();

        if (strs.length == 0) {
            return new ArrayList<>();
        }

        if (strs.length == 1 && strs[0].equals("")) {
            response.add(List.of(""));
            return response;
        }

        Map<String, List<String>> anagrams = new HashMap<>();
        for (String s : strs) {
            String sorted = sortString(s); // complexity of sorting the string?
            if (anagrams.containsKey(sorted)) {
                anagrams.get(sorted).add(s);
            } else {
                anagrams.put(sorted, new ArrayList<>(List.of(s))); // this is inefficient: extra allocation (list is immutable)
            }
        }

        for (Map.Entry<String, List<String>> entry : anagrams.entrySet()) {
            response.add(new ArrayList<>(entry.getValue()));
        }

        return response;
    }

    private static String sortString(String str) {
        return str.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).
                toString();
    }
}
