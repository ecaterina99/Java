/**
 * Given an array of integers, find the one that appears an odd number of times.
 * There will always be only one integer that appears an odd number of times.
 * [1,2,2,3,3,3,4,3,3,3,2,2,1] should return 4, because it appears 1 time
 */
void main() {
    int[] a = {1, 2, 2, 3, 3, 3, 4, 3, 3, 3, 2, 2, 1};
    int res = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int j : a) {
        map.put(j, map.getOrDefault(j, 0) + 1);
    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        if (entry.getValue() % 2 == 1) {
            res = entry.getKey();
        }
    }
    System.out.println(res);
}
