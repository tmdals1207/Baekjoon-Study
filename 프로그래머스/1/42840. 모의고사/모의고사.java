import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        
        int[] ans1 = {1, 2, 3, 4, 5};
        int[] ans2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] ans3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        
        for (int i = 0; i < answers.length; i++) {
            if (ans1[i % 5] == answers[i]) {
                sum1 ++;
            }
            if (ans2[i % 8] == answers[i]) {
                sum2 ++;
            }
            if (ans3[i % 10] == answers[i]) {
                sum3 ++;
            }
        }
        
        int max = Math.max(sum1, Math.max(sum2, sum3));

        List<Integer> winners = new ArrayList<>();
        
        if (sum1 == max) winners.add(1);
        if (sum2 == max) winners.add(2);
        if (sum3 == max) winners.add(3);

        answer = new int[winners.size()];
        
        for (int i = 0; i < winners.size(); i++) {
            answer[i] = winners.get(i);
        }
        
        return answer;
    }
}