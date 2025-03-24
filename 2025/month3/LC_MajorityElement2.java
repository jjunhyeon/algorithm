package month3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC_MajorityElement2 {
	public static void main(String[] args) {
		int[] nums = {3,2,3};
		solution(nums);
	}

	private static List<Integer> solution(int[] nums) {
		Set<Integer> answer = new HashSet<>();
		int limit = nums.length / 3;
		
		HashMap<Integer,Integer> value = new HashMap<>();
		
		for(final int n : nums) {
			value.put(n, value.getOrDefault(n, 0) + 1);
			if(value.get(n) > limit) answer.add(n);
		}
		return new ArrayList<>(answer);
	}
}
