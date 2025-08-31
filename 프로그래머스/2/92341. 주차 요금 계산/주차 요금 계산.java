import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int baseTime = fees[0], baseFee = fees[1], unitTime = fees[2], unitFee = fees[3];
        
        Map<String, Integer> in = new HashMap<>();
        Map<String, Integer> total = new HashMap<>();
        
        for (String rec : records) {
            String[] parts = rec.split(" ");
            int t = toMinutes(parts[0]);
            String car = parts[1];
            
            if (parts[2].equals("IN")) {
                in.put(car, t);
            } 
            else {
                int start = in.remove(car);
                total.put(car, total.getOrDefault(car, 0) + (t - start));
            }
        }
        
        int endOfDay = 23 * 60 + 59;
        
        for (Map.Entry<String, Integer> e : in.entrySet()) {
            String car = e.getKey();
            int start = e.getValue();
            total.put(car, total.getOrDefault(car, 0) + (endOfDay - start));
        }
        
        List<String> cars = new ArrayList<>(total.keySet());
        Collections.sort(cars);
        
        int[] answer = new int[cars.size()];
        
        for (int i = 0; i < cars.size(); i++) {
            int time = total.get(cars.get(i));
            int fee = baseFee;
            
            if (time > baseTime) {
                int over = time - baseTime;
                fee += ((over + unitTime - 1) / unitTime) * unitFee;
            }
            answer[i] = fee;
        }
        return answer;
    }

    private int toMinutes(String s) {
        String[] hm = s.split(":");
        return Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
    }
}
