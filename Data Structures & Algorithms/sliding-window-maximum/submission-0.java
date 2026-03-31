class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return new int[0];
        int[] result = new int[n - k + 1];
        // Deque will store indices of elements in decreasing order of their values
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // 1. Remove indices that are out of the current window range
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // 2. Remove indices of all elements smaller than the current element
            // because they will never be the maximum for any future window
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            // 3. The first element in deque is the index of the maximum element for the current window
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}