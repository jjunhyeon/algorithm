package programmers.level2;

import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = dfs(p);
        return answer;
    }
    
    public String dfs(String str){
        
        StringBuilder answerBuilder = new StringBuilder();
        
        // isEmpty 는 NullPointerException 발생하므로 유의
        if(str == null || str.isEmpty()){
            return "";
        }
        
        int idxNumber = findIndex(str);
        String u = str.substring(0,idxNumber+1);
        String v = str.substring(idxNumber+1,str.length());
        
        // u와 v가 correct한지 검증한다.
        if(isCorrectString(u)){
            answerBuilder.append(u + dfs(v));
        } else {
            String changedString = changeStringFormat(u);
            answerBuilder.append("(" + dfs(v) +")" + changedString);
        }
        
        return answerBuilder.toString();
    }
    
    
    
    public int findIndex(String str){
        
        int open = 0;
        int close = 0;
        for(int i=0; i<str.length(); i++){
            String currentString = String.valueOf(str.charAt(i));
            if("(".equals(currentString)) open ++;
            else close ++;    
            if(open == close ) return i;
        }
            
        return 0;
    }
    
    
    // String의 괄호 배열이 맞는지 검증한다.
    public boolean isCorrectString(String str){
        
        Stack<String> answerStack = new Stack<>();
        
        for(int i=0; i<str.length(); i++){
            String currentString = String.valueOf(str.charAt(i));
            if("(".equals(currentString)){
                answerStack.push(currentString);   
            }  else {
                
                if(answerStack.isEmpty()){
                    return false;   
                }

                answerStack.pop();
            }
            
        }
    
        return true;
    }
    
    public String changeStringFormat(String str){
        
        StringBuilder changedString = new StringBuilder();
        for(int i=1; i<str.length()-1; i++){
            String currentString = String.valueOf(str.charAt(i));
            if("(".equals(currentString)) changedString.append(")");
            else changedString.append("(");
        }
        
        return changedString.toString();
    }
    
}
