package src.year2024.programmers.level2;

class 행렬테두리회전하기_77485 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int minIndex=0;
        int map[][] = new int[rows][columns];
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                map[i][j] = (i * columns) + j + 1 ;
            }
        }

        // 2,2,5,4;  {2,2}부터 {5,4}까지
        for(int[] tmp :queries){
            // 입력받은 일차배열에 들어있는 좌표
            int x1 = tmp[0]-1;
            int y1 = tmp[1]-1;
            int x2 = tmp[2]-1;
            int y2 = tmp[3]-1;

            // 좌측 상단의 초기 값
            int firstNumber = map[x1][y1];
            int min = firstNumber;

            // 숫자를 위로 이동 (좌측)
            for(int i=x1+1; i<=x2; i++){
                min = Math.min(min,map[i][y1]);
                map[i-1][y1] = map[i][y1];
            }

            // 숫자를 좌로 이동 (하단)
            for(int i=y1+1; i<=y2; i++){
                min = Math.min(min,map[x2][i]);
                map[x2][i-1] = map[x2][i];
            }

            // 숫자를 아래로 이동 (우측)
            for(int i=x2-1; i>=x1; i--){
                min = Math.min(min,map[i][y2]);
                map[i+1][y2] = map[i][y2];
            }

            // 숫자를 우로 이동(상단)
            for(int i=y2-1; i>=y1; i--){
                min = Math.min(min,map[x1][i]);
                map[x1][i+1] = map[x1][i];
            }
            map[x1][y1+1] = firstNumber;
            answer[minIndex] = min;
            minIndex++;
        }
        return answer;
    }
}
