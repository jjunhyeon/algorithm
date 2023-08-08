import java.util.*;
class Solution {
    static final int[] xRange = {-1, 0, 1, 0}; // x 이동 좌표
    static final int[] yRange = {0, -1, 0, 1}; // y 이동 좌표
    static int N,M;
    static int[][] realMap;
    static int[][] distanceMap;
    
    class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        // 지점 좌표를 저장한다.
        // 출발 좌표
        int startX=0, startY = 0;
        // 레버 좌표
        int leverX=0, leverY = 0;
        // 끝 좌표
        int endX=0, endY = 0;
        // int 맵
        N = maps.length;
        M = maps[0].length();
        realMap = new int[N][M];
        distanceMap = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < maps.length; i++) {
            String row = maps[i];
            for (int j = 0; j < row.length(); j++) {
                // start 좌표
                if (row.charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                    realMap[i][j] = 2;
                } else if (row.charAt(j) == 'L') { // levar 좌표
                    leverX = i;
                    leverY = j;
                    realMap[i][j] = 2;
                } else if (row.charAt(j) == 'E') { // EXIT 좌표
                    endX = i;
                    endY = j;
                    realMap[i][j] = 2;
                } else if (row.charAt(j) == 'O') {
                    realMap[i][j] = 1;
                }
            }
        }
        // bfs에선 i 값을 기준으로 target좌표까지의 거리를 구한다.
        // 1 -> start to lever bfs start
        // 2 -> lever to end bfs end
        int getStartToLeverDistance = bfs(startX,startY,visited,leverX,leverY,false);
        
        if (getStartToLeverDistance == -1) {
            return -1;
        }
        
        int getLeverToEndDistnace =bfs(leverX,leverY,visited,endX,endY,true);
        
        if(getLeverToEndDistnace == -1){
            return -1;
        } else {
            answer = getStartToLeverDistance + getLeverToEndDistnace;
        }
        
        answer = getStartToLeverDistance + getLeverToEndDistnace;
        return answer;
    }
    
        /*
    * @param startX : 시작 x좌표
    * @param startY : 시작 y좌표
    * @param visited : 방문여부
    * @param leverX : 타겟 x좌표
    * @param leverY : 타겟 y좌표
    * */
    private int bfs(int startX, int startY, boolean[][] visited, int targetX, int targetY, boolean needReset) {

        Queue<Node> nodeQ = new LinkedList();
        nodeQ.offer(new Node(startX, startY));

        if (needReset) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    distanceMap[i][j] = 0;
                    visited[i][j] = false;
                }
            }
        }
        // 초기 방문 정보 업데이트
        visited[startX][startY] = true;

        while (!nodeQ.isEmpty()) {
            Node nowNode = nodeQ.poll();
            int nowX = nowNode.x;
            int nowY = nowNode.y;
            for (int i = 0; i < 4; i++) {
                int movedX = nowX + xRange[i];
                int movedY = nowY + yRange[i];

                // 움직인 X,Y좌표 validate
                if (movedX >= 0 && movedX < N && movedY >= 0 && movedY < M && !visited[movedX][movedY] && (realMap[movedX][movedY] == 1 || (realMap[movedX][movedY] ==2))) {
                    visited[movedX][movedY] = true;
                    nodeQ.offer(new Node(movedX, movedY));
                    distanceMap[movedX][movedY] = distanceMap[nowX][nowY] + 1;
                }
            }
        }

        int result = distanceMap[targetX][targetY];

        if (result == 0) {
            return -1;
        } else {
            return result;
        }
    }
}