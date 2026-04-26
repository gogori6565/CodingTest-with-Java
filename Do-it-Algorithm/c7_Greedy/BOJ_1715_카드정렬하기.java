package c7_Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

// idea: 묶음의 개수가 작은 것들부터 합치는 것이 가장 최소의 비교가 수행됨
// 중요! 2개를 묶은 개수 또한 새로운 카드 묶음으로, 다시 데이터에 넣고 작은 걸 비교 수행해야 됨

public class BOJ_1715_카드정렬하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		int answer = 0;
		
		for(int i=0; i<N; i++) {
			pQ.add(Integer.parseInt(br.readLine()));
		}
		
		for(int i=0; i<N-1; i++) { // 비교 수행 횟수 = 묶음의 개수 - 1
			int compare = pQ.poll() + pQ.poll();
			pQ.add(compare);
			answer += compare;
		}
		
		System.out.println(answer);
	}
}
