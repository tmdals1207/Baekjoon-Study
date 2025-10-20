import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int sum = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            sum ++;
        }
        sum = sum / 2;
        
        if (sum >= map.size()) {
            return map.size();
        }
        else {
            return sum;
        }
    }
}