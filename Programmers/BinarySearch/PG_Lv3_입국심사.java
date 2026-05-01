import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        // 모든 사람이 심사를 받는 데 T분만큼 걸린다고 가정했을 때, 총 몇 명을 심사할 수 있는가?
        Arrays.sort(times);
        
        long left = 1; // 최소시간: 1분
        long right = (long)n * (long)times[times.length - 1]; // 최대시간: n * times의 최댓값
        long answer = 0;
        
        while(left <= right){
            long mid = (right + left) / 2;
            long possibleImmigrationPeople = 0;
            for(int time : times){
                possibleImmigrationPeople += mid / time; // 가정한 시간 내에 각 심사관이 처리할 수 있는 사람의 수 더하기
            }
            
            if(possibleImmigrationPeople >= n){
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}