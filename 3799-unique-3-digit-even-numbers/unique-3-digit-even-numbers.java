class Solution {
    public int totalNumbers(int[] digits) {
        
        boolean[] used = new boolean[1000];
        int count  = 0;

        for(int i = 0; i<digits.length; i++){

            // No leading zeros
            if(digits[i] == 0){
                continue;
            }

            for(int j=0; j<digits.length; j++){
                // Can not use same copy choice
                if(j == i){
                    continue;
                }

                for(int k = 0; k<digits.length; k++){

                    // Can not use the same copy twice
                    if(k == j || k == i){
                        continue;
                    }

                    // Last digit must be even
                    if(digits[k] % 2 != 0){
                        continue;
                    }

                    int number = digits[i]*100 + digits[j]*10 + digits[k];

                    if(!used[number]){
                        used[number] = true;
                        count++;
                    }
                }
            }
        }

        return count;

    }
}