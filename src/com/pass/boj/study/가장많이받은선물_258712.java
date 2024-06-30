package com.pass.boj.study;

import java.util.HashMap;
import java.util.Map;

// 프로그래머스 
// 자료구조, 구현 
public class 가장많이받은선물_258712 {
	public static void main(String[] args) {
		String[] friends = { "muzi", "ryan", "frodo", "neo" };
		String[] gifts = { "muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi",
				"frodo ryan", "neo muzi" };
//		String[] friends = {"joy", "brad", "alessandro", "conan", "david"};
//		String[] gifts = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
		
//		String[] friends = { "a", "b", "c"};
//		String[] gifts = { "a b", "b a", "c a", "a c", "a c", "c a" };
		solution(friends, gifts);
	}

	private static void solution(String[] friends, String[] gifts) {
		Map<String, Map<String, Integer>> INFO = new HashMap<>();
		// 친구 정보 add
		for (int i = 0; i < friends.length; i++) {
			INFO.put(friends[i], new HashMap<>());
		}

		for (int i = 0; i < gifts.length; i++) {
			String GIVER = gifts[i].split(" ")[0];
			String RECEIVER = gifts[i].split(" ")[1];
			INFO.get(GIVER).put(RECEIVER, INFO.get(GIVER).getOrDefault(RECEIVER, 0) + 1);
		}

		Map<String, Integer> GIFT_POINT = new HashMap<>();
		for (String item : INFO.keySet()) {
			GIFT_POINT.put(item, 0);
			for (String value : INFO.get(item).keySet()) {
				GIFT_POINT.put(item, GIFT_POINT.getOrDefault(item, 0) + 1);
			}
		}

		System.out.println("INFO::" + INFO);
		
		System.out.println("GIFT_POINT::" + GIFT_POINT);
		int answer = 0;
		for (String item : INFO.keySet()) {
			int sum = 0;
			System.out.println("item::" + item);
			for (String value : INFO.get(item).keySet()) {
				System.out.println("value::" + value +":infO::" + INFO.get(item).get(value));
				Map<String,Integer> cur = INFO.get(value);
				if (INFO.get(item).get(value) == cur.getOrDefault(item,0)) {
					if (GIFT_POINT.get(item) > GIFT_POINT.get(value)) {
						sum++;
					}
				}
				if (INFO.get(item).get(value) > cur.getOrDefault(item,0)) {
					sum++;
				}
				answer = Math.max(answer, sum);
			}
		}
		System.out.println("answer::" + answer);
	}
	
	class Present {
		int give;
		int take;
		Present(int give, int take){
			this.give = give;
			this.take = take;
		}
	}
}
