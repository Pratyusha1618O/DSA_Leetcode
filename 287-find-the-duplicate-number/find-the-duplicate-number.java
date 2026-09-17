class Solution {
    public int findDuplicate(int[] nums) {

        int ans = 0;

        for(int i=0; i<nums.length; i++){
            int elem = nums[i];
            elem = Math.abs(elem);

            if(nums[elem] > 0){
                nums[elem] = -nums[elem];
            }
            else{
                ans = elem;
                break;
            }
        }

        for(int i=0; i<nums.length; i++){
            nums[i] = Math.abs(nums[i]);
        }

        return ans;
    }
}