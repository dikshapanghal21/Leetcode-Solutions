class Solution {
    public String reverseWords(String s) {

        char[] chars = s.toCharArray();

        int start = 0;

        for (int i = 0; i <= chars.length; i++) {

            // End of word
            if (i == chars.length || chars[i] == ' ') {

                // Reverse current word
                reverse(chars, start, i - 1);

                // Start of next word
                start = i + 1;
            }
        }

        return new String(chars);
    }

    private void reverse(char[] chars, int left, int right) {

        while (left < right) {

            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }
    }
}