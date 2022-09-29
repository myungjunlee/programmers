import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // 1. Hash map을 만든다 (participant)
        HashMap<String, Integer> map = new HashMap<>();
        
        
        for (String player : participant) 
            map.put(player, map.getOrDefault(player, 0) + 1);
        
        // 2. Hash map을 뺀다 (completion)
        for (String player : completion) 
            map.put(player, map.get(player) - 1);

        // 3. value가 0이 아닌 주자를 찾는다
        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();

        while(iter.hasNext()){
            Map.Entry<String, Integer> entry = iter.next();
            if (entry.getValue() != 0){
                answer = entry.getKey();
                break;
            }
        }
        
        return answer;
    }
}