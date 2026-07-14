class Solution {

    HashMap<Integer, Integer> map;
    Random random;
    int size;

    public Solution(int n, int[] blacklist) {

        map = new HashMap<>();
        random = new Random();

        size = n - blacklist.length;

        HashSet<Integer> set = new HashSet<>();

        for (int num : blacklist) {

            if (num >= size)
                set.add(num);
        }

        int last = size;

        for (int num : blacklist) {

            if (num < size) {

                while (set.contains(last))
                    last++;

                map.put(num, last);
                last++;
            }
        }
    }

    public int pick() {

        int x = random.nextInt(size);

        if (map.containsKey(x))
            return map.get(x);

        return x;
    }
}