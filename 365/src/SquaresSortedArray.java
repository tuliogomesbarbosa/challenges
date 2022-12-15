import java.util.Arrays;

public class SquaresSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public static int[] sortedSquares(int[] nums) {
        int i = 0, j = nums.length - 1;
        int[] res = new int[nums.length];

        while (j >= i) {
            res[j - i] = power(nums[i]) > power(nums[j]) ? power(nums[i++]) : power(nums[j--]);
        }

        return res;
    }

    private static int power(int n) {
        return n * n;
    }
}
