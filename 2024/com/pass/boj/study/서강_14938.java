package com.pass.boj.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * packageName    : com.pass.boj.study
 * fileName       : 서강_14938
 * author         : junhyeon
 * date           : 2024-04-20
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-20        junhyeon       최초 생성
 */
public class 서강_14938 {
    static ArrayList<ArrayList<Ground>> mapInfo = new ArrayList<>();
    static int answer = 0;
    static int FIND_RANGE = 0;
    static int MAP_COUNT = 0;
    static int ROAD_COUNT = 0;
    static int[] item;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());
        // 맵의 수
        MAP_COUNT = Integer.parseInt(st.nextToken());
        // 수색범위
        FIND_RANGE = Integer.parseInt(st.nextToken());
        // 길의 수
        ROAD_COUNT = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        item = new int[MAP_COUNT + 1];
        for(int i=1; i<=MAP_COUNT; i++) item[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<=MAP_COUNT; i++){
            mapInfo.add(new ArrayList<>());
        }

        for(int i=0; i<ROAD_COUNT; i++){
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            // 양방향 관계
            mapInfo.get(start).add(new Ground(end,dist));
            mapInfo.get(end).add(new Ground(start,dist));
        }

        // 실제 탐색 시작
        for(int i=1; i<=MAP_COUNT; i++){
            answer = Math.max(answer,find(i));
        }
        System.out.println(answer);
    }

    private static int find(int start) {
        int sum = 0;
        PriorityQueue<Ground> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        int[] dis = new int[MAP_COUNT+1];

        for(int i = 1; i<=MAP_COUNT; i++){
            dis[i]= Integer.MAX_VALUE;
        }
        dis[start] = 0;
        pq.add(new Ground(start,0));

        while(!pq.isEmpty()){
            Ground cur = pq.poll();
            if(dis[cur.end] < cur.dist) continue;

            sum += item[cur.end];

            for(Ground next : mapInfo.get(cur.end)){
                // 정점 이동 비용이 갱신되어있는 값보다 작으면서 수색 범위보다 크지 않는 경우
                if(dis[next.end] > dis[cur.end] + next.dist && dis[cur.end] + next.dist <= FIND_RANGE){
                    dis[next.end] = dis[cur.end] + next.dist;
                    pq.offer(new Ground(next.end,dis[next.end]));
                }
            }
        }
        return sum;
    }

    static class Ground{
        private int end;
        private int dist;
        Ground(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }
    }
}
