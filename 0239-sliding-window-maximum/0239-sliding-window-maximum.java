class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        int[] ans = new int[n - k + 1];

        Deque<Integer> dq = new LinkedList<>();

        int index = 0;

        for (int right = 0; right < n; right++) {

            // Remove indices outside the window
            while (!dq.isEmpty() && dq.peekFirst() <= right - k) {
                dq.pollFirst();
            }

            // Remove smaller elements
            while (!dq.isEmpty() &&
                   nums[dq.peekLast()] < nums[right]) {

                dq.pollLast();
            }

            dq.offerLast(right);

            // Window formed
            if (right >= k - 1) {

                ans[index++] = nums[dq.peekFirst()];
            }
        }

        return ans;
    }
}