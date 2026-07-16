class Solution {
public:
    long long gcdSum(vector<int>& nums) {

        int n = nums.size();
        vector<int> prefixGcd(n);

        int mx = 0;

        // Construct prefixGcd
        for (int i = 0; i < n; i++) {
            mx = max(mx, nums[i]);
            prefixGcd[i] = gcd(nums[i], mx);
        }

        // Sort the array
        sort(prefixGcd.begin(), prefixGcd.end());

        long long ans = 0;

        int left = 0;
        int right = n - 1;

        // Pair smallest with largest
        while (left < right) {
            ans += gcd(prefixGcd[left], prefixGcd[right]);
            left++;
            right--;
        }

        return ans;
    }
};