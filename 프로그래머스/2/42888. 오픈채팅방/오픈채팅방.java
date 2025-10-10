import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> nameById = new HashMap<>();
        List<String[]> actions = new ArrayList<>();

        for (String input : record) {
            String[] parts = input.split(" ");
            String order = parts[0];
            String id = parts[1];

            if ("Enter".equals(order)) {
                String name = parts[2];
                nameById.put(id, name);
                actions.add(new String[] {"Enter", id});
            } 
            else if ("Leave".equals(order)) {
                actions.add(new String[] {"Leave", id});
            } 
            else {
                String name = parts[2];
                nameById.put(id, name);
            }
        }

        String[] answer = new String[actions.size()];
        int i = 0;
        
        for (String[] act : actions) {
            String type = act[0];
            String uid = act[1];
            String name = nameById.get(uid);
            
            if ("Enter".equals(type)) {
                answer[i++] = name + "님이 들어왔습니다.";
            } 
            else {
                answer[i++] = name + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}
