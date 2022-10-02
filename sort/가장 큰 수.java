import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {

        String answer = "";

        String[] nums = new String[numbers.length];

        // 1. numbers 배열 문자열로 변환하여 nums 배열에 복사
        for (int i=0; i<nums.length; i++) 
            nums[i] = numbers[i] + "";

        // 2. nums 배열 내림차순 정렬
        Arrays.sort(nums, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        // 3. answer 문자열에 nums 배열 요소들 차례대로 붙임
        for (int i=0; i<numbers.length; i++)
            answer += nums[i];

        // 4. answer 첫 번째 문자가 0인 경우 0 반환하도록 예외처리
        return answer.charAt(0) == '0' ? "0" : answer;
    }
}