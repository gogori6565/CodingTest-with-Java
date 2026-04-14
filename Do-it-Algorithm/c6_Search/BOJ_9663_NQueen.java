package c6_Search;

import java.io.*;

public class BOJ_9663_NQueen {
	static int[] A;
	static int n;
	static int cnt = 0; // 퀸을 배치하는 경우의 수
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		A = new int[n];
		backtracking(0);
		System.out.println(cnt);
	}
	
	public static void backtracking(int row) {
		if(row == n) { // 퀸 N개를 모두 배치한 경우
			cnt++;
			return;
		}
		
		for(int i=0; i<n; i++) {
			A[row] = i; // 만약 check에서 false 처리 되었다면, 다음 열의 위치가 가능한지 체크할 것임
			if(check(row)) { // 배치한 퀸이 이전 퀸들과 서로 공격할 수 없는지 체크하고
				backtracking(row+1); // 배치 괜찮으면 거기서 다음 퀸 위치 찾기
			}
		}
	}
	
	private static boolean check(int row) {
		for(int i=0; i<row; i++) {
			// 같은 열에 퀸이 있으면 X
			if(A[i] == A[row]) return false;
			// 대각선에 퀸이 있으면 X
			if(Math.abs(row-i) == Math.abs(A[i] - A[row])) return false;
		}
		return true;
	}
}
