// return: 경주가 끝났을 때 선수들의 이름을 1등부터 등수 순서대로 배열에 담아 return 

import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        // <이름, 등수> - 등수는 0위부터 사용(인덱스 때문에)
        HashMap<String, Integer> scoreMap = new HashMap<>();
        
        // 1. players 배열 map에 저장 (초기화)
        int rank = 0;
        for(String player : players){
            scoreMap.put(player, rank++);
        }
        
        // 2. callings에 따라 등수 변경
        for(String calledPlayer : callings){
            if(scoreMap.containsKey(calledPlayer)){
                int idx = scoreMap.get(calledPlayer);
                
                // players 순서 교환
                String temp = players[idx];
                players[idx] = players[idx-1]; // 1등인 선수의 이름은 불리지 않으므로 오류X
                players[idx-1] = temp;
                
                // Map의 score 갱신
                scoreMap.put(calledPlayer, idx-1);
                scoreMap.put(players[idx], idx);
            }
        }
        
        return players;
    }
}