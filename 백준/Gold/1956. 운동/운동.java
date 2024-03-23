
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Town>> townInfo = new ArrayList<>();
    static int[][] distanceArray;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int townCnt = Integer.parseInt(st.nextToken());
        int lineCnt = Integer.parseInt(st.nextToken());

        // town 수만큼 초기화
        for (int i = 0; i <= townCnt; i++) {
            townInfo.add(new ArrayList<>());
        }

        // 1. 맵 기본정보 처리
        for (int i = 0; i < lineCnt; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            // from to end + 거리 정보 담는다.
            townInfo.get(from).add(new Town(end, distance));
        }
        distanceArray = new int[townCnt + 1][townCnt + 1];

        for (int i = 1; i <= townCnt; i++) {
            Arrays.fill(distanceArray[i], Integer.MAX_VALUE);
        }

        for (int i = 1; i <= townCnt; i++) getTownPath(i);

        int answer = Integer.MAX_VALUE;

        for (int i = 1; i <= townCnt; i++) {
            for (int j = 1; j <= townCnt; j++) {
                if (i == j) answer = Math.min(answer, distanceArray[i][j]);
            }
        }
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static void getTownPath(int start) {
        // 2. 기본정보륿 바탕으로 1부터 townCnt 만큼의 최단 거리를 도출한다.
        // 시작지점은 0으로 시작한다.
        // 최단거리 도출을 위한 다익스트라 알고리즘 시작
        PriorityQueue<Town> pq = new PriorityQueue<>();
        // 처음 시작지점은 1 그리고 자기자신의 거리는 0
        pq.offer(new Town(start, 0));

        while (!pq.isEmpty()) {
            Town curTown = pq.poll();

            // 만약 이미 지금 현재 마을에서 타겟마을까지의 거리가 더 작은 값이 들어가 있다면 continue;
            if (distanceArray[start][curTown.target] < curTown.distance) {
                continue;
            }

            // 그렇지 않다면 현재 타겟 노드의 정보를 탐색한다.
            for (Town t : townInfo.get(curTown.target)) {
                // 현재 마을의 거리정보와 타겟의 거리 정보의 합이 최종 거리 정보보다 작을경우가 갱신의 조건
                if (distanceArray[start][t.target] > curTown.distance + t.distance) {
                    distanceArray[start][t.target] = curTown.distance + t.distance;
                    pq.offer(new Town(t.target, curTown.distance + t.distance));
                }
            }
        }

    }

    static class Town implements Comparable<Town> {
        int target;
        int distance;

        Town(int target, int distance) {
            this.target = target;
            this.distance = distance;
        }

        @Override
        public int compareTo(Town o) {
            // 맵의 거리 값을 기준으로 정렬할 수 있도록 조건을 잡아준다.
            // 기존값의 거리 - 신규 값의 거리 정렬
            // 거리 값이 작은 순서로 정렬
            return distance - o.distance;
        }
    }
}
