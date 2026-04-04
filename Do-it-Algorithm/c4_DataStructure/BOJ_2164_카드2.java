package c4_DataStructure;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164_카드2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 큐 초기화
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<N+1; i++) {
			q.add(i);
		}
		
		// 큐가 빌 때까지 반복
		while(!q.isEmpty()) {
			// 제일 위 카드 버리고, 그 다음 위 카드 제일 아래로
			int a = q.poll();
			// 버렸더니 큐가 비었다 = 마지막으로 남는 카드이다
			if(q.isEmpty()) { 
				System.out.println(a);
				break;
			}
			q.add(q.poll());
		}
	}
}
