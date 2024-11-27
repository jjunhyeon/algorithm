class Solution {
    public int[] solution(String[] wallPaper) {
		// 가장 오른, 위, 왼, 아래 지점을 찾아서 배열에 당마 리턴한다.
		int len = wallPaper.length;
		
		int rowMax =Integer.MIN_VALUE;
		int rowMin =Integer.MAX_VALUE;
		int colMax =Integer.MIN_VALUE;
		int colMin = Integer.MAX_VALUE;
		
		for(int i=0; i<len; i++) {
			String ch = wallPaper[i];
			for(int j=0; j<ch.length(); j++) {
				if(ch.charAt(j) =='#') {
					rowMax = Math.max(rowMax, i);
					rowMin = Math.min(rowMin, i);
					colMax = Math.max(colMax, j);
					colMin = Math.min(colMin, j);
				}
			}
		}
		
		
		return new int[]{rowMin, colMin, rowMax + 1, colMax + 1};
    }
}