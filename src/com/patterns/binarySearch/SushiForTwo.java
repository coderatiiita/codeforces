package com.patterns.binarySearch;

import java.util.Scanner;

public class SushiForTwo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] sushi = new int[n];
        for (int i = 0; i < n; i++) {
            sushi[i] = sc.nextInt();
        }
        System.out.println(solve(sushi, n));
    }

    private static int solve(int[] sushi, int n) {
        int maxLen = -1_000_000;
        for(int i=0; i<n-1; i++) {
            //int odd = expand(sushi, i, i, n);
            int even = expand(sushi, i, i+1, n);
            maxLen = Math.max(maxLen, even);
        }
        return maxLen;
    }

    private static int expand(int[] sushi, int l, int r, int n) {
        int eel=0, tuna=0;
        //if(l!=r) {
            switch (sushi[r]) {
                case 1: tuna++; break;
                case 2: eel++; break;
            }
        //}
        switch (sushi[l]) {
            case 1: tuna++; break;
            case 2: eel++; break;
        }
        if(tuna != eel) return 0;
        while(l>0 && r<n-1) {
            if(sushi[l] != sushi[l-1] || sushi[r] != sushi[r+1])    break;
            l--;
            r++;
        }
        return r-l+1;
    }

}
