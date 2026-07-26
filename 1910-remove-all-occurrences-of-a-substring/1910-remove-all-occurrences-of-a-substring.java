class Solution {
    public String removeOccurrences(String s, String part) {

        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {

            sb.append(ch);

            // Check if the current ending matches part
            if (sb.length() >= part.length() &&
                endsWith(sb, part)) {

                sb.delete(
                    sb.length() - part.length(),
                    sb.length()
                );
            }
        }

        return sb.toString();
    }

    private boolean endsWith(
        StringBuilder sb,
        String part
    ) {

        int start = sb.length() - part.length();

        for (int i = 0; i < part.length(); i++) {

            if (sb.charAt(start + i) != part.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}