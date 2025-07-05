import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        // target을 기준으로 , keyMap 탐색한다.
        for(int i=0; i<targets.length; i++) {
            String stTarget = targets[i];
            int sum =0;
            int lt = 0;
            while(lt < stTarget.length()){
                String nowTarget = stTarget.substring(lt,lt+1);
                int valueX = Integer.MAX_VALUE;
                for(int j=0; j<keymap.length; j++){
                    String nowKeyMap = keymap[j];            
                    // 없으면
                    int placeValue = nowKeyMap.indexOf(nowTarget);

                    if(placeValue != -1) {
                        valueX = Math.min(placeValue + 1,valueX);      
                    }
                }
                if(valueX == Integer.MAX_VALUE){
                    sum = -1;
                    break;
                } else {
                    sum += valueX;    
                }
                lt++;
            }
            
            if(sum == Integer.MAX_VALUE || sum == Integer.MIN_VALUE) {
                answer[i] = -1;
            } else {
                answer[i] = sum;    
            }
            
        }
        return answer;
    }
}