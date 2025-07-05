package src.year2024.study;

import java.util.HashMap;
import java.util.Map;

// 프로그래머스 
// 자료구조, 구현 
public class 가장많이받은선물_258712 {
	public static void main(String[] args) {
		String[] friends = { "muzi", "ryan", "frodo", "neo" };
		String[] gifts = { "muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi",
				"frodo ryan", "neo muzi" };
//		String[] friends = { "joy", "brad", "alessandro", "conan", "david" };
//		String[] gifts = { "alessandro brad", "alessandro joy", "alessandro conan", "david alessandro",
//				"alessandro david" };

//		String[] friends = { "a", "b", "c"};
//		String[] gifts = { "a b", "b a", "c a", "a c", "a c", "c a" };
		solution(friends, gifts);
	}

	private static void solution(String[] friends, String[] gifts) {
		Map<String, Map<String, Integer>> INFO = new HashMap<>();
		Map<String, Map<String, Integer>> TAKE = new HashMap<>();
		// 친구 정보 add
		for (int i = 0; i < friends.length; i++) {
			INFO.put(friends[i], new HashMap<>());
			TAKE.put(friends[i], new HashMap<>());
			for (int j = 0; j < friends.length; j++) {
				if (friends[i].equals(friends[j]))
					continue;
				INFO.get(friends[i]).put(friends[j], 0);
				TAKE.get(friends[i]).put(friends[j], 0);
			}
		}

		for (int i = 0; i < gifts.length; i++) {
			String GIVER = gifts[i].split(" ")[0];
			String RECEIVER = gifts[i].split(" ")[1];
			INFO.get(GIVER).put(RECEIVER, INFO.get(GIVER).getOrDefault(RECEIVER, 0) + 1);
			TAKE.get(RECEIVER).put(GIVER, TAKE.get(RECEIVER).getOrDefault(GIVER, 0) + 1);
		}

		// 선물 지수를 계산한다.
		// INFO 준 개수
		// TAKE 받은 개수
		Map<String, Integer> GIFT_POINT = new HashMap<>();
		for (String item : INFO.keySet()) {
			int sum = 0;
			for (String val : INFO.get(item).keySet()) {
				sum += INFO.get(item).getOrDefault(val, 0);
			}
			for (String val : TAKE.get(item).keySet()) {
				sum -= TAKE.get(item).getOrDefault(val, 0);
			}
			GIFT_POINT.put(item, sum);
		}

		int answer = 0;
		for (String item : INFO.keySet()) {
			int sum = 0;
			for (String value : INFO.get(item).keySet()) {
				int TAKE_POINT = INFO.get(value).get(item);
				int GIVE_POINT = INFO.get(item).get(value);
				// 받은것보다 준게 많을경우 선물을 받는다.
				// 주고 받은 선물의 수가 같으면서 선물지수가 클 경우
				if (GIVE_POINT > TAKE_POINT || (TAKE_POINT == GIVE_POINT && GIFT_POINT.get(item) > GIFT_POINT.get(value))) {
					sum++;
				}
			}
			// 한명의 사람을 기준으로 최대 선물의 개수를 저장한다.
			answer = Math.max(answer, sum);
		}
	}
}
