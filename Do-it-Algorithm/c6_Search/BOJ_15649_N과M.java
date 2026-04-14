package c6_Search;

import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BOJ_15649_N과M {
	static int[] A;
	static boolean[] visited;
	static int n, m;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// ArrayList 인접리스트 생성
		A = new int[n];
		visited = new boolean[n+1];
		backtracking(0);
	}
	
	public static void backtracking(int length) {
		
		if(length == m) {
			printArray();
			return;
		}
		
		for(int i=1; i<n+1; i++) {
			if(!visited[i]) {
				visited[i] = true;
				A[length] = i;
				backtracking(length+1);
				visited[i] = false;
			}
		}
	}
	
	public static void printArray() {
		for(int i=0; i<m; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}
