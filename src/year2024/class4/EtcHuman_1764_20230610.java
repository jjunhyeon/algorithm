package year2024.class4;

import java.util.*;

public class EtcHuman_1764_20230610 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noHeardCount = sc.nextInt();
        int noSeenCount = sc.nextInt();
        Set<String> resultHuman = new HashSet<>();
        ArrayList<String> filterdHuman =new ArrayList<>();
        sc.nextLine(); // 버퍼에 남아있는 줄 바꿈 문자 소비
        
        String[] noHeard = new String[noHeardCount]; 
        String[] noSeen = new String[noSeenCount];

        for(int i=0; i<noHeardCount; i++){
            noHeard[i] = sc.nextLine();
            resultHuman.add(noHeard[i]); // 각각의 듣도못한 사람, 보도못한 사람은 중복으로 값이 들어오지 않으므로
        }

        for(int i=0; i<noSeenCount; i++){
            noSeen[i] = sc.nextLine();
            if(!resultHuman.add(noSeen[i])){
                // 보도못한 사람을 추가할 때 중복된 값이라면 중복된 사용자 리스트에 추가
                filterdHuman.add(noSeen[i]); // filtered보다 duplicatedHuman이 더 적절할듯
            }
        }

        System.out.println(filterdHuman.size());
        Collections.sort(filterdHuman); // 사전순 정렬 조건
        for(int i=0; i<filterdHuman.size(); i++){
            System.out.println(filterdHuman.get(i) + " ");
        }
    }
}
