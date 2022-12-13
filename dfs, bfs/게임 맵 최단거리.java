import java.util.*;

class Solution {
    int[][] maps, visited;
    int row_length, col_length;
    int[] distance_row = {0,0,1,-1};
    int[] distance_col = {1,-1,0,0};
    
    void bfs() {
        visited[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        
        while (!queue.isEmpty()) {
            int curr[] = queue.remove();
            int current_row = curr[0];
            int current_col = curr[1];
            
            for (int i = 0; i < 4; i++) {
                int next_row = current_row + distance_row[i];
                int next_col = current_col + distance_col[i];
                
                if (next_row >= row_length || next_col < 0 || next_col >= col_length || next_row < 0) continue;
                if (visited[next_row][next_col] == 0 && maps[next_row][next_col] == 1) {
                    visited[next_row][next_col] = visited[current_row][current_col] + 1;
                    queue.add(new int[]{next_row, next_col});
                }
            }
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        row_length = maps.length;
        col_length = maps[0].length;
        visited = new int[row_length][col_length];
        this.maps = maps;
        
        bfs();
        answer = visited[row_length - 1][col_length - 1] == 0 ? - 1 : visited[row_length - 1][col_length - 1];
        
        return answer;
    }
}