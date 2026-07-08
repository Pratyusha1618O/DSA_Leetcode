class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        int mid  = (low+high)/2;

        while(low <= high){
            if(target < nums[mid]){
                high = mid-1;
            }
            else if(target == nums[mid]){
                return mid;
            }
            else{
                low = mid+1;
            }
            mid  = (low+high)/2;
        }

        return -1;
    }
}