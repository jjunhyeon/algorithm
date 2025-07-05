package src.year2024.test;
import java.util.LinkedList;
import java.util.Queue;


// 문제 링크 : [시추관](https://school.programmers.co.kr/learn/courses/30/lessons/250136)
// 시추관 문제
// 효율성을 고려하지 않은 bfs 풀이
// 개선할 수 있는 코드로 수정해서 재업로드 예정
class Solution {
    public int[][] map;
    public int[] xArray = {-1,0,1,0};
    public int[] yArray = {0,1,0,-1};    
    public int row;
    public int col;
    
    public class Place{
        int x,y;
        Place(int x, int y){
            this.x= x;
            this.y= y;
        }
    }
    
    public int bfsSearch(int startX,int startY, boolean[][] visited){
        Queue<Place> myQ = new LinkedList<>();
        myQ.offer(new Place(startX,startY));

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
                        myQ.offer(new Place(movedX,movedY));
                    }
                }
            }
        }
        return sum;
    }
    
    public int solution(int[][] land) {
        map = land;
        
        int answer = 0;
        row = land.length;
        col = land[0].length;

        for(int i=0; i<col; i++){
            int sum = 0;
            int idx = 0;
            boolean[][] visited = new boolean[row][col];
            while(idx < row){
                if(map[idx][i] == 1 && !visited[idx][i]){
                    int result = bfsSearch(idx,i,visited);
                    sum += result;
                }
                idx ++;
            }
            answer = Math.max(answer,sum);
        }
        return answer;
    }
    
}
