class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long MOD = 1_000_000_007L;

        int[] bitCount = new int[31];

        // Step 1: Count how many numbers contain each bit
        for (int num : nums) {
            for (int bit = 0; bit < 31; bit++) {
                if ((num & (1 << bit)) != 0) {
                    bitCount[bit]++;
                }
            }
        }

        long answer = 0;

        // Step 2: Construct k maximum numbers
        for (int i = 0; i < k; i++) {
            long num = 0;

            for (int bit = 0; bit < 31; bit++) {
                if (bitCount[bit] > 0) {
                    num |= (1L << bit);
                    bitCount[bit]--;
                }
            }

            // Step 3: Add the square modulo MOD
            answer = (answer + num * num) % MOD;
        }

        return (int) answer;
    }
}