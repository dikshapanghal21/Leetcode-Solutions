class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        // Total number of 1s
        int k = 0;
        for (int num : nums) {
            k += num;
        }

        // If 0 or all elements are 1, no swaps needed
        if (k == 0 || k == n) {
            return 0;
        }

        // Count 1s in the first window of size k
        int currentOnes = 0;

        for (int i = 0; i < k; i++) {
            currentOnes += nums[i];
        }

        int maxOnes = currentOnes;

        // Sliding window over circular array
        for (int i = k; i < n + k; i++) {
            // Add new element
            currentOnes += nums[i % n];

            // Remove old element
            currentOnes -= nums[(i - k) % n];

            maxOnes = Math.max(maxOnes, currentOnes);
        }

        // Zeros inside the best window = swaps required
        return k - maxOnes;
    }
}