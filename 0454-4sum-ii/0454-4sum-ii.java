class Solution {
    public int fourSumCount(int[] nums1, int[] nums2,
                            int[] nums3, int[] nums4) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Store sums of nums1 and nums2
        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;

        // Find complementary sums
        for (int c : nums3) {
            for (int d : nums4) {

                int sum = c + d;

                count += map.getOrDefault(-sum, 0);
            }
        }

        return count;
    }
}