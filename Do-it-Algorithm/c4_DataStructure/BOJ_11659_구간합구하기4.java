package c4_DataStructure;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11659_구간합구하기4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] prefixSum = new int[n+1]; // 구간 합 배열
		
		// 구간 합 배열 구하기
		for(int i=1; i<n+1; i++) {
			prefixSum[i] = Integer.parseInt(st.nextToken()) + prefixSum[i-1];
		}
		
		for(int k=0; k<m; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			bw.write(String.valueOf(prefixSum[j] - prefixSum[i-1]) + "\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}
