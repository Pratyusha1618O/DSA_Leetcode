class Solution {
    public int firstStableIndex(int[] nums, int k) {
        
        int max = nums[0];
        int min = nums[0];

        for(int i=0; i<nums.length; i++){
            
            for(int j=i; j<nums.length; j++){
                int[] subArray1 = Arrays.copyOfRange(nums, i, nums.length);
                min = Arrays.stream(subArray1).min().getAsInt();
            }
            
            if(i == 0){
                max = nums[0];
            }
            else{
                for(int j=0; j<=i; j++){
                    int[] subArray2 = Arrays.copyOfRange(nums, 0, i+1);
                    max = Arrays.stream(subArray2).max().getAsInt();
                }
            }

            int score = max - min;
            if(score <= k){
                return i;
            }
            
            
        }

        return -1;
    }
}