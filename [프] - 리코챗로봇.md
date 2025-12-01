import java.util.*;

class Solution {
    
    static int y;
    static int x;
    // [상하좌우][y][x]
    static boolean[][][] visited;
    static char[][] pan;
    // 정답
    static int answer = Integer.MAX_VALUE;
    // 상하좌우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    
    public int solution(String[] board) {
        pan = new char[board.length][board[0].length()];
        for(int i=0; i<pan.length; i++){
            pan[i] = board[i].toCharArray();
        }
        y = pan.length;
        x = pan[0].length;
        visited = new boolean[4][y][x];

        outer: for(int i=0; i<y; i++){
            for(int j=0; j<x; j++){
                if(pan[i][j] == 'R'){
                    bfs(i, j);
                    break outer;
                }
            }
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    public static void bfs(int cy, int cx){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{cy, cx, 0});
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int ty = temp[0];
            int tx = temp[1];
            int cnt = temp[2];
            for(int i=0; i<4; i++){
                int ndy = dy[i] + ty;
                int ndx = dx[i] + tx;
                if(ndy < 0 || ndy >= y || ndx < 0 || ndx >= x || pan[ndy][ndx] == 'D'){
                    continue;
                }
                if(visited[i][ndy][ndx]) continue;
                
                visited[i][ndy][ndx] = true;
                
                int[] result = move(ndy, ndx, i);
                
                if(pan[result[0]][result[1]] == 'G'){
                    answer = Math.min(answer, cnt + 1);
                    continue;
                }
                
                q.add(new int[]{result[0], result[1], cnt + 1});
            }
        }
    }
    
    public static int[] move(int ndy, int ndx, int dir){
        int[] result = new int[2];
        // 상
        if(dir == 0){
            while(true){
                ndy++;
                if(ndy >= y || pan[ndy][ndx] == 'D'){
                    result[0] = ndy - 1;
                    result[1] = ndx;
                    return result;
                }
            }
        }
        // 하
        else if(dir == 1){
            while(true){
                ndy--;
                if(ndy < 0 || pan[ndy][ndx] == 'D'){
                    result[0] = ndy + 1;
                    result[1] = ndx;
                    return result;
                }
            }
        }
        // 좌
        else if(dir == 2){
            while(true){
                ndx--;
                if(ndx < 0 || pan[ndy][ndx] == 'D'){
                    result[0] = ndy;
                    result[1] = ndx + 1;
                    return result;
                }
            }
        }        
        // 우
        else {
            while(true){
                ndx++;
                if(ndx >= x || pan[ndy][ndx] == 'D'){
                    result[0] = ndy;
                    result[1] = ndx - 1;
                    return result;
                }
            }
        }
    }
}