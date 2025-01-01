package programmers.level2;

/*
* 사전문제
* 규칙을 찾아야하는 문제
* (n+1) * n
* ((n+1) * n +1 ) * n
* */
public class AEIOU_84512_0806 {

    public static void main(String[] args) {
        String target =  "I";
        solution(target);
    }

    private static int solution(String target) {
        char[] ch = target.toCharArray();
        // 자릿수에 따른 result 시작 값
        int lenghtInfo[] = {781,156,31,6,1};
        int answer =0;

        int cnt = target.length();
        while(cnt > 0){
            if(ch[ch.length - cnt] == 'A'){
                // 자릿수에 따른 값의 증가
                answer += lenghtInfo[ch.length - cnt] * 0 +1;
            } else if(ch[ch.length - cnt] == 'E'){
                answer += lenghtInfo[ch.length - cnt] * 1 +1;
            } else if(ch[ch.length - cnt] == 'I'){
                answer += lenghtInfo[ch.length - cnt] * 2 +1;
            } else if(ch[ch.length - cnt] == 'O'){
                answer += lenghtInfo[ch.length - cnt] * 3 +1;
            } else {
                answer += lenghtInfo[ch.length -cnt] * 4 +1;
            }
            cnt --;
        }

        return answer;
    }
}
