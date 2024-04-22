
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * packageName    : com.pass.boj.study
 * fileName       : 도시분할계획
 * author         : junhyeon
 * date           : 2024-04-22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-22        junhyeon       최초 생성
 */
public class Main {

    static int CITY_COUNT = 0;
    static int[] parent ;
    static int result;
    static PriorityQueue<City> PQ = new PriorityQueue<>(Comparator.comparingInt(t -> t.value));
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        CITY_COUNT = Integer.parseInt(st.nextToken());
        int ROAD_COUNT = Integer.parseInt(st.nextToken());

        parent = new int[CITY_COUNT + 1];
        for(int i=1; i<=CITY_COUNT; i++) parent[i] = i;

        for(int i=0; i<ROAD_COUNT; i++){
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            PQ.offer(new City(start,end,value));
        }

        int max = 0;
        while(!PQ.isEmpty()){
            City cur = PQ.poll();
            if(!isSameParent(cur.start,cur.end)){
                union(cur.start,cur.end);
                // 최소 스패닝 트리는 가장 작은 비용이 드는 것을 먼저 연결(PQ의 정렬에 의해)
                // 가장 마지막에 연결한 요소가 가장 큰 비용
                result += cur.value;
                max = cur.value;
            }
        }
        System.out.println(result - max);
    }

    public static boolean isSameParent(int x, int y){
        int fx = find(x);
        int fy = find(y);
        if(fx == fy) return true;
        return false;
    }

    public static void union(int x, int y){
        int fx = find(x);
        int fy = find(y);
        if(fx != fy){
            parent[fy] = fx;
        }
    }

    public static int find(int x){
        if(x == parent[x]){
            return x;
        } else {
           return parent[x] = find(parent[x]);
        }
    }

    static class City{
        int start;
        int end;
        int value;
        City(int start, int end, int value){
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }
}
