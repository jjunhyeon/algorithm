class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length;
        int[] xArray = {-1,0,1,0};
        int[] yArray = {0,1,0,-1};
        
        for(int i=0; i<4; i++){
            int nextX = h + xArray[i];
            int nextY = w + yArray[i];
            if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
                if(board[h][w].equals(board[nextX][nextY])) {
                    answer ++;
                }
            }
        
        }
        return answer;
    }
}