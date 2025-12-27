package year2025.month12;

import java.util.*;

/**
 *  Longest Substring Without
 *  Repeating Characters
 *  중복없는 가장 긴 문자열의 길이를 리턴하는 문제.
 *  1) 문자열을 char으로 탐색한다.
 *  2) 현재까지의 문자열을 a,b,c Map<Character,Integer 에 담는다.
 *  3) 다음 탐색하는 루프의 문자열중에 list에 존재한다면 현재까지의 길이를 리턴한다.
 */
public class LongestsSubString_1227 {
	public static void main(String[] args) {
		String s = "pwwkew";
		solution(s);
	}

	private static int solution(String target) {
		int answer = 0;
		Map<Character, Integer> map = new HashMap<>();
		int start =0;
		int end =0;
		for(Character item : target.toCharArray()){
			map.put(item, map.getOrDefault(item, end));
			if(null != map.get(item) || map.get(item) < start) { // 중복 찾음, start가 더 작을경우
				// 중복이 있으면 갱신해야지
				// 중복을 만났다면 start를 갱신해야지
				start = map.get(item) + 1;
				map.put(item, end);
			} else {
				end ++;
			}
			if(map.size() > answer) {
				answer = map.size();
			}
		}
		return answer;
	}
}
