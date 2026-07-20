class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();

        int[] total = new int[3];

        for (char ch : s.toCharArray()) {
            total[ch - 'a']++;
        }

        // Impossible to take k of each character
        if (total[0] < k || total[1] < k || total[2] < k) {
            return -1;
        }

        int[] window = new int[3];
        int left = 0;
        int maxWindow = 0;

        for (int right = 0; right < n; right++) {
            window[s.charAt(right) - 'a']++;

            while (window[0] > total[0] - k ||
                   window[1] > total[1] - k ||
                   window[2] > total[2] - k) {

                window[s.charAt(left) - 'a']--;
                left++;
            }

            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        return n - maxWindow;
    }
}