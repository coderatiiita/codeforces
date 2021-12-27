package com.patterns.dp;

import java.util.Arrays;
import java.util.Scanner;

public class NewYearsNumber {

    static String[] memo = new String[1000001];

    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        Arrays.fill(memo, null);

        while (t-- > 0) {
            int n;
            n = sc.nextInt();
            System.out.println(solve(n));
        }
    }

    private static String solve(int n) {
        if(memo[n] != null) {
            return memo[n];
        }
        if(n<2020) {
            memo[n] = "NO";
            return "NO";
        }
        if(n==2020 || n==2021) {
            memo[n] = "YES";
            return "YES";
        }
        if("YES".equals(solve(n-2020)) || "YES".equals(solve(n-2021))) {
            memo[n] = "YES";
        } else {
            memo[n] = "NO";
        }
        return memo[n];
    }
}
