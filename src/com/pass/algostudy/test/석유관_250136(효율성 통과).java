package com.pass.algostudy.test;

import java.util.*;


// 석유관 문제를 효율성 개선해서 통과 시킨 코드인데
// 이 방식이 왜 기존 코드보다 효율성이 개선된 코드인지 아직 잘 이해가 안감
class 기출2번 {
    public int[][] map;
    public int[][] oilInfo;
    public int oilIdx = 1;
    public Map<Integer, Integer> oilInfoMap = new HashMap<>();
    public int[] xArray = {-1,0,1,0};
    public int[] yArray = {0,1,0,-1};
    public boolean[][] visited;
    public int row;
    public int col;
    
    public class Place{
        int x,y;
        Place(int x, int y){
            this.x= x;
            this.y= y;
        }
    }
    
    public void bfsSearch(int startX,int startY, boolean[][] visited){
        Queue<Place> myQ = new LinkedList<>();
        
        // map에 담을 col 번호 정보
        myQ.offer(new Place(startX,startY));
        oilInfo[startX][startY] = oilIdx;
        // 시작 지점 처리
        visited[startX][startY] = true;
        int sum =0;
        
        while(!myQ.isEmpty()){
            sum ++;
            Place nowPlace = myQ.poll();
            for(int i=0; i<4; i++){
                int movedX = nowPlace.x + xArray[i];
                int movedY = nowPlace.y + yArray[i];
                                
                // validate moved value
                if(movedX >=0 && movedX < row && movedY >=0 && movedY < col){
                    if(!visited[movedX][movedY] && map[movedX][movedY] == 1){
                        visited[movedX][movedY] = true;
                        oilInfo[movedX][movedY] = oilIdx;
                        myQ.offer(new Place(movedX,movedY));
                    }
                }
                
            }
        }
        oilInfoMap.put(oilIdx++, sum);
    }
    
    public int solution(int[][] land) {
        map = land;
        
        int answer = 0;
        row = land.length;
        col = land[0].length;
        oilInfo = new int[row][col];
        visited = new boolean[row][col];    
        
        for(int i=0; i<col; i++){
            int idx = 0;
            while(idx < row){
                if(map[idx][i] == 1 && !visited[idx][i]){
                    bfsSearch(idx,i,visited);
                }
                idx ++;
            }
        }
        
        for(int i=0; i<col; i++){
            Set<Integer> idxTypes = new HashSet<>();
            int maxCount = 0;
            for(int j=0; j<row; j++){
                if(oilInfo[j][i] != 0) idxTypes.add(oilInfo[j][i]);       
            }
        
            for(Integer item : idxTypes){
                maxCount += oilInfoMap.get(item);
            }
            answer = Math.max(answer, maxCount);
        }
       
        return answer;
    }
    
}
