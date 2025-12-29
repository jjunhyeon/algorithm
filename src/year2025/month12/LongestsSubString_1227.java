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
		int idx =0; // index 값
		int start =0; // slide를 시작하는 지점
		for(Character item : target.toCharArray()){
			// start 이전의 값 조정
			if(null != map.get(item) && map.get(item) >= start) { 
				start = map.get(item) + 1;
			}
			answer = Math.max(idx - start + 1, answer);
			map.put(item, idx);
 			idx ++;
		}
		return answer;
	}
}
