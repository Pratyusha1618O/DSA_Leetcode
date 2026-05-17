class Solution {
    public boolean canReach(int[] arr, int start) {
        
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int curr = q.poll();

            // already visited
            if(arr[curr] < 0) {
                continue;
            }

            //reached the target index?
            if(arr[curr] == 0){
                return true;
            }

            // Try both directions (Like BFS, add 2 child in queue)
            if(curr + arr[curr] < arr.length){
                q.add(curr + arr[curr]);
            }

            if(curr - arr[curr] >= 0){
                q.add(curr - arr[curr]);
            }

            //mark this element visited
            arr[curr] = -arr[curr];
        }
        
        return false;
    }
}