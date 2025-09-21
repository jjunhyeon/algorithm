package year2025.month9;

// 움직이는 배열
public class LC_RotateArray {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		int k =3;
		solution(nums,k);
	}

	private static void solution(int[] nums, int k) {
		int len = nums.length;
		int getNumber = k % len;
		rotate(nums, 0 ,len -1 );
		rotate(nums, 0, getNumber -1);
		rotate(nums, getNumber, len-1);
	}

	private static void rotate(int[] nums, int start, int end) {
		while(start < end) {
			int tmp = nums[start];
			nums[start ] = nums[end];
			nums[end] = tmp;
			start ++;
			end --;
		}
	}
}
