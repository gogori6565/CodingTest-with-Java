// 출력: 시작 인덱스와 마지막 인덱스를 배열에 담아 return

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{0, 1000001};
        int currentSum = 0;
        int left = 0;
        
        for(int right = 0; right<sequence.length; right++){
            
            currentSum += sequence[right];
            
            while(currentSum > k){
                currentSum -= sequence[left];
                left++;
            }
            
            if(currentSum == k && (right-left) < (answer[1] - answer[0])){
                answer[0] = left;
                answer[1] = right;
            }
        }
        
        return answer;
    }
}