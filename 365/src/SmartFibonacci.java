public class SmartFibonacci {
    public static void main(String[] args) {

        System.out.printf("Fib of %d: %d\n", 1, fib(1, new int[1 + 1]));
        System.out.printf("Fib of %d: %d\n", 2, fib(2, new int[2 + 1]));
        System.out.printf("Fib of %d: %d\n", 3, fib(3, new int[3 + 1]));
        System.out.printf("Fib of %d: %d\n", 4, fib(4, new int[4 + 1]));
    }

    /**
     * memoization technique: O(N) as it looks at already calculated values -> constant amount of work N times.
     */
    private static int fib(int n, int[] memo) {
        if (n <= 0) return 0;
        else if (n == 1) return 1;
        else if (memo[n] > 0) return memo[n];

         memo[n] = fib(n - 1, memo) + fib(n - 2, memo);

        return memo[n];
    }

}
