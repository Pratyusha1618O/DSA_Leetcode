class Solution {
    public int firstStableIndex(int[] nums, int k) {
        
        int n = nums.length;

        // Minimum elem from i to n-1
        int[] suffixMin = new int[n];
        suffixMin[n-1] = nums[n-1];

        for(int i = n-2; i>=0; i--){
            suffixMin[i] = Math.min(nums[i], suffixMin[i+1]);
        }

        // Prefix maximum
        int max = nums[0];

        for(int i=0; i<n; i++){
            max = Math.max(max, nums[i]);
            int min = suffixMin[i];
            int score = max - min;

            if(score <= k){
                return i;
            }

        }

        return -1;

    }
}