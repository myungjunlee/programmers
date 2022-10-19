import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int price;
        int time;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> remain = new Stack<>();
        
        for (int i=0;i<prices.length;i++) {
			// 끝까지 가격이 떨어지지 않는 경우로 배열 값 미리 할당
            answer[i] = prices.length-1-i;
            price = prices[i];
            time = 0;
			// 가격이 떨어지는 경우만 배열 값 변경
            while(true) {
				// 현재 가격 대비 같거나 높은 경우
                if (stack.isEmpty() || stack.peek() <= price) {
                    while (!remain.isEmpty()) {
                        stack.push(remain.pop());
                    }
                    stack.push(price);
                    break;
				// 현재 가격 대비 낮은 경우
                } else {
                    time++;
                    remain.push(stack.pop());
					// 현재 시점으로부터 해당하는 배열 시점
                    if (answer[i-time] > time) {
                        answer[i-time] = time;
                    }
                }
            }
        }
        
        return answer;
    }
}