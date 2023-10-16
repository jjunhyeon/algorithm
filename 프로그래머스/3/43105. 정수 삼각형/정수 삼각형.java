import java.util.*;

class Solution {
    public static boolean[][] visited;
    public static int answer = 0;
    public int solution(int[][] triangle) {
        int answer = 0;
        
        for(int i=triangle.length-1;i>0;i--){
            for(int j=0;j<triangle[i].length-1;j++){
                triangle[i-1][j]+=Math.max(triangle[i][j],triangle[i][j+1]);
            }
        }
        
        return Arrays.stream(triangle)
            .flatMapToInt(Arrays::stream)
            .max().orElseThrow();
    }
}