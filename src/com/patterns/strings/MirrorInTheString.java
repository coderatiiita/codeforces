package com.patterns.strings;

import java.util.Scanner;

public class MirrorInTheString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            if (n == 1) {
                System.out.println(s + s);
                continue;
            } else if(s.charAt(0) == s.charAt(1)) {
                System.out.print(s.charAt(0));
                System.out.println(s.charAt(0));
                continue;
            }
            char[] arr = s.toCharArray();
            int idx = 0;
            while (idx < s.length() - 1 && arr[idx] >= arr[idx + 1]) {
                idx++;
            }

            StringBuilder sb = new StringBuilder(s.substring(0, idx + 1));
            StringBuilder sb2 = new StringBuilder(sb);
            sb2.append(sb.reverse());

            System.out.println(sb2.toString());
        }
    }
}
