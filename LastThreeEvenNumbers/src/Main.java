//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int n = 3;
    ArrayList<Integer> result = new ArrayList<>();

    for (int i = arr.length - 1; i >= 0 && result.size() < n; i--) {
        if (arr[i] % 2 == 0) {
            result.add(arr[i]);
        }
    }
    Collections.reverse(result);
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
        res[i] = result.get(i);
        System.out.println(res[i]);
    }

}
