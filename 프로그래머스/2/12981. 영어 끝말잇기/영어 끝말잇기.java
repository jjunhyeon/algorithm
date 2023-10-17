// 09:10 ~
import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> answerSet = new HashSet<String>();
        int number = 0;
        StringBuilder stBuilder = new StringBuilder();
        while(number < words.length){
            
            // 한글자 바로 컷
            if(words[number].length() < 2){
                answer[0] = (number % n) + 1;
                answer[1] = (number / n) + 1;
                break;
            } 
                        
            // 짝수번째
            if(number > 0){
                if (!stBuilder.toString().substring(stBuilder.length() - 1).equals(words[number].substring(0, 1))) {
                    // stBuilder의 마지막 글자와 words[number]의 첫 글자가 다를 때 수행할 코드
                    System.out.println("dd?"+ number);
                    answer[0] = (number % n) + 1;
                    answer[1] = (number / n) + 1;
                    break;
                }      
            } 
            
            // 이전 단어 업데이트
            stBuilder.setLength(0); 
            stBuilder.append(words[number]);
            
            // 중복 단어 사용 X
            if(!answerSet.contains(words[number])){
                answerSet.add(words[number]);
            } else {
                answer[0] = (number % n) + 1;
                answer[1] = (number / n) + 1;
                break;
            }
            number ++;
        }
        return answer;
    }
}