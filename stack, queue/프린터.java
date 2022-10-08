import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        // 1. priorities 배열과 똑같은 queue를 만들어준다
        for (int priority : priorities)
            queue.offer(priority);
        
        // 2. priorities 배열을 정렬한다
        Arrays.sort(priorities);
        int size = priorities.length-1;
        
        // 3. 큐가 비어있기 전까지 루프 돌린다
        while (!queue.isEmpty()) {
            int head = queue.remove();
            // 3-1. 뽑아낸 헤드 값이 나갈 차례가 아닌 경우
            if (head != priorities[size-answer]) {
                queue.offer(head);
                if (location != 0) {
                    location--;
                } else {
                    location=size-answer;
                }
            // 3-2. 뽑아낸 헤드 값이 나갈 차례인 경우
            } else {
                answer++;
                if (location == 0) {
                    break;
                }
                location--;
            }
        }
            
        return answer;
    }
}