package year2024.programmers.level2;

public class 파괴되지않는건물_92344 {
    public static void main(String[] args) {
        int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
        improvedSolution(board,skill);
    }

    /*
    * 시간초과 발생
    * */
    public static int solution(int[][] board, int[][] skill) {
        int answer = 0;

        int row = board.length;
        int col = board[0].length;
        int[][] skillBoard = new int[row][col];

        // 1. 전체 스킬을 탐색하면서 미리 모든 스킬값을 계산한 result set을 만든다
        for(int[] s : skill) {
            // 첫 s는 스킬 타입 (1 : attack, 2 : heal)
            // 2 ~ 5는 스킬범위
            int skillType = s[0];
            int startRow = s[1];
            int startCol = s[2];
            int endRow = s[3];
            int endCol = s[4];

            int skillValue = s[5] * (skillType == 1 ? -1 : 1);
            for(int i=startRow; i<= endRow; i++){
                for(int j=startCol; j<= endCol; j++){
                    skillBoard[i][j] += skillValue;
                }
            }
        }

        // 2.위에서 만든 result array와 board array를 더하며 0이하의 값의 배열 수를 리턴한다.
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(skillBoard[i][j] + board[i][j] > 0) answer++;
            }
        }

        return answer;
    }
    /*
    * https://tech.kakao.com/2022/01/14/2022-kakao-recruitment-round-1/
    * */
    public static int improvedSolution(int[][] board, int[][] skill){
        int answer = 0;

        int row = board.length;
        int col = board[0].length;
        int[][] skillBoard = new int[row+1][col+1];

        // 1. 전체 스킬을 탐색하면서 미리 모든 스킬값을 계산한 result set을 만든다
        for(int[] s : skill) {
            // 첫 s는 스킬 타입 (1 : attack, 2 : heal)
            // 2 ~ 5는 스킬범위
            int startRow = s[1];
            int startCol = s[2];
            int endRow = s[3];
            int endCol = s[4];
            int skillValue = s[5] * (s[0] == 1 ? -1 : 1);

            skillBoard[startRow][startCol] += skillValue;
            skillBoard[startRow][endCol + 1] += (skillValue * -1);
            skillBoard[endRow + 1][startCol] += (skillValue * -1);
            skillBoard[endRow + 1][endCol + 1] += skillValue;
        }
        calculate(skillBoard);

        // 2.위에서 만든 result array와 board array를 더하며 0이하의 값의 배열 수를 리턴한다.
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(skillBoard[i][j] + board[i][j] > 0) answer++;
            }
        }
        return answer;
    }


    // 누적합 계산
    private static void calculate(int[][] map) {
        int row = map.length;
        int col = map[0].length;
        // 상하
        for (int y = 1; y < row; y++) {
            for (int x = 0; x < col; x++) {
                map[y][x] += map[y - 1][x];
            }
        }
        // 좌우
        for (int x = 1; x < col; x++) {
            for (int y = 0; y < row; y++) {
                map[y][x] += map[y][x - 1];
            }
        }
    }
}
