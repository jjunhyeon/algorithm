package year2025.month7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* Given an integer array nums, return all the trimplets [nums[i], nums[j], nums[k]] such taht i != j,
* i != k, and j != k, and num[i] + nums[j] + nums[k] == 0
* Notice that the solution set must not contain duplicate triplets.
* 
* 하나의 값을 기준으로 내부적으로 계속 탐색하며 조건에 해당하는 값이 있을경우 해당 셋을 리턴하게 한다.
* list의 list를 return 타입으로 생성 후 조건에 만족하는 배열이 있으면 해당 result에 담아 해결해본다.
* TLE 발생 ) 
* DFS : 조합수(nC3) = O(n^3)
* 각 조합마다 합 계산 : O(1)
* 중복 제거를 위해 정렬 O(3 log 3) = O(1)
* 최종 시간복잡도 : O(N^3)
* 
* DFS는 모든 조합을 시도하기 때문에 n이 크면 속도가 급격히 느려진다.
* DFS는 탐색 방법이고 복잡도는 분기 개수 * 깊이에 따라 달라진다.
* 특히 ThreeSum은 최대 10^3 까지 입력이 주어지므로 DFS로는 TLE를 피하기 어렵다
* 
* ====================================
* -> 투포인터 알고리즘
* ThreeSum을 다음과 같이 개선
* 1. 정렬 : 배열을 먼저 정렬한다.
* 2. 한 원소 고정(i)  나머지 부분에서 투포인터(left,right)를 이동해 합이 0인지 탐색한다.
* 
* 시간복잡도(투포인터)
* 정렬 : O(n log n )
* 각 원소에 대해 투포인터 스캔 O(n^2)
* 최종시간복잡도 : O(N^2)
*/
public class ThreeSum_20250714 {
	
	static Set<List<Integer>> answer = new HashSet<>();
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
			if(cur.stream().mapToInt(Integer::intValue).sum() == 0 ) {
				List<Integer> temp = new ArrayList<>(cur);
				Collections.sort(temp);
				answer.add(temp);
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
				cur.remove(cur.size() - 1);
				visited[i] = false;
			} 
		}
	}
}
