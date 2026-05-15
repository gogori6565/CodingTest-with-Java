// 결과: 최소 조작 횟수

class Solution {
    public int solution(String name) {

        int alphabetChangeCnt = 0;

        // 1. 알파벳 조작
        for(int i=0; i<name.length(); i++){
            char curr = name.charAt(i);
            alphabetChangeCnt += Math.min(Math.abs('A' - curr), 'Z' - curr + 1);
        }

        // 2. 커서 조작 : "여기서 뒤로 돌아가는 게 빠를까, 아니면 그냥 계속 앞으로 가는 게 빠를까?"

        int cursorChangeCnt = name.length() - 1; // (1) 오른쪽 방향으로 쭉 (기본);

        for(int i=0; i<name.length()-1; i++){
            if(name.charAt(i+1) == 'A'){ // 다음에 나오는 문자가 'A'라면
                int idx = i+1;
                while(idx < name.length() && name.charAt(idx) == 'A'){
                    idx++;
                }
                cursorChangeCnt = Math.min(cursorChangeCnt, Math.min(i + i + (name.length() - idx), (name.length() - idx) + (name.length() - idx) + i));
            } 
        }

        return alphabetChangeCnt + cursorChangeCnt;
    }
}