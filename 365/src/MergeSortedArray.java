import java.util.Arrays;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, k = 0;

        int[] tmp = new int[nums1.length];

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                tmp[k++] = nums1[i++];
            } else {
                tmp[k++] = nums2[j++];
            }
        }

        while (i < m) {
            tmp[k++] = nums1[i++];
        }

        while (j < n) {
            tmp[k++] = nums2[j++];
        }

        for (int l = 0; l < tmp.length; l++) {
            nums1[l] = tmp[l];
        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (m > 0 && n > 0) {
                if (nums1[m - 1] > nums2[n - 1]) {
                    nums1[i] = nums1[m - 1];
                    m--;
                } else {
                    nums1[i] = nums2[n - 1];
                    n--;
                }
            } else if (n > 0) {
                nums1[i] = nums2[n - 1];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;

        merge2(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

}
