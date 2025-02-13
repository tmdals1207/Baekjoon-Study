class Solution {
    public int[] solution(int brown, int yellow) {
        
        int[] answer = new int[2];
        
        int size = brown * yellow;
        int halfRound = (brown+4)/2; // 가로 + 세로의 크기.
        
        for (int height = 3; height <= (brown-2)/2; height++) {
            if((height-2)*(halfRound-height-2) == yellow) {
                answer[0] = Math.max(height, halfRound-height);
                answer[1] = Math.min(height, halfRound-height);
            }
                
        }
        
        return answer;
    }
}