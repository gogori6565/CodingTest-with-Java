package c4_DataStructure;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253_좋다 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 1. 숫자 배열을 만들어 오름차순 정렬한다.
		long[] numArr = new long[N];
		for(int i=0; i<N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numArr);
		
		// 2. firstIdx, secondIdx, targetIdx를 선언한다.
		// 투 포인터 알고리즘을 활용한다. (단, 수의 범위가 '절댓값'임에 유의하기
		int goodCnt = 0; // 좋은 수 (정답)
		
		for(int targetIdx=0; targetIdx<N; targetIdx++) {
			int firstIdx = 0;
			int secondIdx = N -1;
			long sum = 0;
			
			while(firstIdx < secondIdx) {
				sum = numArr[firstIdx] + numArr[secondIdx];
				if(sum == numArr[targetIdx]) {
					// targetIdx와 다른 수 인지 체크
					if(firstIdx == targetIdx) {
						firstIdx++;
						continue;
					} else if(secondIdx == targetIdx) {
						secondIdx--;
						continue;
					}
					goodCnt++; 
					break; // 좋은 수를 찾으면 넘어감 (조합의 수를 찾는 게 X)
				} else if(sum > numArr[targetIdx]) {
					secondIdx--;
				} else if(sum < numArr[targetIdx]) {
					firstIdx++;
				}
			}
		}
		
		// 3. 정답 출력
		System.out.println(goodCnt);
		br.close();
	}
}
