import java.util.Arrays;

class Solution {
    static int[] parent; // 각 섬의 부모(대장)를 저장할 배열
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        // 1. 다리 비용(costs[2])을 기준으로 오름차순 정렬
        Arrays.sort(costs, (a,b) -> Integer.compare(a[2], b[2]));
        
        // 2. 부모 배열 초기화 (처음엔 자기 자신이 대장)
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        // 3. 정렬된 다리들을 하나씩 확인 (그리디)
        for(int[] edge : costs){
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];
            
            // 4. 두 섬의 대장이 다르다면(연결되어 있지 않다면) 다리 건설!
            if(find(from) != find(to)){
                union(from, to);
                answer += cost;
            }
        }
        
        return answer;
    }
    
    // 대장을 찾는 함수 (Find)
    public int find(int x){
        // 경로 압축: 찾는 과정에서 만나는 모든 노드의 부모를 최상위 대장으로 바꿈
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    // 두 팀을 하나로 합치는 함수 (Union)
    public void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB){
            parent[rootB] = rootA;
        }
    }
}