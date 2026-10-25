class Solution {
    public int[] replaceElements(int[] arr) {
        // iterate array in reverse order.
        // set rigth_max = -1
        // have a new_max = max(old_max, array at i)

        int old_max = -1;
        for(int i = arr.length - 1; i >= 0; i--) {
            int new_max = Math.max(old_max, arr[i]);
            arr[i] = old_max;
            old_max = new_max;
        }
        return arr;
    }
}