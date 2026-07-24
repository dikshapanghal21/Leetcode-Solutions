class Solution {
    public void nextPermutation(int[] nums) {

        int n = nums.length;

        // Step 1: Find pivot
        int pivot = n - 2;

        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) {
            pivot--;
        }

        // Step 2: Find the next greater element
        if (pivot >= 0) {

            int j = n - 1;

            while (nums[j] <= nums[pivot]) {
                j--;
            }

            // Swap pivot and j
            swap(nums, pivot, j);
        }

        // Step 3: Reverse the suffix
        reverse(nums, pivot + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int left, int right) {

        while (left < right) {

            swap(nums, left, right);

            left++;
            right--;
        }
    }
}