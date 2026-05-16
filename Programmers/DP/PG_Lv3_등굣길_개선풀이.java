/* 
 * 개선 풀이: 이차원 배열의 범위를 m+1, n+1로 늘리고, 
 * 기존에 걸렀던 위쪽/아래쪽이 비어있을 경우를 0으로 만들어 계산하면 바깥 범위라는 영향을 받지 않음
*/

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        int [][] road = new int[m+1][n+1];
        
        for(int i=0; i<puddles.length; i++){
            int row = puddles[i][0];
            int col = puddles[i][1];
            road[row][col] = -1; // 물 웅덩이 표시
        }
        
        road[1][1] = 1; // 집에서 출발하는 값 1로 초기화
        
        for(int row=1; row<=m; row++){
            for(int col=1; col<=n; col++){
                if(road[row][col] == -1){ // 물 웅덩이일 경우 넘어가기
                    road[row][col] = 0;
                    continue;
                }
                
                road[row][col] = (road[row][col] + road[row-1][col]) % 1000000007;
                road[row][col] = (road[row][col] + road[row][col-1]) % 1000000007;
            }
        }
        
        return road[m][n];
    }
}