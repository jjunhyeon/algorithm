package class4_2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 치킨배달
 * */
public class 치킨배달_15686 {

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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] mapInfo = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                mapInfo[i][j] = Integer.parseInt(row[j]);
                if (mapInfo[i][j] == 1) homeList.add(new Place(i, j));
                else if (mapInfo[i][j] == 2) chickenList.add(new Place(i, j));
            }
        }
        visited = new boolean[chickenList.size()];
        solution(0, 0, visited);
        System.out.println(answer);
        // br.clsoe() 를 하는 것은 리소스 누수를 방지하고 메모를 효율적으로 관리하기 위해 권장되는 것이다.
        // BufferedReader는 파일이나 소켓과 같은 입력 스트림에서 데이터를 읽을 때 사용된다.
        // 닫지 않을 경우 소켓 리소스가 계속 사용 중으로 메모리 누수가 발생할 수 있다.
        br.close();
    }

    public static void solution(int cur, int depth, boolean[] visited) {
        // depth가 M 치킨집 수일때의 치킨거리를 구해야한다.
        if (depth == M) {
            int total = 0;
            for (Place home : homeList) {
                int temp = Integer.MAX_VALUE;
                for (int i = 0; i < chickenList.size(); i++) {
                    if (visited[i]) {
                        int dist = getDistance(home, chickenList.get(i));
                        temp = Math.min(temp, dist);
                    }
                }
                total += temp;
                if (total > answer) {
                    return;
                }

            }
            answer = Math.min(answer, total);
            return;
        }
        // cur 변수붙 시작하게 설정함으로써 현재 위치부터 치킨집을 선택할 수 있도록 한다.
        // 만약 depth 변수부터 시작하게 설정한다면 이전에 선택한 치킨집을 건너뛰지 않고 계속 모든 경우의 수를 선택하므로 중복 선택이 발생할 수 있다.
        // 그러므로 만약 depth 변수만을 가지고 재귀를 호출한다면 시간초과 문제가 발생할 수 있다.
        for (int i = cur; i < chickenList.size(); i++) {
            visited[i] = true;
            solution(i + 1, depth + 1, visited);
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