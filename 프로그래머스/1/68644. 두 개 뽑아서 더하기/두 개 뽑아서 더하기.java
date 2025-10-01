import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        int arrSize = numbers.length;
        
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < arrSize; i++) {
            for (int j = i+1; j < arrSize; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        int setSize = set.size();
        answer = new int[setSize];
        int idx = 0;
        
        for (int num : set) {
            answer[idx++] = num;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}