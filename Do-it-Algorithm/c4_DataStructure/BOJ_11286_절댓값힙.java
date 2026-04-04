package c4_DataStructure;

import java.io.*;
import java.util.PriorityQueue;
import java.lang.Math.*;

public class BOJ_11286_절댓값힙 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		// 우선순위 큐 -> 절댓값이 작은 순으로 우선순위 부여
		PriorityQueue<Integer> pQ = new PriorityQueue<>((o1, o2) -> {
			 int num1 = Math.abs(o1);
			 int num2 = Math.abs(o2);
			 
			 if(num1 == num2) { // 절댓값이 같으면 음수 우선으로 정렬
				 return o1 > o2 ? 1 : -1;
			 } else {
				 return num1 - num2;
			 }
		});
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(pQ.isEmpty()) {
					bw.write("0\n");
					continue;
				}
				bw.write(pQ.poll() + "\n");
			} else {
				pQ.add(num);
			}
			//System.out.println("반복" + i + "번: " + pQ.peek());
		}
		
		bw.flush();
		bw.close();
	}
}
