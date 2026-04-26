package c7_Greedy;

import java.io.*;
import java.util.StringTokenizer;

// idea: 동전의 가치가 큰 것부터 나머지 연산(division)을 해서 나머지가 가장 적게 K원을 만들 수 있는 해가 최선의 정답

public class BOJ_11047_동전0 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int answer = 0; // 필요한 동전의 개수 최솟값(정답)
		int[] coinArr = new int[N]; // 행: 동전의 가치
		int tempK = K; // 사용한 동전의 값을 뺀 나머지 값을 저장하는 임시 K 값
		
		for(int i=0; i<N; i++) {
			String coin = br.readLine();
			coinArr[i] = Integer.parseInt(coin);
		}
		
		// 개선 코드
		for(int i=N-1; i>=0; i--) {
			// 현재 가치의 동전이 남은 금액보다 작거나 같을 때만 수행
			if(coinArr[i] <= tempK) {
				answer += tempK / coinArr[i];
				tempK %= coinArr[i]; // 나머지 금액 업데이트
			}
		}
		
//		for(int i=N-1; i>=0; i--) {
//			int div = tempK / coinArr[i];
//			if(div > 0) {
//				tempK = tempK - (coinArr[i] * div);
//				if(tempK == 0) {
//					answer += div;
//					System.out.println(answer);
//					break;
//				} else if(tempK > 0) {
//					answer += div; 
//				}
//			}
//		}
	}
}
