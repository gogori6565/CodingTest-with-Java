import java.util.StringTokenizer;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[]{0,0};
        
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder()); // 큰 숫자가 먼저 나옴 
        PriorityQueue<Integer> minPQ = new PriorityQueue<>(); // 작은 숫자가 먼저 나옴 (default)
        
        for(String operation : operations){
            StringTokenizer st = new StringTokenizer(operation);
            char alpha = st.nextToken().charAt(0);
            int number = Integer.parseInt(st.nextToken());

            if(alpha == 'I'){ // 삽입
                maxPQ.offer(number);
                minPQ.offer(number);
                
            } else if (alpha == 'D' && number == 1){ // 최댓값을 삭제
                if(!maxPQ.isEmpty()){
                    int max = maxPQ.poll();
                    minPQ.remove(max);
                }
            } else if (alpha == 'D' && number == -1){ // 최솟값을 삭제
                if(!minPQ.isEmpty()){
                    int min = minPQ.poll();
                    maxPQ.remove(min);
                }
            }
        }
        
        if(!maxPQ.isEmpty() && !maxPQ.isEmpty()){
            answer[0] = maxPQ.poll();
            answer[1] = minPQ.poll();
        }
        
        return answer;
    }
}