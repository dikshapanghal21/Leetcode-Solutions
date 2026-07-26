class Solution {
    public int compress(char[] chars) {

        int read = 0;
        int write = 0;

        while (read < chars.length) {

            // Current character
            char current = chars[read];

            // Count consecutive occurrences
            int count = 0;

            while (read < chars.length &&
                   chars[read] == current) {

                read++;
                count++;
            }

            // Write the character
            chars[write++] = current;

            // Write count if greater than 1
            if (count > 1) {

                String countString = String.valueOf(count);

                for (char digit : countString.toCharArray()) {
                    chars[write++] = digit;
                }
            }
        }

        return write;
    }
}