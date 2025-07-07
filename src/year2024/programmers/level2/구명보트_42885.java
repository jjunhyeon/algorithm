package year2024.programmers.level2;

import java.util.Arrays;

/*
* level2 구명보트
* */
public class 구명보트_42885 {
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        solution(people, limit);
    }

    public static int solution(int[] people, int limit){
        int answer = 0;
        // 몸무게 순 정렬
        Arrays.sort(people);
        int index = 0;
        
        /*
        * 가장 가벼운 사람 + 가장 무거운 사람순으로 찾아가기
        * */
        for (int i = people.length - 1; i >= index; i--) {
            if (people[i] + people[index] <= limit) {
                index++;
                answer++;
            }
            else {
                answer++;
            }
        }

        return answer;
    }
}
