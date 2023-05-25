package com.pass.algostudy.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MeetingRoomRetry_20230525 {

    public static class Room implements Comparable<Room>{
        int st, et;
        Room(int st,int et){
            this.st =st;
            this.et =et;
        }
        @Override
        public int compareTo(Room o) {
            if(o.et == this.et){ // 끝나는 시간이 같은 경우 시작시간으로 정렬한다.
                return this.st- o.st;
            } else{
                return this.et - o.et; // 신규 값이 음수일경우 앞으로 정렬된다.
            }
        }
    }

    public static class Main{
        public static int Solution(ArrayList<Room> arr){
            // 정렬
            Collections.sort(arr);
            int result = 0;
            int tmp = 0;

            for(int i=0; i<arr.size(); i++){
                if(arr.get(i).st >= tmp){
                    tmp = arr.get(i).et;
                    result ++;
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb= new Scanner(System.in);
        int k = kb.nextInt();
        ArrayList<Room> arr = new ArrayList<>();
        for(int i=0; i<k; i++){
            int st = kb.nextInt();
            int et = kb.nextInt();
            arr.add(new Room(st,et));
        }
        System.out.println(T.Solution(arr));
    }
}
