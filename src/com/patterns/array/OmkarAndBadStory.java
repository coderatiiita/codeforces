package com.patterns.array;

import java.util.*;

public class OmkarAndBadStory {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {
            int n;
            n = sc.nextInt();
            List<Integer> a = new ArrayList<>();
            boolean  negativeNumbers = false;
            for(int i=0; i<n; i++) {
                a.add(sc.nextInt());
                if(a.get(i) < 0) {
                    negativeNumbers = true;
                }
            }

            int max = a.stream().max(Integer::compare).get();

            if(negativeNumbers || max >= 300) {
                System.out.println("No");
                continue;
            }

            System.out.println("Yes");
            System.out.println(max+1);
            for(int i=0; i<=max; i++) {
                System.out.printf("%d ", i);
            }
            System.out.println();
        }
    }
}