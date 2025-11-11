import java.util.*;

class Solution {
    
    private int toDays(String date) {
        String[] parts = date.split("\\.");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        return year * 12 * 28 + month * 28 + day;
    }
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> termMap = new HashMap<>();
        int todayDays = toDays(today);
        StringTokenizer st;
        
        for (String term : terms) {
            st = new StringTokenizer(term);
            String t = st.nextToken();
            int dur = Integer.parseInt(st.nextToken());
            termMap.put(t, dur);
        }
        
        int idx = 1;
        for (String privacy : privacies) {
            st = new StringTokenizer(privacy);
            
            String dateStr = st.nextToken();
            String type = st.nextToken();
            
            int startDays = toDays(dateStr);
            int termMonths = termMap.get(type);
            
            int expireDays = startDays + termMonths * 28;
            
            if (expireDays <= todayDays) {
                answer.add(idx);
            }
            idx++;
        }
        
        return answer.stream()
                      .mapToInt(Integer::intValue)
                      .toArray();
    }
}