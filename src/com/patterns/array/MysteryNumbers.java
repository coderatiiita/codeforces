package com.patterns.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MysteryNumbers {

    static int maximum_count(int n, int m, String s) {
        String nS = Integer.toString(n);
        Map<Character, Integer> mp = new HashMap<>();
        Map<Character, Integer> mp2 = new HashMap<>();

        for(char c : s.toCharArray()) {
            if(!mp.containsKey(c)) {
                mp.put(c, 0);
            }
            mp.put(c, mp.get(c)+1);
        }

        mp.put('2', mp.getOrDefault('2', 0) + mp.getOrDefault('5', 0));
        mp.put('5', mp.getOrDefault('2', 0));
        mp.put('6', mp.getOrDefault('6', 0) + mp.getOrDefault('9', 0));
        mp.put('9', mp.getOrDefault('6', 0));

        int ans=Integer.MAX_VALUE;

        for(char c : nS.toCharArray()) {
            if(!mp2.containsKey(c)) {
                mp2.put(c, 0);
            }
            mp2.put(c, mp2.get(c)+1);
        }

        mp2.put('2', mp2.getOrDefault('2', 0) + mp2.getOrDefault('5', 0));
        mp2.put('5', mp2.getOrDefault('2', 0));
        mp2.put('6', mp2.getOrDefault('6', 0) + mp2.getOrDefault('9', 0));
        mp2.put('9', mp2.getOrDefault('6', 0));

        for(char c : mp2.keySet()) {
            if(mp.get(c) < mp2.get(c)) {
                return 0;
            }
            if(mp2.get(c)==0)   continue;
            ans = Math.min(ans, mp.get(c) / mp2.get(c));
        }

        return ans;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String s = sc.next();
            String nS = Integer.toString(n);
            Map<Character, Integer> mp = new HashMap<>();
            Map<Character, Integer> mp2 = new HashMap<>();

            for(char c : s.toCharArray()) {
                if(!mp.containsKey(c)) {
                    mp.put(c, 0);
                }
                mp.put(c, mp.get(c)+1);
            }

            mp.put('2', mp.getOrDefault('2', 0) + mp.getOrDefault('5', 0));
            mp.remove('5');
            mp.put('6', mp.getOrDefault('6', 0) + mp.getOrDefault('9', 0));
            mp.remove('9');

            int ans=Integer.MAX_VALUE;

            for(char c : nS.toCharArray()) {
                if(!mp2.containsKey(c)) {
                    mp2.put(c, 0);
                }
                mp2.put(c, mp2.get(c)+1);
            }

            mp2.put('2', mp2.getOrDefault('2', 0) + mp2.getOrDefault('5', 0));
            mp2.remove('5');
            mp.put('6', mp.getOrDefault('6', 0) + mp.getOrDefault('9', 0));
            mp.remove('9');

            for(char c : mp2.keySet()) {
                if(mp.get(c) < mp2.get(c)) {
                    //System.out.println(0);
                    ans=0;
                    break;
                }
                ans = Math.min(ans, mp.get(c) / mp2.get(c));
            }

            System.out.println(ans);

        }
    }

}