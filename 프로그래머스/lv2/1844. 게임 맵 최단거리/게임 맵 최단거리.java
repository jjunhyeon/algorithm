
// 12:20 시작 ~ 12:47
import java.util.*;
class Solution {
    
    public static int result = 0;
    // 방문 여부 검증을 위한 visited
    public static boolean[][] visited;
    
    // moved Array 정보
    public static int[] xArray = {-1,0,1,0};
    public static int[] yArray = {0,1,0,-1};
    
    public int solution(int[][] maps) {
        int[][] distanceInfoArray = new int[maps.length][maps[0].length];
        visited = new boolean[maps.length][maps[0].length];
        int answer = getShortestDistanceByBfsSolution(maps,distanceInfoArray);
        return answer;
    }
    
    // value add
    public static int getShortestDistanceByBfsSolution(int[][] maps, int[][] distanceInfoArray){
        Queue<Node> myQ = new LinkedList<>();
        // 시작지점은 고정이고 타겟은 우측 하단(n,m)임
        myQ.offer(new Node(0,0));
        distanceInfoArray[0][0] = 1;
        
        while(!myQ.isEmpty()){
            Node nowPlace = myQ.poll();
            int nowX = nowPlace.x;
            int nowY = nowPlace.y;
            if(nowX == maps.length && nowY == maps[0].length){
                break;
            }
            // 한칸씩 이동해보면서 검증
            for(int i=0; i<4; i++){
               int movedX = nowX + xArray[i]; 
               int movedY = nowY + yArray[i];  
                // 움직인 좌표 value 검증, 0이상 가로세로 크기 검증 + 이전에 방문하지 않았고 + 벽이 아닌 값에 대한 검증)
               if(movedX >=0 && movedX < maps.length && movedY >=0 && movedY < maps[0].length && !visited[movedX][movedY] && maps[movedX][movedY] != 0) {
                  // 방문처리
                  visited[movedX][movedY] = true;
                  myQ.offer(new Node(movedX,movedY));
                  distanceInfoArray[movedX][movedY] = distanceInfoArray[nowX][nowY]  + 1;
               }
            }
        }
        
        return (distanceInfoArray[maps.length-1][maps[0].length-1] == 0) ? -1 : distanceInfoArray[maps.length-1][maps[0].length-1];
    }
    
    public static class Node {
        // x, y 좌표 정보
        int x,y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}