import java.util.*;
import java.io.*;

// 유저가 신고한 사람을 저장해 두고 만약 이용정지를 당하면 메일을 받을 HashMap<String, HashSet<String>>
// 신고를 당할 때마다 Value를 증가시켜서 K가 넘는지 확인할 HashMap
// 신고를 K번 이상 당해서 정지당한 사람을 저장할 HashSet

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 유저가 신고한 사람들을 저장한 HashMap
        HashMap<String, HashSet<String>> reportedMap = new HashMap<String, HashSet<String>>();
        // 유저가 신고당한 횟수를 저장한 HashMap
        HashMap<String, Integer> reportedCount = new HashMap<String, Integer>();
        
        Set<String> bannedSet = new HashSet<String>();
        
        for (String id : id_list) {
            reportedMap.put(id, new HashSet<String>());
            reportedCount.put(id, 0);
        }
        
        for (String input : report) {
            StringTokenizer st = new StringTokenizer(input);
            String s1 = st.nextToken(); // 신고한 사람
            String s2 = st.nextToken(); // 신고 당한 사람
            
            // 유저가 신고한 사람들을 저장한 HashMap안의 Value값인 HashSet 추출.
            HashSet<String> reports = reportedMap.get(s1);
            // 해당 HashSet을 HashMap안의 Value로 다시 저장.
            reportedMap.put(s1, reports);
            
            if(!reports.contains(s2)) {
                reports.add(s2);
                reportedCount.put(s2, reportedCount.get(s2) + 1);
                
                if(reportedCount.get(s2)>=k) {
                    bannedSet.add(s2);
                }
            }
        } 
        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            int cnt = 0;
            
            for (String s : reportedMap.get(id)) {
                if(bannedSet.contains(s)) {
                    cnt++;
                }
            }
            answer[i] = cnt;
            
        }
        
        
    
        
        return answer;
    }
}