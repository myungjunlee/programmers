import java.util.*;

public class Solution {
    public int[] solution(int []arr) {

        ArrayList<Integer> tempList = new ArrayList<Integer>();

        // 1. 초기 값 무조건 들어가도록 변수 설정
        int preNum = -1;

        // 2. arr 배열 요소들을 돌며 preNum과 값이 다를 시 골라냄
        for(int num : arr) {
            if(preNum != num)
                tempList.add(num);
            preNum = num;
        }       

        // 3. 리스트를 answer 배열로 복사 후 반환
        int[] answer = new int[tempList.size()];

        for(int i = 0; i < answer.length; i++) {
            answer[i] = tempList.get(i).intValue();
        }

        return answer;
    }
}