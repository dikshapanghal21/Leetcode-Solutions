class Solution {
public:
    int maxActiveSectionsAfterTrade(string s) {
        int n = s.size();

        // Add '1' at both ends
        string t = "1" + s + "1";

        int initialOnes = 0;

        for (char ch : s) {
            if (ch == '1') {
                initialOnes++;
            }
        }

        int ans = initialOnes;

        // Store lengths of consecutive groups
        vector<pair<char, int>> groups;

        for (int i = 0; i < t.size(); ) {
            int j = i;

            while (j < t.size() && t[j] == t[i]) {
                j++;
            }

            groups.push_back({t[i], j - i});
            i = j;
        }

        // Look for:
        // 0-block + 1-block + 0-block
        for (int i = 1; i + 1 < groups.size(); i++) {
            if (groups[i].first == '1' &&
                groups[i - 1].first == '0' &&
                groups[i + 1].first == '0') {

                int leftZero = groups[i - 1].second;
                int rightZero = groups[i + 1].second;

                ans = max(ans, initialOnes + leftZero + rightZero);
            }
        }

        return ans;
    }
};