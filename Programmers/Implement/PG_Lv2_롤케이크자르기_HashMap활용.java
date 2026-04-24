package Implement;
import java.util.HashMap;
import java.util.List;

// Map 형태에 중복 없이 저장해서 key값의 개수(종류의 개수)가 같은지로 따짐
// 슬라이딩 윈도우 하듯이 자르는 위치 한 칸 씩 옮길 때마다, 저장/삭제를 하나씩 수행 (1,000,000 이내 수행)

class Solution {
    public int solution(int[] topping) {
        
        int solveCnt = 0; // 자르는 방법(정답)
        HashMap<Integer, Integer> leftMap = new HashMap<>();
        HashMap<Integer, Integer> rightMap = new HashMap<>();
        
        // 1. 해시맵 초기화
        leftMap.put(topping[0], 1);
        for(int i=1; i<topping.length; i++){
            int value = 1;
            if(rightMap.containsKey(topping[i])){ // Key가 이미 있다면
                value = rightMap.get(topping[i]) + 1;
            }
            rightMap.put(topping[i], value);
        }
        
        // 토핑 가짓수의 개수가 같으면 solveCnt 증가
        if(leftMap.size() == rightMap.size()) solveCnt++;
        
        // 2. 롤케이크 나누는 방법 찾기
        for(int j=1; j<topping.length; j++){
            leftMap.put(topping[j], 1);
            
            if(rightMap.get(topping[j]) > 1){ // key값이 가진 value가 여러 개면 -1
                rightMap.put(topping[j], rightMap.get(topping[j]) - 1);
            } else{ // 한 개면 삭제
                rightMap.remove(topping[j]);
            }
            
            if(leftMap.size() == rightMap.size()) solveCnt++;
        }
        
        return solveCnt;
    }
}