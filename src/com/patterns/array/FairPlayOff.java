package com.patterns.array;

import java.util.Scanner;

public class FairPlayOff {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while(t-->0) {
            int[] skill = new int[4];
            int sMax = Integer.MIN_VALUE, max = sMax;
            int idx1=-1, idx2=-1;
            for(int i=0; i<4; i++) {
                skill[i] = sc.nextInt();
                if(max < skill[i]) {
                    sMax = max;
                    max  = skill[i];
                    idx2 = idx1;
                    idx1 = i;
                }
                if(sMax < skill[i] && skill[i] < max) {
                    sMax = skill[i];
                    idx2 = i;
                }
            }

            //int w1 = Math.max(skill[0], skill[1]);
            //int w2 = Math.max(skill[2], skill[3]);

            System.out.println( (idx1 >= 2 && idx2 <= 1) || (idx1 <= 1 && idx2 >= 2)  ? "YES" : "NO");
        }
    }
}
