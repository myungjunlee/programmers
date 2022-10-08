import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> answerList = new ArrayList<>();
        
        for (int i=0;i<progresses.length;i++) {
            
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int day = (int) Math.ceil(remain);
            
            if (!queue.isEmpty() && (day > queue.peek())) {
                answerList.add(queue.size());
                queue.clear();
            }
            queue.offer(day);
        }

        answerList.add(queue.size());
                
        answer = new int[answerList.size()];

        for(int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i).intValue();
        }
                
        return answer;
    }
}