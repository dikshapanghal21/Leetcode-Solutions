class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        int windowSize = 2 * k + 1;

        // Not enough elements to form even one window
        if (windowSize > n) {
            return ans;
        }

        long sum = 0;

        // First window
        for (int i = 0; i < windowSize; i++) {
            sum += nums[i];
        }

        ans[k] = (int) (sum / windowSize);

        // Slide the window
        for (int i = windowSize; i < n; i++) {
            sum += nums[i];
            sum -= nums[i - windowSize];

            ans[i - k] = (int) (sum / windowSize);
        }

        return ans;
    }
}