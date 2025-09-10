package year2025.moth9;

import java.util.HashSet;

/*
 UNION & FIND 문제 ?
 -> HashSet 해결
 0910(1220 ~ 1255)
 O(n) 이내로 해결해야한다.
 Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 정렬되어있지 않은 배열에서, 가장 긴 연속적인 요소의 시퀀스를 리턴해라.
 --1 . 초기값의 조건
 -- 배열내에서 가장 긴 길이의 연속적인 배열의 수를 찾을때는 시작값의 조건을 생각해봐야한다.
 -- 시작값의 조건은 현재 내가 탐색지점의 값 보다 "1" 작은 값이 있는지 확이하는것이 필요했음
 -- 이후 HashSet에선 contains + 1 메서드를 제공했기 때문에 해당 자료구조를 잘 활용해 푸는것이 중요했던거 같다.
*/ 
public class LC_LongestConsecutiveSequence {
	public static void main(String[] args) {
		int[] nums = {100,4,200,1,2,3};
		solution(nums);
	}

	private static int solution(int[] nums) {
		int result = 0;
		// to add nums to HashSet for detlete duplicate nums
		HashSet<Integer> setData = new HashSet<>();
		for(int num : nums) {
			setData.add(num);
		}
		// loop set to find longest sequnece target;
		for(int num : setData) {
			// 시작값 이전으 값이 존재한다면 이녀석은 초기값이 될 수 없다.
			// 초기값의 조건
			if(!setData.contains(num - 1)) {
				// 시작점의 조건
				int start = num;
				int target = 1;
				while(setData.contains(start + 1)) {
					start +=1;
					target ++;
				}
				result = Math.max(result, target);
			}
		}
		return result;
	}
}
