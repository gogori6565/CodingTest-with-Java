package c6_Search;

import java.io.*;
import java.util.*;

public class BOJ_2178_미로찾기 {
	static int[][] numArr;
	static boolean[][] visited;
	static int count = 0; // 칸 수 (정답)
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N, M;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numArr = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			String[] splitArr = str.split("");
			
			for(int j=0; j<M; j++) {
				numArr[i][j] = Integer.parseInt(splitArr[j]);
			}
		}
		
		BFS(0, 0);
		System.out.println(numArr[N-1][M-1]);
	}
	
	private static void BFS(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i, j});
		visited[i][j] = true;
		
		while(!q.isEmpty()) {
			int now[] = q.poll();
			
			for(int k=0; k<4; k++) {
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				
				if(x >= 0 && y >= 0 && x < N && y < M) { // 범위 내 값이라면
					 if(!visited[x][y] && numArr[x][y] != 0) { // 방문하지 않았고 && 이동할 수 있는 칸이라면
						 visited[x][y] = true;
						 numArr[x][y] = numArr[now[0]][now[1]] + 1;
						 q.add(new int[] {x, y});
					 }
				}
			}
		}
	}
}
