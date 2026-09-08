class Solution {
    public int countCommas(int n) {
        

        int count = 0;
        int copy = n;

        // No of digits
        while(copy>0){
            copy = copy/10;
            count++;
        }

        if(count <= 3){
            return 0;
        }
        else{
            int nums = 0;
            int totalComma = 0;

            for(int i=1000; i<=n; i++){

                int j = i;
                int digCount = 0;
                while(j>0){
                    j = j / 10;
                    digCount++;
                }
                int comma = (digCount - 1) / 3;
                totalComma += comma;
                
            }

            return totalComma;
        }


    }
}