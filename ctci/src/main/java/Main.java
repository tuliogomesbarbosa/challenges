import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int[] movies = new int[]{30, 30, 50, 10, 20, 30, 5};
        System.out.println(evaluate(movies, 40));

        var m = Arrays.asList(30, 30, 50, 10, 20, 30, 5);
        reverseArray(m, 0, m.size() - 1);
        System.out.println(m);
    }

    private static boolean evaluate(int[] movies, int flightLength) {
        Arrays.sort(movies);
        System.out.println(Arrays.toString(movies));

        Set<Integer> tmp = new HashSet<>();

        for (int i = 0; i < movies.length; i++) {
            if (tmp.contains(flightLength - movies[i])) {
                return true;
            } else {
                tmp.add(movies[i]);
            }

        }

        return false;
    }

    private static void reverseArray(List<Integer> arr, int start, int end) {
        while (end > start) {
            int tmp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, tmp);
            start++;
            end--;
        }
    }
}
