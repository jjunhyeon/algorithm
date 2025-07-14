package year2025.month7;

import java.util.ArrayList;
import java.util.List;

/*
* Given an integer array nums, return all the trimplets [nums[i], nums[j], nums[k]] such taht i != j,
* i != k, and j != k, and num[i] + nums[j] + nums[k] == 0
* Notice that the solution set must not contain duplicate triplets.
* 
* dfs 문제로 보임
* 하나의 값을 기준으로 내부적으로 계속 탐색하며 조건에 해당하는 값이 있을경우 해당 셋을 리턴하게 한다.
* list의 list를 return 타입으로 생성 후 조건에 만족하는 배열이 있으면 해당 result에 담아 해결해본다.
*/
public class ThreeSum_20250714 {
	
	static List<List<Integer>> answer = new ArrayList<>();
	public static void main(String[] args) {
		int[] num1 = {-1,0,1,2,-1,-4};
		solution(num1);
	}

	private static void solution(int[] arr) {
		List<Integer> cur = new ArrayList<Integer>();
		boolean[] visited =new boolean[arr.length];
		findZeroInArr(cur, 0, arr, visited);
	}

	private static void findZeroInArr(List<Integer> cur, int target, int[] arr, boolean[] visited) {
		if(cur.size() == 3) {
			// 배열의 합계가 0이라면
			if(cur.stream().mapToInt(Integer::intValue).sum() == 0 ) {
				answer.add(cur);
				cur.clear();
				return ;
			}
		}
		
		int len = arr.length;
		for(int i=0; i<len; i++) {
			// 체크안되었으면 
			if(!visited[i]) {
				cur.add(arr[i]);
				visited[i] = true;
				findZeroInArr(cur, target, arr, visited);
				
			} 
			
		}
		
	}

}
