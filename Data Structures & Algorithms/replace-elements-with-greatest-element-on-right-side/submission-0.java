class Solution {
    public int[] replaceElements(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(i == arr.length - 1)
                arr[i] = -1;
            else {
                int max_element = 0;
                for(int j = i + 1; j < arr.length; j++) {
                    if(max_element < arr[j])
                        max_element = arr[j];
                }
                arr[i] = max_element;
            }
        }
        return arr;
    }
}