import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 치킨배달
 * */
public class Main {

    // 맵의 가로,세로 크기
    public static int N;
    // M 선택할 치킨집의 수
    public static int M;

    public static int answer = Integer.MAX_VALUE;
    public static boolean[] visited;
    public static ArrayList<Place> homeList = new ArrayList<>();
    public static ArrayList<Place> chickenList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // bf가 아닌 br로 짓는게 맞음.
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] mapInfo = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] row = bf.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                mapInfo[i][j] = Integer.parseInt(row[j]);
                if (mapInfo[i][j] == 1) homeList.add(new Place(i, j));
                else if (mapInfo[i][j] == 2) chickenList.add(new Place(i, j));
            }
            
        }
        visited = new boolean[chickenList.size()];
        solution(0,0, visited);
        System.out.println(answer);
        bf.close();
    }

        public static void solution(int cur, int depth, boolean[] visited) {
        // depth가 M 치킨집 수일때의 치킨거리를 구해야한다.
        if (depth == M) {
            int total = 0 ;
            for (Place home : homeList) {
                int temp = Integer.MAX_VALUE;
                for (int i=0; i< chickenList.size(); i++) {
                    if(visited[i]) {
                        int dist = getDistance(home, chickenList.get(i));
                        temp = Math.min(temp, dist);
                    }
                }
                total += temp;
                if(total > answer){
                    return ;
                }

            }
            answer = Math.min(answer,total);
            return;
        }

        for (int i = cur; i < chickenList.size(); i++) {
                visited[i] = true;
                solution(i+1 ,depth + 1, visited);
                visited[i] = false;
        }
    }

    public static int getDistance(Place home, Place chicken) {
        return Math.abs(home.x - chicken.x) + Math.abs(home.y - chicken.y);
    }

    public static class Place {
        int x, y;

        Place(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}