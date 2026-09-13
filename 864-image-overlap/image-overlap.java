class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int answer = 0;

        // Try every possible row shift
        for (int dr = -(n - 1); dr <= n - 1; dr++) {

            // Try every possible column shift
            for (int dc = -(n - 1); dc <= n - 1; dc++) {

                int count = 0;

                // Check every position
                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < n; c++) {

                        int nr = r + dr;
                        int nc = c + dc;

                        // Make sure translated position is inside image
                        if (nr >= 0 && nr < n &&
                            nc >= 0 && nc < n) {

                            if (img1[r][c] == 1 && img2[nr][nc] == 1) {
                                count++;
                            }
                        }
                    }
                }

                answer = Math.max(answer, count);
            }
        }

        return answer;
    }
}