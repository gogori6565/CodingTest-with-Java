package DP;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        int [][] road = new int[m][n];
        
        for(int i=0; i<puddles.length; i++){
            int row = puddles[i][0];
            int col = puddles[i][1];
            road[row-1][col-1] = -1; // 물 웅덩이 표시
        }
        
        road[0][0] = 1; // 집에서 출발하는 값 1로 초기화
        
        for(int row=0; row<m; row++){
            for(int col=0; col<n; col++){
                if(road[row][col] == -1){ // 물 웅덩이일 경우 넘어가기
                    continue;
                }
                if(row >= 0 && col-1 >=0 && row-1 >= 0 && col >=0 
                   && road[row][col-1] != -1 && road[row-1][col] != -1){
                    // 왼쪽/위 두 군데에서 올 수 있는 경우
                    road[row][col] = (road[row][col-1] + road[row-1][col]) % 1000000007;
                    
                } else if(row >= 0 && col-1 >=0 && road[row][col-1] != -1){ 
                    // 왼쪽 칸에서만 올 수 있는 경우
                    road[row][col] = road[row][col-1];
                    
                } else if(row-1 >= 0 && col >=0 && road[row-1][col] != -1){ 
                    // 위쪽 칸에서만 올 수 있는 경우
                    road[row][col] = road[row-1][col];
                }
            }
        }
        
        return road[m-1][n-1];
    }
}