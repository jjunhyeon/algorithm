import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int result =0;
        cities = Arrays.stream(cities)
                .map(String::toUpperCase)
                .toArray(String[]::new);

        Deque<String> myDeque = new LinkedList<>();
        for(String city : cities){
            
            // 캐시 히트임
            if(myDeque.contains(city)){
                myDeque.remove(city);
                result += 1;
            } else {
                result += 5;
            }
            if(cacheSize ==0) continue;
            
            if(myDeque.size() + 1 > cacheSize){
                myDeque.poll();
            }  
            myDeque.offer(city);
        }
        return result;
    }
}