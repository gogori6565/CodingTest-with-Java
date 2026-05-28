package SEA;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SEA_D2_중간평균값구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String numStr = br.readLine();
			StringTokenizer st = new StringTokenizer(numStr);
			int[] numArr = new int[10];
			
			for(int i=0; i<10; i++) {
				numArr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(numArr);
			
			int sum = 0;
			for(int j=1; j<9; j++) {
				sum += numArr[j];
			}
			
			System.out.println("#" + test_case + " " + Math.round((double)sum/8.0));
		}
	}
}
