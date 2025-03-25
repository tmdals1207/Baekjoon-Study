class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int idx = 1;
        int range = 2 * w + 1;
        
        for (int station : stations) {
            int left = station - w;
            
            if (left > idx) {
                int gap = left - idx;
                answer += (gap + range - 1) / range;
            }
            idx = station + w + 1;
        }
        
        if (idx <= n) {
            int gap = n - idx + 1;
            answer += (gap + range - 1) / range;
        }

        return answer;
    }
}