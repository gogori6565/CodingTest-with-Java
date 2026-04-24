// 배열로 풀어보기

class Solution {
    public int solution(int[] topping) {
        
        int[] leftArr = new int[10001];
        int[] rightArr = new int[10001];
        int leftSize = 0;  // 왼쪽 토핑 종류 수
        int rightSize = 0; // 오른쪽 토핑 종류 수
        int resultCnt = 0; // 방법 수(정답)
        
        // 1. 배열 초기 상태 (모두 오른쪽에 몰음)
        for(int top : topping){
            if(rightArr[top] == 0) rightSize++;
            rightArr[top]++;
        }
        
        // 2. 슬라이딩 윈도우로 토핑 옮기기
        for(int i=0; i<topping.length; i++){
            if(leftArr[topping[i]] == 0) leftSize++;
            leftArr[topping[i]]++;
            
            rightArr[topping[i]]--;
            if(rightArr[topping[i]] == 0) rightSize--;
            
            if(leftSize == rightSize) resultCnt++;
        }
        
        return resultCnt;
    }
}