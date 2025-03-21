package month3;


/*
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that 
 * appears more than ⌊n / 2⌋ times. 
 * You may assume that the majority element always exists in the array.
 * https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150
 * 03 / 22
 * 과반수 이상 나온 배열의 값을 도출하는 문제
 *
 * 최초 생각
 * 1) HashMap 활용
 * HashMap을 활용해 나온 값에 대해 (nums[i], 도출횟수) 를 관리하면서
 * 해결할 수 있었지만 하지만 이는 HashMap에 대한 공간복잡도로 인해 시간복잡도와 공간복잡도 모두
 * O(N)이 사용되어 지는 아쉬움이 존재
 * 
 * 2) 개선
 * 보이어-무어 알고리즘 
 * 과반수 이상 등장하는 요소는 항상 존재하는 조건하에 해겨할 수 있는 알고리즘 학습
 * 하나의 후보를 정하고, 다른 요소가 나올 때마다 카운트를 차감하여 가장 많이 나온 candidate를 찾아낸다.
 * 
 *
*/
public class LC_MajorityElement {
	public static void main(String[] args) {
		int[] nums = {2,2,1,1,1,2,2};
		solution(nums);
	}

	private static int solution(int[] nums) {
		int count =0;
		int candidate = 0;
		for(final int n : nums) {
			if(count == 0) candidate = nums[n];
			count += (candidate == n) ? 1 : -1;
		}
		
		return candidate;
	}
}
