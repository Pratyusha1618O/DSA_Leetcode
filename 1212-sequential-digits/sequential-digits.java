class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        String digits = "123456789";

        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();

        for (int len = lowLen; len <= highLen; len++) {
            for (int start = 0; start <= 9 - len; start++) {

                String part = digits.substring(start, start + len);
                int num = Integer.parseInt(part);

                if (num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }

        return ans;

    }
}