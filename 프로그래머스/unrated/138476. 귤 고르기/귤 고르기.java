import java.util.*;

class Solution {
    public int solution(int k, int[] problem) {
         // 정답 배열
        HashMap<Integer,Integer> myHash = new HashMap<>();

        int answer = 0;
        for(int i=0; i<problem.length; i++) {
            // 존재한다면 value + 1
            myHash.put(problem[i], myHash.getOrDefault(problem[i],0) +1);
        }

        List<Integer> myMapKey = new ArrayList<>(myHash.keySet());
        // problem의 귤의 카운트가 많은 순으로 정렬
        myMapKey.sort((o1, o2) -> myHash.get(o2) - myHash.get(o1));

        int i=0;
        while(k > 0){
            k -= myHash.get(myMapKey.get(i));
            answer ++;
            i ++;
        }

        return answer;
    }
}