package com.patterns.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class TheWayToHome {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n, d;
    n = sc.nextInt();
    d = sc.nextInt();
    String track;
    track = sc.next();
    System.out.println(solve2(track, n, d));
  }

  private static int solve2(String track, int n, int d) {
    int[] dp = new int[n+1];
    Arrays.fill(dp, 100000000);
    List<Integer> startPos = new ArrayList<>();
    for(int i=0; i<track.length(); i++) {
      if(track.charAt(i) == '1') {
        startPos.add(i+1);
      }
    }
    Collections.reverse(startPos);
    for(int i=0; i<startPos.size(); i++) {
      if(startPos.get(i) == n) {
        dp[n] = 0;
        for(int j=1; j<=d && startPos.get(i)-j>=1; j++) {
          if (track.charAt(startPos.get(i) - j - 1) == '1')
            dp[startPos.get(i) - j] = Math.min(dp[startPos.get(i) - j], dp[startPos.get(i)] + 1);
        }
      } else {
        for(int j=1; j<=d && startPos.get(i)-j>=1; j++) {
          if (track.charAt(startPos.get(i) - j - 1) == '1')
            dp[startPos.get(i) - j] = Math.min(dp[startPos.get(i) - j], dp[startPos.get(i)] + 1);
        }
      }
    }
    return dp[1] == 100000000 ? -1 : dp[1];
  }

  private static int solve(String track, int n, int d) {
    Deque<Integer> queue = new ArrayDeque<>();
    queue.add(1);
    int steps = 0;
    while (queue.size() != 0) {
      int qsz = queue.size();
      while(qsz-->0) {
        int pos = queue.pollFirst();
        if(pos == n) {
          return steps;
        }
        for(int i=1; i<=d; i++) {
          if(pos+i <=n && track.charAt(pos+i-1) == '1') {
            queue.offerLast(pos+i);
          }
        }
      }
      steps++;
    }
    return -1;
  }

}
