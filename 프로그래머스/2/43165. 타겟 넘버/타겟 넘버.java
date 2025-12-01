import java.util.*;

class Solution {
    
    static int target, size, answer;
    static int[] numbers;
    
    public int solution(int[] input_numbers, int input_target) {
        
        target = input_target;
        size = input_numbers.length;
        answer = 0;
        numbers = input_numbers;
        
        dfs(0, 0);
        
        return answer;
    }
    
    public void dfs(int idx, int sum) {
        
        if (idx == size) {
            if (sum == target) {
                answer ++;
            }
            return;
        }
        
        dfs(idx + 1, sum + numbers[idx]);
        dfs(idx + 1, sum - numbers[idx]);
    }
}