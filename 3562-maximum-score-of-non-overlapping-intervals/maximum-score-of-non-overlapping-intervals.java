class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        // Store: [left, right, weight, originalIndex]
        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        // Sort by starting position
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[3], b[3]);
        });

        // next[i] = first interval that starts after arr[i].right
        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (arr[mid][0] > arr[i][1]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            next[i] = left;
        }

        // dp[i][count] = best score from i onward
        // when we can still choose count intervals
        long[][] dp = new long[n + 1][5];

        // chosen[i][count] = lexicographically smallest list
        // achieving dp[i][count]
        List<Integer>[][] chosen = new ArrayList[n + 1][5];

        for (int i = n - 1; i >= 0; i--) {

            for (int count = 1; count <= 4; count++) {

                // Option 1: skip current interval
                long skipScore = dp[i + 1][count];
                List<Integer> skipList = chosen[i + 1][count];

                // Option 2: take current interval
                long takeScore =
                        arr[i][2] + dp[next[i]][count - 1];

                List<Integer> takeList =
                        new ArrayList<>();

                takeList.add(arr[i][3]);

                if (chosen[next[i]][count - 1] != null) {
                    takeList.addAll(chosen[next[i]][count - 1]);
                }

                Collections.sort(takeList);

                // Choose the better option
                if (takeScore > skipScore) {
                    dp[i][count] = takeScore;
                    chosen[i][count] = takeList;

                } else if (takeScore < skipScore) {
                    dp[i][count] = skipScore;
                    chosen[i][count] = skipList;

                } else {
                    // Same score → lexicographically smaller list
                    if (isLexicographicallySmaller(takeList, skipList)) {
                        dp[i][count] = takeScore;
                        chosen[i][count] = takeList;
                    } else {
                        dp[i][count] = skipScore;
                        chosen[i][count] = skipList;
                    }
                }
            }
        }

        List<Integer> answer = chosen[0][4];

        if (answer == null) {
            return new int[0];
        }

        Collections.sort(answer);

        int[] result = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    private boolean isLexicographicallySmaller(
            List<Integer> a,
            List<Integer> b) {

        if (b == null) {
            return true;
        }

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}