package c4_DataStructure;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Stack;

public class BOJ_17298_오큰수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 수열 배열 만들기
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 정답(출력값) 배열 만들기
		int result[] = new int[n];
		
		Stack<Integer> stack = new Stack<>();
		stack.push(0); // 최초 값 push
		
		for(int i=1; i<n; i++) {
			// 스택이 비어 있지 않고 현재 수열이 스택 top 인덱스가 가리키는 수열보다 클 경우
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				result[stack.pop()] = arr[i];
			}
			stack.push(i); // 신규 데이터 push
		}
		
		while(!stack.isEmpty()) { // 스택이 빌 때까지 반복
			result[stack.pop()] = -1;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int j=0; j<n; j++) {
			bw.write(result[j] + " ");
		}
		
		bw.flush();
		bw.close();
	}
}
