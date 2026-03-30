package c4_DataStructure;

import java.io.*;

public class BOJ_2018_수들의합5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 사용할 변수 초기화
		int cnt = 1; // 가짓수(정답에 해당하는 자연수 N 한 개를 미리 더해주기)
		int startNum = 1;
		int endNum = 1;
		long sum = 1;
		
		while(endNum != N) {
			if(sum == N) {
				cnt++; endNum++; sum += endNum;
			} else if(sum > N) {
				sum-=startNum; startNum++; // 순서 중요! startNum은 이전 값을 마이너스해야 하므로 먼저 sum에서 줄이고 ++하기
			} else if(sum < N) {
				endNum++; sum+=endNum;
			}
		}
		
		System.out.println(cnt);
	}
}
