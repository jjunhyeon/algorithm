class Solution {
    
    static boolean[] visited;  
    static int answer = 0;  
    static int[][] dun;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
		dun = dungeons;
        dfs(0, k);
        return answer;
    }
    
    private void dfs(int depth, int firodo) {
		// TODO Auto-generated method stub
		int len = dun.length;
		for(int i=0; i<len; i++) {
			if(visited[i] || dun[i][0] > firodo) {
				continue;
			}
			visited[i] = true;
			dfs(depth + 1, firodo - dun[i][1]);
			visited[i] = false;
		}
		answer = Math.max(answer, depth);
	}
}