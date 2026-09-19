class Solution {
    public boolean isRobotBounded(String instructions) {
        
        int[][] directions = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };

        int x = 0;
        int y = 0;
        int direction = 0; 

        for (char ch : instructions.toCharArray()) {

            if (ch == 'G') {
                x += directions[direction][0];
                y += directions[direction][1];
            }
            else if (ch == 'L') {
                direction = (direction + 3) % 4;
            }
            else if (ch == 'R') {
                direction = (direction + 1) % 4;
            }
        }

        return (x == 0 && y == 0) || direction != 0;
    }
}