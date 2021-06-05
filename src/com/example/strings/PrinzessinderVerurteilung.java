package com.example.strings;

import java.util.*;

public class PrinzessinderVerurteilung {

    static Set<String> mexStrings = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        for(int i=0; i<26; i++) {
            for(int j=0; j<26; j++) {
                for(int k=0; k<26; k++) {
                    char a = (char) ('a' + i);
                    char b = (char) ('a' + j);
                    char c = (char) ('a' + k);
                    StringBuilder sb = new StringBuilder();
                    sb.append(a);
                    sb.append(b);
                    sb.append(c);
                    mexStrings.add(sb.substring(0, 1));
                    mexStrings.add(sb.substring(0, 2));
                    mexStrings.add(sb.toString());
                }
            }
        }
        List<String> ans = new ArrayList<>(mexStrings);
        Collections.sort(ans, (s1, s2) -> {
            if(s1.length() < s2.length()) { return -1; }
            else if(s1.length() > s2.length())  return 1;
            else {
                for (int i=0; i<s1.length(); i++) {
                    if(s1.charAt(i) < s2.charAt(i))
                        return -1;
                    else if(s1.charAt(i) > s2.charAt(i))
                        return 1;
                }
                return 0;
            }
        });

        while (t-- > 0) {
            int n=sc.nextInt();
            StringBuilder sb = new StringBuilder(sc.next());

            for(String key : ans) {
                if(sb.indexOf(key) == -1) {
                    System.out.println(key);
                    break;
                }
            }

        }
    }
}