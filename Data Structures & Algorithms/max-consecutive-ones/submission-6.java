class Solution {
    // Method to find max consecutive 1's.
    // Array length is between 1 and 100,00.
    // Each element in Array is either 0 or 1.
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, result = 0;
        for(int num : nums) {
            count = (num == 1) ? count + 1 : 0;
            result = Math.max(result, count);
        }
        return result;
    }
}