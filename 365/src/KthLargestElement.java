import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Usually streaming problems are solved with a  min-heap (priority queue)
 */
public class KthLargestElement {
    private Queue<Integer> pq = new PriorityQueue<>();
    private int k;

    public KthLargestElement(int k, int[] nums) {
        this.k = k;

        for (int i = 0; i < Math.min(k, nums.length); i++) {
            pq.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            pq.add(nums[i]);
            pq.poll();
        }
    }

    private int add(int val) {
        pq.add(val);

        if (pq.size() > k) {
            pq.poll();
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        KthLargestElement kle = new KthLargestElement(3, new int[]{4, 5, 8, 2});
        System.out.println(kle.add(3));
        System.out.println(kle.add(5));
        System.out.println(kle.add(10));
        System.out.println(kle.add(9));
        System.out.println(kle.add(4));
    }
}
