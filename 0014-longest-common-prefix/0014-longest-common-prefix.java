class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        String first = strs[0];

        for (int i = 0; i < first.length(); i++) {

            char current = first.charAt(i);

            for (int j = 1; j < strs.length; j++) {

                // String ended OR character is different
                if (i >= strs[j].length() ||
                    strs[j].charAt(i) != current) {

                    return first.substring(0, i);
                }
            }
        }

        // Entire first string is common
        return first;
    }
}