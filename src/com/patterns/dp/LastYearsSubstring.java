package com.patterns.dp;

import java.util.Scanner;

public class LastYearsSubstring {
    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        while(t-->0) {
            int n;
            n = sc.nextInt();
            String s;
            s = sc.next();
            System.out.println(solve(s, n));
        }

    }
    //"20192020" n = 8

    private static String solve(String s, int n) {
        if(n<4) {
            return "NO";
        }
        if(n==4 && "2020".equals(s)) {
            return "YES";
        }
        for(int i=0; i<5; i++) {
            if( (s.substring(0, i) +
                    s.substring(n-4+i, n)).equals("2020")) {
                return "YES";
            }
            //if(s.substring(n-i-4, n-i))
        }
        return "NO";
    }
}
