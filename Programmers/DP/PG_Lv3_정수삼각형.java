// return: 거쳐간 숫자의 합이 가장 큰 경우를 찾아보려고 합니다

class Solution {
    
    public int solution(int[][] triangle) {
        
        for(int i=triangle.length-2; i>=0; i--){
            for(int j=0; j<triangle[i].length; j++){
                triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
            }
        }
            
        return triangle[0][0];
    }
}