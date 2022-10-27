class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(0, 0, numbers, target);
        return answer;
    }

    int dfs(int n, int sum, int[] numbers, int target) {
        if(n == numbers.length) {
            if(sum == target) 
                return 1;
            return 0;
        }

        return dfs(n + 1, sum + numbers[n], numbers, target) + dfs(n + 1, sum - numbers[n], numbers, target);
    }
}