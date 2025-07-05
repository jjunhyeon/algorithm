class Solution {
    static long count =0;
    public long solution(int a, int b) {
        solve(a,b);
        return count;
    }
    
    public void solve(int k, int d) {
        for (int i = 0; i <= d; i++) {
            // 최대거리 값
            if (i % k == 0) {
                int maxValue = (int) Math.sqrt((long) d * d - Math.pow(i, 2));
                // 최대값의 점의 개수 +1은 0,0 처리
                count += (maxValue / k) + 1;
            }
        }
    }
}