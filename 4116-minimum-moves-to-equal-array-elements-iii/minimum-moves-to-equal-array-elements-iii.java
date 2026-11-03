class Solution {
    public int minMoves(int[] nums) {
        int sum = 0;
        int max = nums[0];

        for(int num: nums){
            max = Math.max(max, num);
        }

        for(int num: nums){
            sum += max - num;
        }

        
        return sum;
    }
}