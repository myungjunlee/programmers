import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum;
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int truck_weight : truck_weights) {
            
            if ((queue.size() < bridge_length) && (sum + truck_weight <= weight) {
                    queue.offer(truck_weight);
                    sum += truck_weight;
                    answer += 1;
            } else if ((queue.size() == bridge_length) || (sum + truck_weight > weight)) {
                while(!queue.isEmpty) {
                    sum -= queue.remove();
                    if (sum + truck_weight <= weight) {
                        queue.offer(truck_weight);
                        sum += truck_weight;
                        answer += 1;
                        break;
                    }
                }
            }
            
            if (queue.size() == 0) {
                queue.offer(truck_weight);
                sum = truck_weight;
                answer += bridge_length;
            }

            // token regeneration
        }
        
        answer += 1
        
        return answer;
    }
}