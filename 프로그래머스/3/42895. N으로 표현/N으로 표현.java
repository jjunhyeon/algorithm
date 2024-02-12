import java.util.*;
class Solution {
    public int solution(int N, int number) {
 List<Set<Integer>> defaultSet = new ArrayList<>();
        // 만약 N이 1이라면 그대로 리턴
        if(N == number) return 1;
        for(int i=0; i<9; i++){
            // 값 초기화
            defaultSet.add(new HashSet<>());
        }
        defaultSet.get(1).add(N);
        for(int i=2; i<9; i++){
            for(int j=1; j<= i/2; j++){
                unionAdd(defaultSet.get(i),defaultSet.get(i-j),defaultSet.get(j));
                unionAdd(defaultSet.get(i),defaultSet.get(j),defaultSet.get(i-j));
            }
            String target = Integer.toString(N);
            // i 만큼 동일한 number 값 추가
            defaultSet.get(i).add(Integer.valueOf(target.repeat(i)));
            
            // 해쉬셋에 포함되어 있으면 끝
            if(defaultSet.get(i).contains(number)) return i;
        }

        return -1;
    }
    
        private static void unionAdd(Set<Integer> defaultSet, Set<Integer> setA, Set<Integer> setB) {
        for(int a : setA){
            for(int b: setB){
                defaultSet.add(a + b);
                defaultSet.add(a - b);
                defaultSet.add(a * b);
                if(b != 0 ) defaultSet.add(a / b);
            }
        }
    }
}