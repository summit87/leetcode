import java.util.Arrays;

public class MSSolution {
    public static void main(String[] args) {
        int n = 6;
        int x = 1;
        int y = 2;
        String s = "rrlrlr";

        System.out.println(distinctMoves(n, x, y, s)); // expected 3
    }

     static final long MOD = 1_000_000_007L;

    public static int distinctMoves(int n, int x, int y, String s) {
        long[] dp = new long[n + 1];
        dp[x] = 1;

        for (char c : s.toCharArray()) {
            long[] next = Arrays.copyOf(dp, dp.length); // skipping char keeps dp

            for (int pos = 0; pos <= n; pos++) {
                long ways = dp[pos];
                if (ways == 0) continue;

                if (c == 'l') {
                    if (pos - 1 >= 0) {
                        next[pos - 1] = (next[pos - 1] + ways) % MOD;
                    }
                } else { // 'r'
                    if (pos + 1 <= n) {
                        next[pos + 1] = (next[pos + 1] + ways) % MOD;
                    }
                }
            }
            dp = next;
        }

        return (int) (dp[y] % MOD);
    }
}
