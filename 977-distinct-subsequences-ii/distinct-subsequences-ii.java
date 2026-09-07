class Solution {
    public int distinctSubseqII(String s) {
        
        long MOD = 1000000007;

        // end[i] = number of distinct subsequences
        // ending with character i
        long[] end = new long[26]; //26 alphabets

        //total distinct non empty subsequences
        long total = 0;

        for(char ch: s.toCharArray()){
            int index = ch - 'a';

            // New subsequences ending with ch:
            // 1. ch itself
            // 2. ch added to every existing subsequence
            long newEnd = (total + 1) % MOD;

            // Remove old subsequences that ended with ch
            // because they are duplicates
            total = (total + newEnd - end[index] + MOD) % MOD;

            // Update the count for this ending character
            end[index] = newEnd;

        }

        return (int) total;

    }
}