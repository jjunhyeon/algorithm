import java.util.*;

class Solution {
    
    public static int[][] parkIntMap;
    public static Map<String, String> directionMap = new HashMap<>();
    public int[] solution(String[] park, String[] routes) {
        
        // map 정보 세팅
        directionMap.put("E","0 1");
        directionMap.put("W","0 -1");
        directionMap.put("S","1 0");
        directionMap.put("N","-1 0");

        //  가로, 세로 정보
        int parkWidth = park.length;
        int parkLength = park[0].length();
        
        // int[][] map
        parkIntMap = new int[parkWidth][parkLength];
        
        // 시작지점
        int startX = 0;
        int startY = 0;
        
        for(int i=0; i<parkWidth; i++){
            String parkInfo = park[i];
            for(int j=0; j<parkLength; j++){
                char c = parkInfo.charAt(j);
                // 시작지점 처리
                if(c == 'S'){
                  startX = i;
                  startY = j;  
                  parkIntMap[i][j] = -1;
                } else if(c == 'O'){
                    // 갈 수 있는곳 O -> 1
                  parkIntMap[i][j] = 1;                     
                }  // 그 외 갈 수 없는곳은 자동 0 처리
            }
        }
        
    
        int[] answer = getFinalDistance(parkIntMap,routes,startX,startY);
        return answer;
    }
    
    // int map과 routes 정보로 최종 위치를 구한다.
    public static int[] getFinalDistance(int[][] parkIntMap, String[] routes,int startX,int startY){
        
        int beforeMovedX = startX;
        int beforeMovedY = startY;
        
        // move
        for(String route : routes){
        
            boolean isCanGo = true;
            String direction = route.split(" ")[0];
            String movedXY = directionMap.get(direction);
            
            // 이동해야할 위치값
            int directionValue = Integer.parseInt(route.split(" ")[1]);

            for(int i=0; i<directionValue; i++){
                int afterMovedX = beforeMovedX + Integer.parseInt(movedXY.split(" ")[0]) * (i +1);
                int afterMovedY = beforeMovedY + Integer.parseInt(movedXY.split(" ")[1]) * (i +1);
                if(!checkPlaceVerification(afterMovedX,afterMovedY)){ // 거짓이라면, 못감
                    isCanGo = false;
                    break;
                }
            }
            
            if(isCanGo){
                beforeMovedX += Integer.parseInt(movedXY.split(" ")[0]) * directionValue;
                beforeMovedY += Integer.parseInt(movedXY.split(" ")[1]) * directionValue;
            }
        }
        
        int[] answer = {beforeMovedX, beforeMovedY};
        return answer;
    }
    
    // 해당 위치가 장애물인지 검증
    public static boolean checkPlaceVerification(int x, int y){
       // 정상범위 이면서 장애물이아니라면 true
       if(x >=0 && x < parkIntMap.length && y >=0 && y < parkIntMap[0].length && parkIntMap[x][y] != 0) {
           return true;
       }  
       return false;
    }
}