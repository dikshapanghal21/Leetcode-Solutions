import java.util.*;

class Solution {
    public List<String> invalidTransactions(String[] transactions) {

        int n = transactions.length;

        // Store parsed transaction information
        String[][] data = new String[n][4];

        for (int i = 0; i < n; i++) {

            String[] parts = transactions[i].split(",");

            data[i][0] = parts[0]; // name
            data[i][1] = parts[1]; // time
            data[i][2] = parts[2]; // amount
            data[i][3] = parts[3]; // city
        }

        boolean[] invalid = new boolean[n];

        for (int i = 0; i < n; i++) {

            String name = data[i][0];
            int time = Integer.parseInt(data[i][1]);
            int amount = Integer.parseInt(data[i][2]);
            String city = data[i][3];

            // Condition 1: amount > 1000
            if (amount > 1000) {
                invalid[i] = true;
            }

            // Condition 2: same name,
            // within 60 minutes,
            // different city
            for (int j = 0; j < n; j++) {

                if (i == j) {
                    continue;
                }

                String otherName = data[j][0];
                int otherTime = Integer.parseInt(data[j][1]);
                String otherCity = data[j][3];

                if (name.equals(otherName)
                    && Math.abs(time - otherTime) <= 60
                    && !city.equals(otherCity)) {

                    invalid[i] = true;
                    break;
                }
            }
        }

        // Build answer
        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (invalid[i]) {
                result.add(transactions[i]);
            }
        }

        return result;
    }
}