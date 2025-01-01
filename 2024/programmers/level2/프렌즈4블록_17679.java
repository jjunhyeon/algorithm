package programmers.level2;

import java.util.*;
class 프렌즈4블록_17679 {
    
    public static int[] xArray = {0,1,1};
    public static int[] yArray = {1,0,1};
    
    public static int row;
    public static int col;
    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        //  데이터 접근을 편하게 하기 위해 이차원 배열로 선언
        String[][] map = new String[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                map[i][j] = String.valueOf(board[i].charAt(j));
            }
        }
        
        row = m;
        col = n;

        // 한번의 스코프로 끝나는게 아니므로 while 처리
        while(true){
             boolean[][] checkMap = getCheckedMap(map);
             // while 탈출조건
             boolean isChecked = false;
            
             for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(checkMap[i][j]){
                        map[i][j] = "-";
                        answer ++;
                        isChecked = true;
                    }
                }
            }

            // 뿌순 블록 처리를 한번도 하지 않았으면 탈출
            if(!isChecked) break;
            
            String[][] updateMap = new String[m][n];
            
            for(int i=0; i<n; i++){
                // stack을 사용해 하나의 col 정보를 담는다.
                Stack<String> colStack = new Stack<String>();
                
                int idx = 0;
                while(idx < m){
                   if(map[idx][i] != "-"){
                        colStack.add(map[idx][i]);
                    }
                    idx ++;
                }

                // 담은 하나의 col 정보를 가로, 세로가 동일한 신규 2차원 배열에 가장 아래부터 스택을 pop한 값을 넣는다.
                for(int x = m -1; x >= 0; x--){
                    if(!colStack.isEmpty()) updateMap[x][i] = colStack.pop();
                }
            }
            // map 정보를 업데이트한 배열로 바꾼다.
            map = updateMap;
        }
        return answer;
    }
    
    public static boolean[][] getCheckedMap(String[][] map){
        boolean[][] checkedMap = new boolean[row][col];        
        // 오른, 아래, 오른아래가 같은 String 이라면 해당 위치를 check
        for(int i=0; i< row - 1; i++){
            for(int j=0; j<col - 1; j++){
                // null String 처리 추가 필요
                String currentString = map[i][j];
                
                for(int k=0; k<3; k++){
                    //validate 필요
                    int movedX = i + xArray[k];
                    int movedY = j + yArray[k];
                    
                    if(movedX >= row || movedY >= col || "-".equals(currentString) || currentString == null) break;
                    
                    if(!currentString.equals(map[movedX][movedY])) break;
                        
                    // 오른,아래,대각선 String 동일하다면
                    if(k == 2){
                        checkedMap[i][j] = true;
                        checkedMap[i + 1][j] = true;
                        checkedMap[i][j + 1] = true;
                        checkedMap[i + 1][j + 1] = true;
                    }
                }
            }
        }
        
        return checkedMap;
    }
}
