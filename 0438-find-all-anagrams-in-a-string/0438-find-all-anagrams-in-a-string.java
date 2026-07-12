class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (p.length() > s.length()) {
            return result;
        }

        int[] pCount = new int[26];
        int[] windowCount = new int[26];

        // Build first window
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            windowCount[s.charAt(i) - 'a']++;
        }

        if (matches(pCount, windowCount)) {
            result.add(0);
        }

        // Slide the window
        for (int i = p.length(); i < s.length(); i++) {

            windowCount[s.charAt(i) - 'a']++;

            windowCount[s.charAt(i - p.length()) - 'a']--;

            if (matches(pCount, windowCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }

    private boolean matches(int[] a, int[] b) {

        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }
}