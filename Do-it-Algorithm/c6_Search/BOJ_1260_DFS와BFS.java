package c6_Search;

import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;

public class BOJ_1260_DFS와BFS {
	static ArrayList<Integer>[] A;
	static boolean[] visited_DFS;
	static boolean[] visited_BFS;
	
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 노드 개수
		int m = Integer.parseInt(st.nextToken()); // 에지 개수
		int v = Integer.parseInt(st.nextToken()); // 시작 노드 번호
		
		A = new ArrayList[n+1];
		visited_DFS = new boolean[n+1];
		visited_BFS = new boolean[n+1];
		
		for(int i=1; i<n+1; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken());
			
			A[a].add(b);
			A[b].add(a);
		}
		
		// 번호가 작은 것부터 방문하기 위해 정렬
		for(int i=1; i<n+1; i++) {
			Collections.sort(A[i]);
		}
		
		DFS(v);
		System.out.println();
		BFS(v);
	}
	
	public static void DFS(int v) {
		visited_DFS[v] = true;
		System.out.print(v + " ");
		for(int newV : A[v]) {
			if(!visited_DFS[newV]) {
				DFS(newV);
			}
		}
	}
	
	// BFS는 재귀로 풀지 않아도 됨
	public static void BFS(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		visited_BFS[v] = true;
		
		while(!q.isEmpty()) {
			int nowV = q.poll();
			System.out.print(nowV + " ");
			for(int newV : A[nowV]) {
				if(!visited_BFS[newV]) {
					visited_BFS[newV] = true;
					q.add(newV);
				}
			}
		}
		
	}
}
