import java.util.*;

public class Main {
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
            resultHuman.add(noHeard[i]);
        }

        for(int i=0; i<noSeenCount; i++){
            noSeen[i] = sc.nextLine();
            if(!resultHuman.add(noSeen[i])){
                // 중복된 값이라면 duplicates 리스트에 추가
                filterdHuman.add(noSeen[i]);
            }
        }
        Collections.sort(filterdHuman);
        System.out.println(filterdHuman.size());
        for(int i=0; i<filterdHuman.size(); i++){
            System.out.println(filterdHuman.get(i) + " ");
        }
    }
}
