package programmers.level2;

import java.util.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class 호텔대실_155651 {
    
    public class Room implements Comparable<Room> {
        LocalTime startTime;
        LocalTime endTime;
        
        Room(String startTime, String endTime){            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            this.startTime = LocalTime.parse(startTime, formatter);
            this.endTime = LocalTime.parse(endTime, formatter);
        }
        
        @Override
        public int compareTo(Room o){
            return this.startTime.compareTo(o.startTime);                                                   
        }
        
    }
    
    public int solution(String[][] book_time) {

        ArrayList<Room> roomArrayList = new ArrayList<>();
    
        int bookedCount = book_time.length;
        
        for(int i=0; i<bookedCount; i++){
            roomArrayList.add(new Room(book_time[i][0],book_time[i][1]));
        } 
        
        boolean[] checkedRoom = new boolean[bookedCount];
        
        //  시작시간 순 정렬
        Collections.sort(roomArrayList);
        PriorityQueue<LocalTime> answerQ = new PriorityQueue<LocalTime>();
        
        answerQ.offer(roomArrayList.get(0).endTime);
        for(int i=1; i<bookedCount; i++){    
            Room nextRoom = roomArrayList.get(i);
            if(nextRoom.startTime.compareTo(answerQ.peek().plusMinutes(10)) != -1){
                answerQ.poll();
            } 
            answerQ.offer(nextRoom.endTime);
        }
        return answerQ.size();
    }
}
