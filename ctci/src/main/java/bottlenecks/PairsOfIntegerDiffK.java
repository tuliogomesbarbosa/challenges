package bottlenecks;

import java.util.HashSet;
import java.util.Set;

public class PairsOfIntegerDiffK {
    public static void main(String[] args) {
        System.out.println(pairs(new int[]{1, 7, 5, 9, 2, 12, 3}, 2)); // -> 4
    }

    private static int pairs(int[] arr, int target) {
        Set<Integer> occurrences = new HashSet<>();
        int response = 0;
        for (int i : arr) {
            if (occurrences.contains(i - target)) {
                response++;
            }

            if (occurrences.contains(i - target)) {
                response++;
            }
            occurrences.add(i);
        }

        return response;
    }
}
