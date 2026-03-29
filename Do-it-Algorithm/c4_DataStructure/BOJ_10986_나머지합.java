package c4_DataStructure;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10986_나머지합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		long prefixSum = 0; // 각 구간 합을 더할 변수
		long[] modularCnt = new long[m]; // 나머지 값은 m-1 까지 존재
		
		// 1. 구간 합 값을 구해, 각각을 m으로 나눈 나머지 값의 개수를 구하는 배열을 만든다.
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			prefixSum += Integer.parseInt(st.nextToken());
			
			modularCnt[(int)(prefixSum % m)]++;
		}
		
		// 2. 나머지 값이 같은 쌍의 개수를 구한다. (조합)
		// why? 나머지 값이 같은 구간은 그 구간의 합의 나머지가 0으로 떨어짐 (즉, m으로 나뉘어짐) => 분배 법칙
		long resultCnt = modularCnt[0]; // 0~구간까지의 나머지가 이미 0인 구간의 개수를 먼저 더해주기
		
		for(int j=0; j<m; j++) {
			if(modularCnt[j] > 1) { // 쌍이 존재한다면 (2개 이상이라면)
				resultCnt += modularCnt[j] * (modularCnt[j] - 1) / 2;
			}
		}
		
		System.out.println(resultCnt);
		
	}
}
