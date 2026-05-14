// 반례 케이스 주의!: "k개는 반드시 제거가 되어야 함"
// ex) 987654321, 2 -> 9876543
// ex) 10, 1 -> 1

class Solution {
    public String solution(String number, int k) {
        StringBuffer sb = new StringBuffer("");
        sb.append(number.charAt(0));

        for(int i=1; i<number.length(); i++){
            int previousIdx = sb.length()-1;

            while(previousIdx >= 0 && k > 0){
                if(sb.charAt(previousIdx) < number.charAt(i)){
                    sb.deleteCharAt(previousIdx);
                    k--;
                    previousIdx--;
                } else{
                    break;
                }
            }
            sb.append(number.charAt(i));
        }

        if(k > 0){ // 제거해야할 개수가 아직 남았다면
            sb.delete(sb.length() - k, sb.length());
        }

        return sb.toString();
    }
}