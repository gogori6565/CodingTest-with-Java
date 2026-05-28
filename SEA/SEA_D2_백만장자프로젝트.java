package SEA;

import java.util.StringTokenizer;
import java.io.*;

public class SEA_D2_백만장자프로젝트 {
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			long result = 0;
			
            int day = Integer.parseInt(br.readLine());
            String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
            Integer[] price = new Integer[day];
            
            for(int i=0; i<day; i++){
            	price[i] = Integer.parseInt(st.nextToken());
            }
            
            int maxPrice = price[price.length-1];
            for(int i=price.length-2; i>=0; i--) {
            	
            	if(price[i] <= maxPrice) {
            		result += maxPrice - price[i];
            	} else {
            		maxPrice = price[i];
            	}
            }
            
            System.out.println("#" + test_case + " " + result);
		}
	}
}
