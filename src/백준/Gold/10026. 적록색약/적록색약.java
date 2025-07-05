
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* 적록색약
* 우선 적록색약의 뜻은 빨간색과 초록색의 차이를 구분하지 못함을 의미한다.
* bfs 문제라고 생각했음
* RGB 색상에 대해 상하좌우로 인접해 있는경우 하나의 구역으로 가정할경우
* 문제에서 주어진 맵에 대해 적록색약과 일반케이스로 탐방한다면 각각 몇개의 구역으로 나뉘어지는지
* 찾아야한다.
* 문제 푸는 방향
* 1. 입력값처리
* - RGB 3개의 값으로 구분지어 돌어온다
* - 2차원 char로 맵을 처리한다.
*
* 2. bfs 탐색
* - 상하좌우로 맵을 탐색해야하므로 bfs 탐색을 한다.
* - 적록색야의 케이스 탐색 후 정상 케이스 탐색
* 
* 3. 정답 리턴
* */
public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int mapSize;
    static int[] xRange = {-1,0,1,0};
    static int[] yRange = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        mapSize = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        map = new char[mapSize][mapSize];
        visited = new boolean[mapSize][mapSize];

        for(int i=0; i<mapSize; i++){
            String row = bf.readLine();
            for(int j=0; j<mapSize; j++){
                map[i][j] = row.charAt(j);
            }
        }

        bf.close();

        // 방문여부를 생성해 모든 지점에 대해 방문이 체크된 순간 loop를 끝내는 방식
        int sum =0;
        for(int i=0; i<mapSize; i++){
            for(int j=0; j<mapSize; j++){
                // 방문하지 않았다면
                if(!visited[i][j]){
                    searchMapByBfs(i,j);
                    sum +=1;
                }
            }
        }

        sb.append(sum).append(" ");
        // 다시 false로 초기화
        visited = new boolean[mapSize][mapSize];
        // mapdml GREEN을 REF로 바꾼다.
        for(int i=0; i<mapSize; i++){
            for(int j=0; j<mapSize; j++){
                if(map[i][j] == 'G'){
                    map[i][j] = 'R';
                }
            }
        }

        int nextSum = 0;
        for(int i=0; i<mapSize; i++){
            for(int j=0; j<mapSize; j++){
                // 방문하지 않았다면
                if(!visited[i][j]){
                    searchMapByBfs(i,j);
                    nextSum +=1;
                }
            }
        }
        sb.append(nextSum);
        System.out.println(sb);
    }

    private static void searchMapByBfs(int row, int col) {
        Queue<int[]> myQ = new LinkedList<>();
        myQ.offer(new int[]{row,col});

        while(!myQ.isEmpty()){
            int[] cur = myQ.poll();
            int curX = cur[0];
            int curY = cur[1];
            for(int i=0; i<4; i++){
                int movedX = curX + xRange[i];
                int movedY = curY + yRange[i];
                if(validateRange(movedX,movedY) && map[movedX][movedY] == map[curX][curY]){
                    visited[movedX][movedY] = true;
                    myQ.offer(new int[]{movedX,movedY});
                }
            }
        }

    }

    private static boolean validateRange(int movedX, int movedY) {
        if(movedX < 0 || movedX >= mapSize || movedY < 0 || movedY >= mapSize || visited[movedX][movedY]) return false;
        else return true;
    }
}
