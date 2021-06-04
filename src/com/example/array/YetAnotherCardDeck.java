package com.example.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class YetAnotherCardDeck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, q;
        n = sc.nextInt();
        q = sc.nextInt();

        List<Integer> colors = new ArrayList<>();

        for(int i=0; i<n; i++) {
            colors.add(sc.nextInt());
        }

        StringBuilder sb=new StringBuilder();

        while(q-->0) {
            int c = sc.nextInt();
            int idx = -1;
            for (int i = 0; i < n; i++) {
                if (colors.get(i) == c) {
                    idx = i;
                    sb.append(i + 1).append(" ");
                    //System.out.println(i + 1);
                    break;
                }
            }
            Collections.rotate(colors.subList(0, idx+1), 1);
        }
        System.out.println(sb);
    }

}