import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < phone_book.length; i++) {
            list.add(phone_book[i].replace(" ", ""));
        }
        Collections.sort(list);
        
        for (int j = 0; j < list.size() - 1; j++) {
            if(list.get(j + 1).startsWith(list.get(j))) {
                return false;
            }
        }
        
        return answer;
    }
}