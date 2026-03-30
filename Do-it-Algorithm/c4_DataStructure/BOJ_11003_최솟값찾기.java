package c4_DataStructure;

import java.io.*;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Deque;

public class BOJ_11003_최솟값찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()); // A(i) 숫자 입력값들
		Deque<Node> mydeque = new LinkedList<>(); 
		
		for(int i=0; i<N; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			// 덱이 비어있지 않으면서 + 덱의 마지막 값이 들어오는 값보다 크면 = 그 값 삭제
			while(!mydeque.isEmpty() && mydeque.getLast().value > now) {
				mydeque.removeLast();
			}
			
			// 덱의 마지막 값으로 현재 노드 추가
			mydeque.addLast(new Node(now, i));
			
			// 덱의 첫번째의 인덱스가 i-L보다 작으면 삭제 (why? A(i-L+1)~A(i) 중 최솟값을 골라야 함)
			if(mydeque.getFirst().index <= i - L) {
				mydeque.removeFirst();
			}
			
			bw.write(mydeque.getFirst().value + " ");
		}
		
		bw.flush(); // 출력
		br.close();
		bw.close();
	}
	
	static class Node{
		public int value;
		public int index;
		
		Node(int value, int index){
			this.value = value;
			this.index = index;
		}
	}
}
