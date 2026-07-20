class Solution {
    public int countVowelSubstrings(String word) {
        int ans = 0;

        for (int i = 0; i < word.length(); i++) {

            int[] freq = new int[5];
            int distinct = 0;

            for (int j = i; j < word.length(); j++) {

                char ch = word.charAt(j);

                if (!isVowel(ch)) {
                    break;
                }

                int idx = getIndex(ch);

                if (freq[idx] == 0) {
                    distinct++;
                }

                freq[idx]++;

                if (distinct == 5) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i'
            || ch == 'o' || ch == 'u';
    }

    private int getIndex(char ch) {
        switch (ch) {
            case 'a': return 0;
            case 'e': return 1;
            case 'i': return 2;
            case 'o': return 3;
            default: return 4; // 'u'
        }
    }
}