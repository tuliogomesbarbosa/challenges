package arrays;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>()
        System.out.println(
                Arrays.toString(
                        topKFrequent2(new int[]{4, 4, 1, -1, 2, -1, 2, 3}, 2)
                )
        ); // [-1, 2]
    }

    // Follow up: better than O(n log n) -> single iteration in the array -> O(N) -> custom bucket sort?
    // solution with max heap (priority queue) = O(k * log(n)) => O(log(N)) comes from maxHeap operations such as poll (needs to heapify)
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            frequency.merge(nums[i], 1, Integer::sum);
        }

        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> frequency.get(b) - frequency.get(a)); // reverse order

        maxHeap.addAll(frequency.keySet());

        List<Integer> response = new ArrayList<>();
        while (k > 0) {
            response.add(maxHeap.poll());
            k--;
        }

        return response.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
        }

        // i (count) [0   1       2       3   4   5   6   7]
        // frequency [x [4,1,3] [-1, 2]   []  []  []  []  []
        List<List<Integer>> buckets = zeroValueList(nums.length + 1);
        List<Integer> response = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            buckets.get(entry.getValue()).add(entry.getKey());
        }

        for (int i = buckets.size() - 1; i >= 0; i--) {
            for (int value : buckets.get(i)) {
                response.add(value);
                if (response.size() == k) {
                    return response.stream().mapToInt(Integer::intValue).toArray();
                }
            }
        }
        return new int[0];
    }

    private static List<List<Integer>> zeroValueList(int capacity) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            list.add(i, new ArrayList<>());
        }
        return list;
    }

}
