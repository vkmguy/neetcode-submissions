class Solution {
    public int maxSubArray(int[] nums) {
        int i = 0;
        int j = 0;
        int maxSum = nums[0];
        int curSum = 0;
        while(i <= j && j < nums.length){
            curSum+= nums[j];
            maxSum = Math.max(maxSum, curSum);
            if(curSum < 0){
                i = j+1;
                curSum = 0;
            }
            j++;
        }
        return maxSum;
        
    }
}
