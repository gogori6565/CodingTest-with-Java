package c6_Search;

import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BOJ_11724_연결요소의개수 {
	static ArrayList<Integer>[] A;
	static boolean visited[];
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		A = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		// 인접리스트 초기화
		for(int i=1; i<N+1; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for(int j=0; j<M; j++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			// 양방향 에지이므로 양쪽에 에지 더하기
			A[u].add(v);
			A[v].add(u);
		}
		
		int count = 0;
		for(int k=1; k<N+1; k++) {
			if(!visited[k]) {
				count++;
				DFS(k);
			}
		}
		System.out.println(count);
	}
	
	static void DFS(int v) {
		if(visited[v]) {
			return;
		}
		
		visited[v] = true;
		for(int i : A[v]) {
			if(visited[i] == false) {
				DFS(i);
			}
		}
	}
}
