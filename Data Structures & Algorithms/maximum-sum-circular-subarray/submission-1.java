class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currMax = 0, currMin = 0;
        int globMax = nums[0], globMin = nums[0];
        int total = 0;

        for(int i=0;i<nums.length;i++){
            currMax = Math.max(currMax+nums[i], nums[i]);
            currMin = Math.min(currMin+nums[i], nums[i]);
            total += nums[i];

            globMax = Math.max(globMax, currMax);
            globMin = Math.min(globMin, currMin);
        }

        return globMax < 0 ? globMax : Math.max(globMax, total - globMin);
        
    }
}