import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        if (cacheSize == 0) return 5 * cities.length;

        int cost = 0;
        Map<String, Boolean> cache = new LinkedHashMap<>(cacheSize, 0.75f, true);

        for (String city : cities) {
            String key = city.toLowerCase();
            
            if (cache.containsKey(key)) {
                cost += 1;
                ((LinkedHashMap<String, Boolean>) cache).get(key);
            } else {
                cost += 5;
                if (cache.size() >= cacheSize) {
                    Iterator<String> it = cache.keySet().iterator();
                    if (it.hasNext()) {
                        it.next();
                        it.remove();
                    }
                }
                cache.put(key, true);
            }
        }
        
        return cost;
    }
}
