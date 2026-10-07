class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (indexDiff <= 0 || valueDiff < 0) {
            return false;
        }

        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];

            // Find smallest number >= num - valueDiff
            Long ceiling = set.ceiling(num - valueDiff);

            if (ceiling != null && ceiling <= num + valueDiff) {
                return true;
            }

            set.add(num);

            // Keep only indexDiff previous elements
            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }

        return false;
    }
}