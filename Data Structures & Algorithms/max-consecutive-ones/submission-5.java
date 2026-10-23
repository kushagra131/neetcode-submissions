class Solution {
    // Method used for finding Max Consecutive 1's in an Array.
    // Array length is between 1 and 100,000.
    // Each element in array is 0 or 1.
    public int findMaxConsecutiveOnes(int[] nums) {
        // Base condition #1
        if (nums.length < 1 || nums.length > 100000)
            throw new IllegalArgumentException("Array length not in range.");
        
        // use 2 pointers sliding window using left and right starting at 0 index.
        // store length of consecutive 1's in max_length initialized as 0.
        int left = 0, right = 0, max_length = 0;
        while(right < nums.length) {
            int temp_length = 0;
            // Base condition #2
            if (nums[right] != 0 && nums[right] != 1)
                throw new IllegalArgumentException("Array Elements not supported.");
            
            if (nums[right] != 0) {
                right++;
                temp_length = right - left;
            } else {
                right++;
                left = right;
                temp_length = 0;
            }
            if (temp_length > max_length)
                max_length = temp_length;
        }
        return max_length;
    }
}