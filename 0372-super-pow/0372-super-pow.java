class Solution {
    public int superPow(int a, int[] b) {
        int MOD = 1337;
        a %= MOD;

        int result = 1;

        for (int digit : b) {
            result = modPow(result, 10);
            result = (result * modPow(a, digit)) % MOD;
        }

        return result;
    }

    private int modPow(int a, int b) {
        int result = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * a) % 1337;
            }

            a = (a * a) % 1337;
            b /= 2;
        }

        return result;
    }
}