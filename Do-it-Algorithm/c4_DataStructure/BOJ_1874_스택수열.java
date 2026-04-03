package c4_DataStructure;

import java.io.*;
import java.util.*;

public class BOJ_1874_스택수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		stack.push(0);

		int inputNum = 1;
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			while(true) {
				if(num > stack.peek()) { // 입력값 num이 top 값보다 크면 -> push
					// NO가 되는 경우 -> 남아있는 것보다 num이 크면서 && inputNum(스택에 저장할 수 있는 수)보다는 num이 작은 경우
					if(num < inputNum) {
						System.out.println("NO");
						return;
					}
					stack.push(inputNum);
					inputNum++;
					sb.append("+\n");
				} else if(num < stack.peek()) { // 입력값 num이 top 값보다 작으면 -> pop
					stack.pop();
					sb.append("-\n");
				} else { // 입력값 num이 top 값과 같으면 -> pop하고 while문 끝
					stack.pop();
					sb.append("-\n");
					break;
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}
