package com.patterns.games;

import java.util.*;

public class EvenOddGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            List<Integer> arr = new ArrayList<>();
            long sum=0;
            for(int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }
            arr.sort(Collections.reverseOrder());
            for(int i=0; i<n; i++) {
                if(i % 2 == 0) {
                    if(arr.get(i) %2==0)
                        sum+= arr.get(i);
                } else {
                    if(arr.get(i) % 2 != 0) {
                        sum-= arr.get(i);
                    }
                }
            }
            if(sum==0) {
                System.out.println("Tie");
            } else if(sum>0) {
                System.out.println("Alice");
            } else {
                System.out.println("Bob");
            }
        }
    }
}
