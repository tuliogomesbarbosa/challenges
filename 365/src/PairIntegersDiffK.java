import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of distinct integer values, counter the number of pairs of integers that have difference K.
 */
public class PairIntegersDiffK {
    public static void main(String[] args) {
        System.out.println(countPairs(2, new int[]{1, 7, 5, 9, 2, 12, 3}));
    }

    private static int countPairs(int k, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        int pairs = 0;
        for (int i : nums) {
            if (set.contains(i + k)) { // || set.contains(i - k)) {
                pairs++;
            }
        }

        return pairs;
    }
}
