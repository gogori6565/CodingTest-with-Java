// return: 캐릭터가 아이템을 줍기 위해 이동해야 하는 가장 짧은 거리
// 접근: BFS(최단거리)
// 1. 테두리를 어떻게 잡을 것인가?
// 2. BFS(갈 수 있는 방향)을 어떻게 판별할 것인가?

import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
    static int[][] ground;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        // 모든 좌표값은 1이상 50이하로 표현되므로, 이동할 칸 0과 51 고려하여 최종 크기 [52, 52]
        // **모든 좌표 2배 확대하기: 'ㄷ'자에서 발생하는 문제를 해결하기 위해
        ground = new int[104][104];
        visited = new boolean[104][104];
        
        // 1. 지형 그리기 (테두리는 1, 내부는 2)
        createLine(rectangle);
        //System.out.println(Arrays.deepToString(ground));
        
        // 2. BFS 수행 (입력 좌표도 전부 2배 확대해서 넣어줌)
        return BFS(characterX*2, characterY*2, itemX*2, itemY*2); // BFS 수행
    }
    
    // 지형(ground)에 테두리가 될 부분 1 표기
    private void createLine(int[][] rectangle){
        for(int[] rec : rectangle){
            int leftX = rec[0]*2;
            int leftY = rec[1]*2;
            int rightX = rec[2]*2;
            int rightY = rec[3]*2;
            
            // 테두리 및 내부 1처리
            for(int i=leftX; i<=rightX; i++){
                for(int j=leftY; j<=rightY; j++){
                    if(ground[i][j] != 2){ // 다른 직사각형의 내부 부분이면 테두리 처리하면 X
                        ground[i][j] = 1;
                    }
                }
            }
            
            // 내부 2처리
            for(int i=leftX+1; i<rightX; i++){
                for(int j=leftY+1; j<rightY; j++){
                    ground[i][j] = 2;
                }
            }
        }
    }
    
    // item까지 가는 최단경로 찾기
    private int BFS(int characterX, int characterY, int itemX, int itemY){
        Queue<int[]> q = new LinkedList<>();
        // 큐에 {X좌표, Y좌표, 이동거리} 순으로 저장
        q.offer(new int[]{characterX, characterY, 0});
        visited[characterX][characterY] = true;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            // 정지조건: item에 도착한 경우
            if(curr[0] == itemX && curr[1] == itemY){
                return curr[2] / 2; // 2배 확대된 맵에서 구한 거리이므로, 최종 정답은 2로 나누어줌
            }
            
            for(int i=0; i<4; i++){
                int newX = curr[0]+dx[i];
                int newY = curr[1]+dy[i];
                
                // 범위 내라면
                if(newX >= 0 && newX <104 && newY >= 0 && newY < 104){
                    // 방문하지 않았고 && 테두리가 1인 곳만
                    if (!visited[newX][newY] && ground[newX][newY] == 1) {
                        visited[newX][newY] = true;
                        q.offer(new int[]{newX, newY, curr[2] + 1});
                    }
                }
            }
        }
        return -1;
    }
}