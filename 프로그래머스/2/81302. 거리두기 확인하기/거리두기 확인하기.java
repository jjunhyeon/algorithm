import java.util.*;

class Solution {
    
    public static int[][] maps = new int[5][5];
    public static int idx = 0;
       
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        Arrays.fill(answer, 1);
        for (String[] place : places) {
            int[][] userPlace = new int[5][5];
            String[] watingRoom = place;
            for (int i = 0; i < 5; i++) {
                String s = watingRoom[i];
                for (int j = 0; j < 5; j++) {
                    char c = s.charAt(j);
                    // 정상 사용자
                    if (c == 'P') {
                        userPlace[i][j] = 1;
                    } else if (c == 'O') { // 빈 테이블
                        userPlace[i][j] = -1;
                    } else {
                        userPlace[i][j] = 0; // 파티션
                    }
                }
            }

            maps = userPlace;
            boolean isFollowed = true;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    // 1 -> 사용자가 존재하는 지점
                    if (maps[i][j] == 1) {
                        if (!isMembersFollowedRule(i, j)) {
                            answer[idx] = 0;
                            isFollowed = false;
                            break;
                        }
                    }
                }
                if (!isFollowed) break;
            }
            idx++;
        }
        return answer;
    }
    
    public static boolean isMembersFollowedRule(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int[] xArray1 = {-1, 0, 1, 0};
            int[] yArray1 = {0, 1, 0, -1};

            int movedX = x + xArray1[i];
            int movedY = y + yArray1[i];

            // 정상 범위 값 체크
            if (!isValidatePlace(movedX, movedY)) {
                continue;
            }

            // 값 검증
            if (maps[movedX][movedY] == 1) {
                return false;
            }
        }
        
        int[][] pos2 = {{0, 2}, {0, -2}, {2, 0}, {-2, 0}};
         for (int p = 0; p < pos2.length; p++) {
        int nr = x + pos2[p][0];
        int nc = y + pos2[p][1];

        if (!(nr >= 0 && nr < 5 && nc >= 0 && nc < 5)) {
            continue;
        }

        if (maps[nr][nc] == 1 && maps[(x + nr) / 2][(y + nc) / 2] == -1) {
            return false;
        }
    }
        // 상,하,좌,우 체크 (2칸씩)
//         for (int i = 0; i < 4; i++) {
//             int[] xArray1 = {-2, 0, 2, 0};
//             int[] yArray1 = {0, 2, 0, -2};

//             int movedX = x + xArray1[i];
//             int movedY = y + yArray1[i];

//             // 정상 범위 값 체크
//             if (!isValidatePlace(movedX, movedY)) {
//                 continue;
//             }

//             int xWeight = (i == 0) ? -1 : (i == 2) ? 1 : 0;
//             int yWeight = (i == 1) ? 1 : (i == 3) ? -1 : 0;

//             if(!isValidatePlace(x + xWeight,y+yWeight)){
//                 continue;
//             }
//             // 값 검증, 2칸은 사이에 빈 테이블이 있어야 함
//             // if (maps[movedX][movedY] == 1 && maps[x + xWeight][y + yWeight] == -1 && inDistance(x,y,movedX,movedY)) {
//             //     return false;
//             // }
//              if (maps[movedX][movedY] == 1 && maps[(x + xWeight)][(y + yWeight)] == -1) {
//                     return false;
//             }
//         }

        // 대각체크
//         for (int i = 0; i < 4; i++) {
//             int[] xArray1 = {-1, 1, -1, 1};
//             int[] yArray1 = {-1, 1, 1, -1};

//             int movedX = x + xArray1[i];
//             int movedY = y + yArray1[i];

//             // 정상 범위 값 체크
//             if (!isValidatePlace(movedX, movedY)) {
//                 continue;
//             }
//             // i == 0, 왼쪽 아래 -> 왼쪽 , 아래 1칸 검사 (0, -1) + (1,0)
//             // i == 1, 오른 아래 -> 오른 , 아래 1칸 검사 (0, 1) + (1,0)
//             // i == 2, 왼쪽 상단 -> 왼쪽 , 위 1칸 검사  (0, -1) + (-1,0)
//             // i == 3, 오른 상단 -> 오른 , 위 1칸 검사  (0,  1) + (-1,0)
//             // i == 0 -> -1, i == 2 -> 1 else 0
//             int xWeight = (i <= 1) ? 1 : -1;
//             int yWeight = (i == 0 || y == 2) ? -1 : 1;

//             if(!isValidatePlace(x + xWeight,y+yWeight)){
//                 continue;
//             }
            
//             // 값 검증, 2칸은 사이에 빈 테이블이 있어야 함
//             if (maps[movedX][movedY] == 1 && (maps[x + xWeight][y] == -1 || maps[x][y + yWeight] == -1 )) {
//                 return false;
//             }
//         }
        
        // 대각선
        int[][] pos3 = {{1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        for (int p = 0; p < pos3.length; p++) {
            int nr = x + pos3[p][0];
            int nc = y + pos3[p][1];

            if (!(nr >= 0 && nr < 5 && nc >= 0 && nc < 5)) {
                continue;
            }

            if (maps[nr][nc] == 1 && (maps[x][nc] == -1 || maps[nr][y] == -1)) {
                return false;
            }
        }
        
        
        return true;
    }
    
    public static boolean isValidatePlace(int x,int y){
        if(x >=0 && x<=4 && y>=0 && y<=4){
            return true;
        } 
        return false;
    }
    
    public static class Place{
        int x,y;
        Place(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
      // 맨해튼 거리
    private static boolean inDistance(int x1, int y1, int x2, int y2){
        int xd = Math.abs(x2-x1);
        int yd = Math.abs(y2-y1);

        return (xd + yd) <= 2 ? true : false;
    }
}