import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] student = new int[n];
        Arrays.fill(student, 1); // 1(체육복 개수)로 초기화
        
        for(int stu : reserve){ // 여분 있는 학생
            student[stu-1] += 1; // 체육복 개수 + 1
        }
        
        for(int stu : lost){ // 도난 당한 학생
            student[stu-1] -= 1; // 체육복 개수 - 1
        }
        
        for(int i=0; i<student.length; i++){
            if(student[i] == 0){ // 체육복이 없는 학생은 앞뒤로 체육복 여벌 있으면 빌림
                if(i-1 >= 0 && student[i-1] > 1){
                    student[i-1] -= 1;
                    student[i] += 1;
                } else if(i+1 < student.length && student[i+1] > 1){
                    student[i+1] -= 1;
                    student[i] += 1;
                }
            }
        }
        
        for(int stu : student){
            if(stu >= 1) answer++;
        }
        
        return answer;
    }
} 