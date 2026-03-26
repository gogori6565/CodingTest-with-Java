package c4_DataStructure;

import java.io.*;

public class BOJ_1546_평균 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String scores = br.readLine();
        String[] arr = scores.split(" ");
        br.close();
		
		int max = 0;
		int sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			sum += Integer.parseInt(arr[i]);
            if(max < Integer.parseInt(arr[i])) max = Integer.parseInt(arr[i]);
		}
		
		System.out.println(sum*100.0/max/n);
	}
}
