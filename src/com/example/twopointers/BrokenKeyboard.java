package com.example.twopointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BrokenKeyboard {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while(t-->0) {
            String s;
            s = sc.next();
            if(s.length() <= 1) {
                System.out.println(s);
            } else solve(s);
        }
    }

    private static void solve(String s) {
        Set<Character> res = new HashSet<>();
        char[] chars = s.toCharArray();
        for(int i=0; i<chars.length-1; i++) {
            if(chars[i] != chars[i+1]) {
                res.add(chars[i]);
                //res.add(s.charAt(i + 1));
            } else {
                chars[i] = '*';
                i++;
                chars[i] = '*';
            }
        }
        if(chars[chars.length-1] != chars[chars.length-2]) {
            res.add(chars[chars.length-1]);
        }
        StringBuilder sb = new StringBuilder();
        for(Character c : res) {
            sb.append(c);
        }
        char[] resChars = sb.toString().toCharArray();
        Arrays.sort(resChars);
        System.out.println(String.valueOf(resChars));
    }
}