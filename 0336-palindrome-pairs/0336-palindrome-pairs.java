class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        // Store reversed words
        for (int i = 0; i < words.length; i++) {
            map.put(new StringBuilder(words[i]).reverse().toString(), i);
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int len = word.length();

            for (int j = 0; j <= len; j++) {
                String left = word.substring(0, j);
                String right = word.substring(j);

                // Case 1: left part is palindrome
                if (isPalindrome(left)) {
                    if (map.containsKey(right) && map.get(right) != i) {
                        result.add(Arrays.asList(map.get(right), i));
                    }
                }

                // Case 2: right part is palindrome
                // j != len avoids duplicate pairs
                if (j != len && isPalindrome(right)) {
                    if (map.containsKey(left) && map.get(left) != i) {
                        result.add(Arrays.asList(i, map.get(left)));
                    }
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}