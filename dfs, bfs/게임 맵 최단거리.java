import java.util.*;

class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int solution(int[][] maps) {
        int answer = 0;
        int row = maps.length;
        int col = maps[0].length;
        boolean[][] visited = new boolean[row][col];
        
        dfs(maps, visited, 0, 0, answer);
        
        if (pq.isEmpty()) {
            answer = -1;
        } else {
            answer = pq.poll();
        }
        return answer;
    }
    
    void dfs(int[][] maps, boolean[][] visited, int i, int j, int answer) {
        int row = maps.length;
        int col = maps[0].length;
        visited[i][j] = true;
        boolean[][] pre_visited = new boolean[row][col];
        answer++;
        
        if (i==row-1 && j==col-1) {
            pq.offer(answer);
        } else {
            if (i-1>=0 && maps[i-1][j] == 1 && !visited[i-1][j]) {
                for(int m=0; m<row; m++)
                    for(int n=0;n<col;n++)
                        pre_visited[m][n] = visited[m][n];
                dfs(maps,pre_visited,i-1,j,answer);
            }

            if (j-1>=0 && maps[i][j-1] == 1 && !visited[i][j-1]) {
                for(int m=0; m<row; m++)
                    for(int n=0;n<col;n++)
                        pre_visited[m][n] = visited[m][n];
                dfs(maps,pre_visited,i,j-1,answer);
            }

            if (i+1<row && maps[i+1][j] == 1 && !visited[i+1][j]) {
                for(int m=0; m<row; m++)
                    for(int n=0;n<col;n++)
                        pre_visited[m][n] = visited[m][n];
                dfs(maps,pre_visited,i+1,j,answer);
            }

            if (j+1<col && maps[i][j+1] == 1 && !visited[i][j+1]) {
                for(int m=0; m<row; m++)
                    for(int n=0;n<col;n++)
                        pre_visited[m][n] = visited[m][n];
                dfs(maps,pre_visited,i,j+1,answer);
            }
        }
    }
}