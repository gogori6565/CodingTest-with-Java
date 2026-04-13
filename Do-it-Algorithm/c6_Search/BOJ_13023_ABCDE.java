package c6_Search;

import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BOJ_13023_ABCDE {
	static ArrayList<Integer>[] A;
	static boolean visited[];
	static boolean arrive;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arrive = false;
		
		// 인접 리스트 만들기
		A = new ArrayList[N];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			A[i] = new ArrayList<Integer>();
		}
		// 인접 리스트 초기화
		for(int j=0; j<M; j++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			A[u].add(v);
			A[v].add(u);
		}
		
		for(int k=0; k<N; k++) {
			DFS(k, 1);
			if(arrive) break;
		}
		
		if(arrive) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
	
	// 핵심: 재귀의 깊이가 depth가 5 이상인가
	public static void DFS(int v, int depth) {
		
		if(depth == 5 || arrive) {
			arrive = true;
			return;
		}
		
		visited[v] = true;
		for(int i : A[v]) {
			if(!visited[i]) {
				DFS(i, depth+1);
			}
		}
		visited[v] = false;
	}
}
