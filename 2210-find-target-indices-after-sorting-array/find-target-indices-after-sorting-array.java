class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        
        int index = 0;
        int tcount = 0;

        // Arrays.sort(nums);

        for(int elem : nums){
            if(elem == target){
                tcount++;
            }
            else if(elem < target){
                index++;
            }
        }

        List<Integer> ans = new ArrayList<>();

        while(tcount > 0){
            ans.add(index);
            index++;
            tcount--;
        }

        return ans;
    }
}