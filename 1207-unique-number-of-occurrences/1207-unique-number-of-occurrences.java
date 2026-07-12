class Solution {
    public boolean uniqueOccurrences(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        HashSet<Integer> set = new HashSet<>();

        // Check if any frequency repeats
        for (int freq : map.values()) {

            if (set.contains(freq)) {
                return false;
            }

            set.add(freq);
        }

        return true;
    }
}