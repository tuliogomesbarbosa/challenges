import java.util.Arrays;

/**
 * Classic merge sort
 * Complexity:
 *  Time -> T(n) = 2T(n/2) [time to sort sub-arrays] + O(n) [time to merge entire array] -> O(nLog(n))
 *  Space -> O(n) -> temporary array in every recursive call
 */
public class ArrayMergeSort {

    public static void mergeSort(int[] arr) {
        int n = arr.length;

        if (n < 2) {
            return;
        }

        int mid = n / 2;
        int[] l = new int[mid], r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
        }

        for (int i = mid; i < n; i++) {
            r[i - mid] = arr[i];
        }

        mergeSort(l);
        mergeSort(r);

        merge(arr, l, r);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        var arr = new int[]{10, 6, 8, 5, 7, 3, 4};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
