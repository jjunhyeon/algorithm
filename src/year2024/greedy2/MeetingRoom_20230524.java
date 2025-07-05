package src.year2024.greedy2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * 한개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표롤 만든다.
 * 회의가 겹치지 않게 하면서 회이실을 사용할 수 있는 최대수의 회의를 찾아라.
 * 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
 * */
public class MeetingRoom_20230524 {

    static class Room implements Comparable<Room> {
        int starTime, endTime;

        Room(int starTime, int endTime) {
            this.starTime = starTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Room o) {
            if (this.endTime == o.endTime) {
                return this.starTime - o.starTime;
            } else {
                return this.endTime - o.endTime;
            }
        }
    }

    static class Main {
        public static int Solution(int k, ArrayList<Room> arr) {
            Collections.sort(arr);
            int result = 0;
            int et = 0;
            for (int i = 0; i < arr.size(); i++) {
                // 이전 종료시간과 그다음 시작시간이 같다면
                if (et <= arr.get(i).starTime) {
                    // target값을 그 시작시간의 종료시간으로 바꿈
                    et = arr.get(i).endTime; // 값을 대체하고 result 증가
                    result++;
                }
            }
            return result;
        }
    }

        public static void main(String[] args) {
            Main T = new Main();
            Scanner kb = new Scanner(System.in);
            int k = kb.nextInt();
            ArrayList<Room> arr = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                int s = kb.nextInt();
                int e = kb.nextInt();
                arr.add(new Room(s, e));
            }
            System.out.println(T.Solution(k, arr));
        }
    }
