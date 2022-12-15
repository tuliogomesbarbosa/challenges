public class MinSizeSubArraySum {

    public static int findMinSubArray(int S, int[] arr) {
        int minLength = Integer.MAX_VALUE, windowStart = 0, sum = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            sum += arr[windowEnd];
            while (sum >= S) {
                minLength = Math.min(minLength, (windowEnd - windowStart) + 1);
                sum -= arr[windowStart];
                windowStart++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        System.out.println(findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2}));
        System.out.println(findMinSubArray(7, new int[]{2, 1, 5, 2, 8}));
        System.out.println(findMinSubArray(8, new int[]{3, 4, 1, 1, 6}));
        System.out.println(findMinSubArray(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(findMinSubArray(7, new int[]{1, 1, 2, 1, 1, 1, 2}));
    }
}
