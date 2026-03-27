package c4_DataStructure;

import java.io.*;
import java.util.StringTokenizer;

public class BO55J_11660_구간합구하기5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// 2차원 구간 합 배열
		int[][] prefixSum = new int[n+1][n+1]; // 0 인덱스는 무시
		
		// prefixSum 배열 값 넣기
		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=1; j<n+1; j++) {
				prefixSum[i][j] = prefixSum[i][j-1] + prefixSum[i-1][j] - prefixSum[i-1][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		
		// 정답 출력
		for(int k=0; k<m; k++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			System.out.println(prefixSum[x2][y2]-prefixSum[x1-1][y2]-prefixSum[x2][y1-1]+prefixSum[x1-1][y1-1]);
		}
	}
}
