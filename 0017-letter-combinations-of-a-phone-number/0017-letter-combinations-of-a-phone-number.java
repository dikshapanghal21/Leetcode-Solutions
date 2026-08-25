import java.util.*;

class Solution {

    String[] keypad = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        backtrack(digits, 0, new StringBuilder(), result);

        return result;
    }

    private void backtrack(
        String digits,
        int index,
        StringBuilder current,
        List<String> result
    ) {

        // We have chosen one letter for every digit
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get letters for current digit
        String letters = keypad[digits.charAt(index) - '0'];

        // Try every possible letter
        for (char letter : letters.toCharArray()) {

            current.append(letter);

            // Move to next digit
            backtrack(digits, index + 1, current, result);

            // Undo choice
            current.deleteCharAt(current.length() - 1);
        }
    }
}