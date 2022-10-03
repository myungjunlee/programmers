import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        // 1. 우선 오름차순 정렬
        Arrays.sort(citations);

        // 2. 'citations[i]'와 'citations.length-i' 중 작은 쪽이 h값
        for(int i = citations.length-1; i > -1; i--){
            int smaller = Math.min(citations[i], citations.length-i);

            // 최댓값이 갱신되지 않았을 때 중지
            if (smaller >= answer)
                answer = smaller;
            else
                break;
        }

        return answer;
    }
}