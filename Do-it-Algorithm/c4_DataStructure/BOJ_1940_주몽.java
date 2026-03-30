package c4_DataStructure;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ_1940_주몽 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 1. 배열 초기화 및 오름차순 정렬
		int[] numArr = new int[N];
		for(int i=0; i<N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numArr);

		// 2. firstIndex, secondIndex 를 이용해 M과 비교하기
		long count = 0; // 갑옷 개수 (정답)
		long sum = 0;
		int firstIndex = 0;
		int secondIndex = N-1;
		
		while(firstIndex != secondIndex) {
			sum = numArr[firstIndex] + numArr[secondIndex];
			if(sum == M) {
				count++; secondIndex--;
			} else if(sum < M) {
				firstIndex++;
			} else if(sum > M) {
				secondIndex--;
			}
		}
		
		// 3. 정답 출력
		System.out.println(count);
	}
}
