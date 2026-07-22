class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        int totalSum = 0;

        // Calculate total sum
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < n; i++) {

            // Right sum excludes nums[i]
            int rightSum = totalSum - leftSum - nums[i];

            answer[i] = Math.abs(leftSum - rightSum);

            // Add current element to left sum
            leftSum += nums[i];
        }

        return answer;
    }
}