import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
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