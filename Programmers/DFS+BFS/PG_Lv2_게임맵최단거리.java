import java.util.Queue;
import java.util.LinkedList;

class Solution {
    static boolean[][] visited;
    static final int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static final int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        visited = new boolean[maps.length][maps[0].length];
        
        int answer = BFS(maps, n, m);
        return answer;

    }

    // 1. BFS 탐색 (최단거리)
    // 2. 상, 하, 좌, 우 길로 가기
    // 3. 갈 수 있으면(1) Queue 에 저장 / 없으면 Queue에 저장 x
    // 4. 지나온 길에 지나온 칸 개수 저장 (다시 돌아갈 일 없으니까 괜찮음)

    private int BFS(int[][] maps, int n, int m){
        Queue<int[]> q = new LinkedList<>();
        visited[0][0] = true; // 시작 위치 (0,0)
        q.add(new int[]{0,0});

        while(!q.isEmpty()){
            int[] loc = q.poll();
            
            // 도착점 도달: 상대 팀 진영에 도착한 경우
            if(loc[0] == n-1 && loc[1] == m-1){
                return maps[loc[0]][loc[1]];
            }
            
            for(int i=0; i<4; i++){ // 상, 하, 좌, 우 탐색
                int x = loc[0] + dx[i];
                int y = loc[1] + dy[i];
                
                // x,y가 범위 내면서 + 갈 수 있는 칸(1)이고 + 방문하지 않은 경우 -> 큐에 넣기
                if(x >= 0 && y >= 0 && x < n && y < m && maps[x][y] > 0 && !visited[x][y]){
                    maps[x][y] += maps[loc[0]][loc[1]];
                    visited[x][y] = true;
                    q.add(new int[]{x, y});
                }
            }
        }

        return -1;
    }

}