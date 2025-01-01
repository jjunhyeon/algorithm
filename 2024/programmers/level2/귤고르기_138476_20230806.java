package programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * 귤고르기
 * */
public class 귤고르기_138476_20230806 {

    public static void main(String[] args) {

        int k = 4;
        int[] problem = new int[]{1, 3, 2, 5, 4, 5, 2, 3};
        System.out.println(solution(k, problem));
    }

    public static int solution(int k, int[] problem) {
        // 정답 배열
        HashMap<Integer, Integer> myHash = new HashMap<>();

        int answer = 0;
        for (int i = 0; i < problem.length; i++) {
            // 존재한다면 value + 1
            myHash.put(problem[i], myHash.getOrDefault(problem[i], 0) + 1);
        }

        List<Integer> myMapKey = new ArrayList<>(myHash.keySet());
        // problem의 귤의 카운트가 많은 순으로 정렬
        myMapKey.sort((o1, o2) -> myHash.get(o2) - myHash.get(o1));

        // 많은 수의 귤의 개수부터 차감해서 k값이 0보다 작아지면 최종 결과값
        int i = 0;
        while (k > 0) {
            k -= myHash.get(myMapKey.get(i));
            answer++;
            i++;
        }

        return answer;
    }
}

