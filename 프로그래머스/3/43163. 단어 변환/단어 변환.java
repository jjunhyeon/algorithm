import java.util.*;

// 10:20 시작  ~
class Solution {
    public static int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        
        // 애초에 target에 해당하는 word가 words 배열에 없음
        if(!Arrays.asList(words).contains(target)){
            return 0;
        } 
        
        boolean[] visited = new boolean[words.length];
        getShortestWordChangePathValueByDfs(begin,target,0,words,visited);
        return answer;
    }
    
    
    public static void getShortestWordChangePathValueByDfs(String currentString, String target, int depth, String[] words, boolean[] visited){
        
        // 끝
        if(currentString.equals(target)){
            answer = Math.min(answer, depth);
            return ;
        }
        
        for(int i=0; i< words.length; i++){
            // 바꿀 수 있고, 방문안했음
            if(canConvertString(currentString, words[i]) && !visited[i]){
                visited[i] = true;
                getShortestWordChangePathValueByDfs(words[i], target, depth + 1, words, visited);
                visited[i] = false;
            } 
        }
    }
    
    // @param begin 기준 String value aab aac
    // @param target 대상 String value
    public static boolean canConvertString(String begin, String target){
        // 각 단어의 길이는 모두 같다는 전제이므로 길이 검증 안함
        int differenceCharValueCount = 0;
        for(int i=0; i<begin.length(); i++){
            if (begin.charAt(i) != target.charAt(i)) {
                differenceCharValueCount++;
            }   
            if(differenceCharValueCount > 1){
                return false;
            }
        }
        return true;
    }
}