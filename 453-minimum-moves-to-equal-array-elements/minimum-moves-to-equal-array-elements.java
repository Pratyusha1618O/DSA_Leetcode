class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);

        int min = nums[0];
        int sum  = 0 ;

        for(int i=0; i<nums.length; i++){
            sum = sum + nums[i];
        }

        int result = sum - (nums.length * min);

        return result;
        


    }
}