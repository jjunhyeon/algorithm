class Solution {
    public int[] solution(String s) {
		StringBuilder st = new StringBuilder(s);
		int deleteCount = 0;
		int changeCount = 0;
		while (!st.toString().equals("1")) {
			for (int i = 0; i < st.length(); i++) {
				if (st.charAt(i) == '0') {
					deleteCount++;
					st = st.deleteCharAt(i);
					i = i - 1;
				}
			}
			// 길이를 다시
			int len = st.length();
			st = new StringBuilder(Integer.toBinaryString(len));
			changeCount++;
		}
		int[] answer = new int[] { changeCount, deleteCount };
		return answer;
    }
}