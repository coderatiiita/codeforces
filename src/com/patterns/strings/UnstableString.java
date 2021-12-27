package com.patterns.strings;

import java.util.Arrays;
import java.util.Scanner;

public class UnstableString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {
            StringBuilder sb = new StringBuilder(sc.next());
            System.out.println(count(sb));
        }

    }

    private static long count(StringBuilder sb) {
        int n = sb.length();
        int[][] dp = new int[2][n+1];
        int[] dpp = new int[n+1];
        Arrays.fill(dp[0], 0);
        Arrays.fill(dp[1], 0);
        Arrays.fill(dpp, 0);

        switch (sb.charAt(0)) {
            case '0':
                dp[0][0] = 1;
                dp[1][0] = 0;
                break;
            case '1':
                dp[0][0] = 0;
                dp[1][0] = 1;
                break;
            case '?':
                dp[0][0] = dp[1][0] = dpp[0] = 1;
                break;
        }

        for(int i=1; i<n; i++) {
            switch (sb.charAt(i)) {
                case '0':
                    dp[0][i] = dp[1][i-1] + 1;
                    dp[1][i] = 0;
                    break;
                case '1':
                    dp[0][i] = 0;
                    dp[1][i] = dp[0][i-1] + 1;
                    break;
                case '?':
                    dp[0][i] = dp[1][i-1]+1;
                    dp[1][i] = dp[0][i-1] +1;
                    dpp[i] = dpp[i-1]+1;
                    break;
            }
        }
        long ans=0;
        for(int i=0; i<n; i++) {
            ans += dp[0][i] + dp[1][i] - dpp[i];
        }
        return ans;
    }

}