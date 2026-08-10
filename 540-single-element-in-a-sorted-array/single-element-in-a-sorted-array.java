class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        else if( nums[0] != nums[1]){
            return nums[0];
        }
        else if(nums[nums.length - 1] != nums[nums.length-2]){
            return nums[nums.length - 1];
        }


        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid = (low+high) / 2;

            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                return nums[mid];
            }
            else if(mid % 2 != 0){ //if mid index is odd
                if(nums[mid-1] == nums[mid]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
            else{ // if mid index is even
                if(nums[mid] == nums[mid+1]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }

        return -1;
    }
}