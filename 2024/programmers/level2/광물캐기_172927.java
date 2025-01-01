package programmers.level2;

import java.util.*;

/*
 * 광물캐기
 * */
public class 광물캐기_172927 {
    public static void main(String[] args) {
        // parma1
        //int[] picks = {1, 3, 2};
        //String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        // return 12
        // parma2
        //int[] picks = {0, 1, 1};
        //String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
        // return 50

        // param 3
        int[] picks = {0, 1, 0};
        String[] minerals = {"diamond", "iron", "iron", "iron", "iron", "diamond", "diamond", "iron", "iron", "iron"};
        // return 10

        //param 4
        //int[] picks = {2, 1, 0};
        //String[] minerals = {"iron", "iron", "stone","iron","iron","iron","diamond","diamond","dimond","iron","stone","stone"};

        //param 5
        /*int[] picks = {1, 1, 0};
        String[] minerals = {"stone", "stone", "iron", "stone", "diamond", "diamond", "diamond", "diamond", "diamond", "diamond"};*/
        int result = secondSolution(picks, minerals);
        System.out.println("what is the result" + result);
    }

    static class Mineral {
        public int tCost;
        public int groupNumber;
        public String[] mineInfo;

        public Mineral(int tCost, int groupNumber, String[] mineInfo) {
            this.tCost = tCost;
            this.groupNumber = groupNumber;
            this.mineInfo = mineInfo;
        }

        @Override
        public String toString() {
            return this.tCost + " " + this.groupNumber + Arrays.toString(this.mineInfo);
        }

    }

    public static int secondSolution(int[] picks, String[] minerals) {

        int[][] map = {
                {1, 1, 1},//dia
                {5, 1, 1},//iron
                {25, 5, 1},//stone
        };
        // 한번에 myQ에 넣기
        Queue<String> myQ = Arrays.stream(minerals)
                .collect(LinkedList::new, Queue::offer, Queue::addAll);

        List<Mineral> totalInfo = new ArrayList<>();
        int idx = 0;
        int gok = picks[0] + picks[1] + picks[2];

        while (!myQ.isEmpty() && gok != 0) {
            int division = (myQ.size() < 5) ? myQ.size() : 5;
            int cost = 0;
            String[] mineInfos = new String[5];
            gok--; // testcase 8 ;;
            for (int i = 0; i < division; i++) {
                String mine = myQ.poll();
                if (mine.equals("diamond")) {
                    cost += 25;
                    mineInfos[i] = mine;
                } else if (mine.equals("iron")) {
                    cost += 5;
                    mineInfos[i] = mine;
                } else {
                    cost += 1;
                    mineInfos[i] = mine;
                }
            }
            totalInfo.add(new Mineral(cost, idx, mineInfos));
            idx++;
        }

        // 그룹 코스트 별로 정렬
        Collections.sort(totalInfo, (a, b) -> (b.tCost - a.tCost));

        // 정렬한 totalinfo의 광물들을 기준으로 다이아 곡괭이부터 쓰며 처리한다.
        int result = 0;

        LinkedList<Integer> tool = new LinkedList<>();

        for (int i = 1; i <= picks[0]; i++) {
            tool.add(0);
        }

        for (int i = 1; i <= picks[1]; i++) {
            tool.add(1);
        }

        for (int i = 1; i <= picks[2]; i++) {
            tool.add(2);
        }

        if (tool.size() == 1) {
            int len = (minerals.length < 5) ? minerals.length : 5;
            for (int i = 0; i < len; i++) {
                if ("diamond".equals(minerals[i])) {
                    result += map[tool.get(0)][0];
                } else if ("iron".equals(minerals[i])) {
                    result += map[tool.get(0)][1];
                } else {
                    result += map[tool.get(0)][2];
                }
            }
            return result;
        }

        int num = -1;
        for (int t : tool) {
            num++;
            if (num >= totalInfo.size()) {
                break;
            }

            for (String target : totalInfo.get(num).mineInfo) {
                if (target == null) {
                    break;
                }

                if ("diamond".equals(target)) {
                    result += map[t][0];
                } else if ("iron".equals(target)) {
                    result += map[t][1];
                } else {
                    result += map[t][2];
                }
            }

        }
        return result;
    }


    public static int firstSolution(int[] picks, String[] minerals) {

        // 한번에 myQ에 넣기
        Queue<String> myQ = Arrays.stream(minerals)
                .collect(LinkedList::new, Queue::offer, Queue::addAll);

        // 정답
        int result = 0;
        int diaPick = picks[0];
        int ironPick = picks[1];
        int stonePick = picks[2];

        while ((!myQ.isEmpty())) {
            // 피로도 처리
            if (diaPick + ironPick + stonePick == 0) {
                break;
            }

            // 그륩별로 우선순위를 구해야한다.

            int idx = 0;
            // 0번부터 4번까지 반환(5개씩 구분해 처리한다.)
            int division = (myQ.size() < 5) ? myQ.size() : 5;
            List<String> mineralDivison = new ArrayList<>(myQ);
            mineralDivison = mineralDivison.subList(idx, division);

            String target = null;
            if (mineralDivison.contains("diamond")) {
                // dia있으므로 dia 보석 컷 하고 그거만치 result에 더하고 5개 짤라낸다.
                target = "diamond";
            } else if (mineralDivison.contains("iron")) {
                // 아이언 사용
                target = "iron";
            } else {
                // 광물 사용
                target = "stone";
            }

            if ("diamond".equals(target) || (ironPick == 0) || (ironPick + stonePick == 0)) {
                if (diaPick != 0) {
                    for (int i = idx; i < division; i++) {
                        myQ.poll();
                        result += 1;
                    }
                    diaPick -= 1;
                    continue;
                }
            }


            if ("iron".equals(target) || diaPick == 0 || stonePick == 0) {
                if (ironPick != 0) {
                    for (int i = idx; i < division; i++) {
                        String tmpMinreal = myQ.poll();
                        if ("diamond".equals(tmpMinreal)) {
                            result += 5;
                        } else {
                            result += 1;
                        }
                    }
                    ironPick -= 1;
                    continue;
                }
            }

            if ("stone".equals(target) || (diaPick + ironPick == 0)) {
                for (int i = idx; i < division; i++) {
                    String tmpMinreal = myQ.poll();
                    if ("diamond".equals(tmpMinreal)) {
                        result += 25;
                    } else if ("iron".equals(tmpMinreal)) {
                        result += 5;
                    } else {
                        result += 1;
                    }
                }
                stonePick -= 1;
                continue;
            }

        }
        return result;
    }
}
