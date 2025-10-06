import java.util.*;

class Solution {
    public int[] solution(int stageCount, int[] userStages) {
        int userCount = userStages.length;
        int[] stuck = new int[stageCount + 2];
        
        for (int s : userStages) {
            if (s >= 1 && s <= stageCount + 1) {
                stuck[s]++;
            }
        }
        
        double[] failureRate = new double[stageCount + 1];
        int usersRemaining = userCount;
        
        for (int stage = 1; stage <= stageCount; stage++) {
            int fail = stuck[stage];
            failureRate[stage] = (usersRemaining == 0) ? 0.0 : (double) fail / usersRemaining;
            usersRemaining -= fail;
        }
        
        Integer[] order = new Integer[stageCount];
        for (int i = 0; i < stageCount; i++) {
            order[i] = i + 1;
        }
        
        Arrays.sort(order, (a, b) -> {
            int cmp = Double.compare(failureRate[b], failureRate[a]);
            if (cmp != 0) return cmp;
            return Integer.compare(a, b);
        });
        
        int[] answer = new int[stageCount];
        for (int i = 0; i < stageCount; i++) {
            answer[i] = order[i];
        
        }
        return answer;
    }
}