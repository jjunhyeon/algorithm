package programmers.level2;

/*
 * 행렬회전시키기
 *  1. 값 세팅
 *  2. 왼쪽부터 이동이후 이동한 숫자값 중 최소값 조회 결과 ++ -> 상단 ...-> 오른쪽 ...-> 아래 ...
 *  3. 결과 배열 리턴
 * */
public class 행렬회전_77485 {

    public static void main(String[] args) {

        int row = 6;
        int column = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6,}, {5, 1, 6, 3}};

        solution(row, column, queries);
    }

    public static int[] solution(int row, int col, int[][] queries) {
        int querySize = queries.length;
        int[] result = new int[querySize];

        int[][] answerMap = new int[row][col];
        // 1 값 세팅
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) answerMap[i][j] = (i * col) + j + 1;

        for (int i = 0; i < querySize; i++) {
            // 위치 정보[{STARTX,STARTY,ENDX,ENDY}]
            // 배열 index 정보는 실제 표기된 값보다 1씩 작다
            int startX = queries[i][0] - 1;
            int startY = queries[i][1] - 1;
            int endX = queries[i][2] - 1;
            int endY = queries[i][3] - 1;

            // 좌측이동 시작, endX가 starX가 될때까지 row를 상단으로 처리함
            int temp = answerMap[endX][startY];
            int idx = endX - 1;
            while (idx < startX && idx > 0) {
                answerMap[idx][startY] = temp;
                // 값을 현재 idx가 가리킨값으로 업데이트하고
                idx--;
                temp = answerMap[idx][startY];
                // temp 값을 이전 idx 값으로 업데이트한다.

            }




        }
        return result;
    }
}
