class Solution {
    int solution(int[][] land) {
		int answer = 0;
        int row = land.length;
        int dp[][] = new int[row+1][4];
        
        for (int i = 1; i <= row; i++) {
        	for (int j = 0; j < 4; j++) {
        		for (int k = 0; k < 4; k++) {
        			if (k==j) continue;
        			dp[i][j] = Math.max(dp[i-1][k]+land[i-1][j], dp[i][j]);
        			answer = Math.max(answer, dp[i][j]);
        		}
        	}
        }

        return answer;
    }
}