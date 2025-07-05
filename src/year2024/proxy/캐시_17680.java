package src.year2024.proxy;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
 * 캐시
 * db 캐시를 적용할 때 캐시 크기에 따른 실행시간 측정 프로그램 작성
 * 각 도시 이름은 공백,숫자, 특수문자 등이 없는 영문자로 구성되며, 대소문자 구분을 하지 않는다.
 * -> 들어온 도시 이름에 대한 대소문자 일원화를 해줘야한다.
 * 1. cities 배열을 순회하며 Deque contains 여부를 확인하며 담는다.
 * 2-1 만약 cities가 contains라면 cache hit(+1)를 하고 poll한 내용을 그대로 다시 offer
 * 2-2 담겨있지 않다면 cache miss(+5를) 하고 Deque 신규 offer 적용한다.
 * 2-3 최종 탐색이 끝났을때 result 값을 리턴한다.
 * */
public class 캐시_17680 {
    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        solution(cacheSize, cities);
    }

    public static int solution(int cacheSize, String[] cities) {
        int result = 0;
        cities = Arrays.stream(cities).map(String::toUpperCase).toArray(String[]::new);
        Deque<String> myDeque = new LinkedList<>();

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (String city : cities) {
            // 0일 경우 더 이상 볼 필요 없음

            // 캐시 히트임
            if (myDeque.contains(city)) {
                myDeque.remove(city);
                result += 1;
            } else {

                result += 5;
            }
            if (myDeque.size() + 1 > cacheSize) {
                myDeque.poll();
            }
            myDeque.offer(city);
        }
        return result;
    }
}
