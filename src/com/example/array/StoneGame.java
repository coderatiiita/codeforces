package com.example.array;

import java.util.Map;
import java.util.Scanner;

public class StoneGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            int[] power = new int[n];
            int minIdx = -1, maxIdx = -1;
            int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                power[i] = sc.nextInt();
                if (minVal > power[i]) {
                    minVal = power[i];
                    minIdx = i;
                }
                if (maxVal < power[i]) {
                    maxVal = power[i];
                    maxIdx = i;
                }
            }
            int ans = 0;

            if(minIdx > maxIdx) {
                int temp = minIdx;
                minIdx = maxIdx;
                maxIdx = temp;
            }

            if (minIdx+1 <= n-maxIdx) {
                ans += minIdx+1;
                ans += Math.min(maxIdx-minIdx, n-maxIdx);
            } else {
                ans += n-maxIdx;
                ans += Math.min(maxIdx-minIdx, minIdx+1);
            }
            System.out.println(ans);
        }

    }

}