package c6_Search;

import java.io.*;

public class BOJ_2023_신기한소수 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 자릿수
		
		// 한 자리수 소수 배열 초기화
		int[] prime1 = new int[4];
		prime1[0] = 2;
		prime1[1] = 3;
		prime1[2] = 5;
		prime1[3] = 7;
		
		for(int i=0; i<4; i++){
			DFS(prime1[i], 1, N);
		}
	}
	
	static void DFS(int num, int current_N, int N) {
		
		if(current_N == N){ // 자릿수가 N과 같으면 출력
			System.out.println(num);
			return;
		}
		
		// 1, 3, 5, 7, 9 - 짝수는 2로 나뉘어 떨어지므로 소수가 될 수 없음
		for(int odd=1; odd<10; odd+=2) {
			int new_num = num * 10 + odd;
			
			if(isPrime(new_num)) { // 소수이면
				DFS(new_num, current_N+1, N);
			}
		}
	}
	
	static boolean isPrime(int num) {
		// 1 이하 소수 아님
		if(num < 2) return false;
		
		// 2~제곱근까지 나뉘는지 확인
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num % i == 0) return false;
		}
		
		return true;
	}
}
