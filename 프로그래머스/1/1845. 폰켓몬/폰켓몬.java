import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int max = nums.length / 2;
        Map<Integer,Integer> pocketMap = new HashMap<>();
        for(int n : nums){
            pocketMap.put(n,pocketMap.getOrDefault(pocketMap.get(n),0) + 1);;
        }
        
        answer = pocketMap.size() > max ? max : pocketMap.size(); 
        return answer;
    }
}