class Solution {
    public int solution(String target) {
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