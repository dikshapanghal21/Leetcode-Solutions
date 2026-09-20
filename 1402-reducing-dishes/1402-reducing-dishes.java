import java.util.Arrays;

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int suffixSum = 0;
        int result = 0;

        // Start from the largest satisfaction value
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            suffixSum += satisfaction[i];

            // If adding this dish increases the total,
            // include it.
            if (suffixSum > 0) {
                result += suffixSum;
            } else {
                break;
            }
        }

        return result;
    }
}