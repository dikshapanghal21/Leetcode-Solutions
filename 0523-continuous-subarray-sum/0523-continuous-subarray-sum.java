class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // remainder 0 occurs before array starts
        map.put(0, -1);

        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {

            prefixSum += nums[i];

            int remainder = prefixSum % k;

            if (map.containsKey(remainder)) {

                if (i - map.get(remainder) >= 2) {
                    return true;
                }

            } else {
                // Store only the first occurrence
                map.put(remainder, i);
            }
        }

        return false;
    }
}