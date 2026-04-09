package c5_sort;

import java.io.*;

public class BOJ_2750_수정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        // 버블 정렬: 인접한 두 수 비교 -> 최대값 맨 뒤로 미루고 맨 뒤 제외 다시 반복
        for(int i=0; i<N-1; i++){
            for(int j=0; j<N-1-i; j++){
                if(arr[j] > arr[j+1]){
                	temp(arr, j);
                }
            }
        }
        
        // 출력
        for(int k=0; k<N; k++){
            System.out.println(arr[k]);
        }
    }
    
    public static void temp(int[] arr, int j){
        int temp = arr[j];
        arr[j] = arr[j+1];
        arr[j+1] = temp;
    }
}