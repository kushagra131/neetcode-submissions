class Solution {
    public int[] replaceElements(int[] arr) {
        // iterate array in reverse order.
        // set rigth_max = -1
        // have a new_max = max(old_max, array at i)

        int right_max = -1;
        for(int i = arr.length - 1; i >= 0; i--) {
            int curr = Math.max(right_max, arr[i]);
            arr[i] = right_max;
            right_max = curr;
        }
        return arr;
    }
}