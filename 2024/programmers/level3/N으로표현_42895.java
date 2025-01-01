package programmers.level3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N으로표현_42895 {

    public static void main(String[] args) {
        int N = 5;
        int number =12;
        solution(N, number);
    }

    /*
    * 입력받은 N값으로 사칙연산을 활용해 number가 되는 최단 과정을 찾아야한다.
    * 1. 숫자 N까지의 개수별로 만들 수 있는 HashSet 박스를 만든다.
    * 2. 박스 숫자가 N인 경우 n이 되는 숫자의 박스값을 이용해 박스를 채워준다.
    * 3. 각 박스마다 연속된 숫자를 넣어준다.
    * 4. 박스안에 들어있는 number 값의 해쉬셋의 순서를 리턴한다.
    * */
    private static int solution(int N, int number) {
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
            // i 만큼 동일한 number 값
            String target = Integer.toString(N).repeat(i);
            defaultSet.get(i).add(Integer.valueOf(target));
            // 해쉬셋에 포함되어 있으면 끝
            if(defaultSet.get(i).contains(number)) return i;
        }
        // 최솟값이 8보다 크면 -1을 리턴
        return -1;
    }

    // unionAdd에 사칙연산 결합
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
