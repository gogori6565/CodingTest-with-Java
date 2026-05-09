// 직사각형 모양의 범위를 여러 번 선택해, 테두리를 시계방향으로 회전
// 결과값: 그 회전에 의해 위치가 바뀐 숫자들 중 가장 작은 숫자들을 순서대로 배열에 담아 return
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        
        int[][] matrix = new int[rows][columns];
        matrix = initMatrix(rows, columns);
        
        int[] result = new int[queries.length];
        int idx = 0;
        
        for(int[] query : queries){
            int x1 = query[0];
            int y1 = query[1];
            int x2 = query[2];
            int y2 = query[3];
            
            int colStart = y1 - 1;
            int colEnd = y2 - 1;
            int rowStart = x1 - 1;
            int rowEnd = x2 - 1;
            
            int min = rotateClockwise(matrix, colStart, colEnd, rowStart, rowEnd);
            result[idx++] = min;
        }
        
        return result;
    }
    
    private int[][] initMatrix(int rows, int columns){
        int[][] matrix = new int[rows][columns];
        int number = 1;
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                matrix[i][j] = number;
                number++;
            }
        }
        
        return matrix;
    }
    
    // 시계 방향 회전
    private int rotateClockwise(int[][] matrix, int colStart, int colEnd, 
                                int rowStart, int rowEnd){
        int temp = matrix[rowStart][colStart];
        int min = temp;
        
        // 왼쪽 -> 위쪽로
        for(int i=rowStart; i<rowEnd; i++){
            matrix[i][colStart] = matrix[i+1][colStart];
            if(min > matrix[i][colStart]) min = matrix[i][colStart];
        }
        // 아래쪽 -> 왼쪽으로
        for(int i=colStart; i<colEnd; i++){
            matrix[rowEnd][i] = matrix[rowEnd][i+1];
            if(min > matrix[rowEnd][i]) min = matrix[rowEnd][i];
        }
        // 오른쪽 -> 아래쪽으로
        for(int i=rowEnd; i>rowStart; i--){
            matrix[i][colEnd] = matrix[i-1][colEnd];
            if(min > matrix[i][colEnd]) min = matrix[i][colEnd];
        }
        // 위쪽 -> 오른쪽으로
        for(int i=colEnd; i>colStart; i--){
            matrix[rowStart][i] = matrix[rowStart][i-1];
            if(min > matrix[rowStart][i]) min = matrix[rowStart][i];
        }
        
        matrix[rowStart][colStart+1] = temp;
        return min;
    }
}