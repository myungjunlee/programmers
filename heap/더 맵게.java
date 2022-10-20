import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int first_element;
        int second_element;
        int new_element;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for (int element : scoville) {
            queue.offer(element);
        }
        
        while (queue.peek() < K) {
            if (queue.size() == 1) {
                answer = -1;
                break;
            }
            first_element = queue.poll();
            second_element = queue.poll();
            new_element = first_element + second_element*2;
            queue.offer(new_element);
            answer++;
        }
        
        return answer;
    }
}