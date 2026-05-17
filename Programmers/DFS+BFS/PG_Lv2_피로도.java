// "최소 필요 피로도": 가지고 있어야 하는 최소한의 피로도
// "소모 피로도": 탐험 후 소모되는 피로도

// 목표: 유저가 탐험할수 있는 최대 던전 수를 return

class Solution {
    static int maxExploreCnt = 0;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        // 백트래킹
        // 시작은 항상 "최소 필요 피로도"가 k(현재 피로도)보다 큰 던전에서 시작해야 함
        visited = new boolean[dungeons.length];
        DFS(k, 0, dungeons);
        
        return maxExploreCnt;
    }
    
    private void DFS(int k, int exploreCnt, int[][] dungeons){ // exploreCnt: 던전 탐험 횟수
        
        for(int i=0; i<dungeons.length; i++){
            // 탐험하지 않은 던전 && 최소필요피로도가 k 이상인 던전 -> 탐험 가능!
            if(!visited[i] && dungeons[i][0] <= k){
                visited[i] = true;
                k -= dungeons[i][1]; // 남은 피로도 계산
                exploreCnt++;
                
                DFS(k, exploreCnt, dungeons);
                if(exploreCnt > maxExploreCnt) maxExploreCnt = exploreCnt;
                
                // 백트래킹 복구
                visited[i] = false;
                k += dungeons[i][1];
                exploreCnt--;
            }
        }
        
        return;
    }
}