import java.util.*;

class Solution {
    
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<String, Integer> custumMap = new HashMap<>();    
        String[][] mbtiDoubleArray = {{"R","T"},{"C","F"},{"J","M"},{"A","N"}};
        
        StringBuilder builderResult = new StringBuilder();
        
        for(int i=0; i<survey.length; i++){
            String leftMbti = survey[i].substring(0,1);
            String rightMbti = survey[i].substring(1,2);
            if(choices[i] == 4){
                continue;
            } 
            
            int custumScore = 0;
            if(choices[i] < 4){
                custumScore = 4 - choices[i];
                custumMap.put(leftMbti, custumMap.getOrDefault(leftMbti, 0) + custumScore);
            } else {
                custumScore = choices[i] - 4;
                custumMap.put(rightMbti, custumMap.getOrDefault(rightMbti, 0) + custumScore);
            }
        }

        for(String[] mbti : mbtiDoubleArray){
            String leftType = mbti[0];
            String rightType = mbti[1];
            int leftValue = 0;
            int rightValue = 0;
            for(String key : custumMap.keySet()){
                if(key.equals(leftType)){
                    leftValue = custumMap.get(key);
                }
                
                if(key.equals(rightType)){
                    rightValue = custumMap.get(key);
                }
            }
            
            if(leftValue == rightValue){
                builderResult.append(leftType);
            } else {
                builderResult.append((leftValue > rightValue) ? leftType : rightType);    
            }
        }
        
        return answer = builderResult.toString();
    }
}