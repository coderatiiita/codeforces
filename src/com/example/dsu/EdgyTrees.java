package com.example.dsu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class EdgyTrees {

    static class DSU {
        int n;
        int[] parent;
        int[] rank;

        public DSU(int n) {
            this.n = n;
            parent = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }
            rank = new int[n + 1];
            Arrays.fill(rank, 1);
        }

        public int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        public boolean union(int x, int y) {
            int xp = find(x), yp = find(y);

            if (xp == yp) return false;

            if (rank[xp] < rank[yp]) {
                int t = rank[xp];
                rank[xp] = rank[yp];
                rank[yp] = t;
            }

            parent[yp] = xp;
            rank[xp] += rank[yp];
            return true;
        }

        public long size(long i) {
            return (long)rank[find((int)i)];
        }
    }

    public static final long MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int t;
        //t = sc.nextInt();
        //while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            DSU dsu = new DSU(n);

            for(int i=1; i<=n-1; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int color = sc.nextInt();

                if(color == 0)
                    dsu.union(u, v);
            }

            long ans = expMod((long)n, (long)k, MOD) % MOD;
            long rem = 0L;
            Set<Integer> seen = new HashSet<>();
            for (int i=1; i<=n; i++) {
                if(!seen.contains(dsu.find(i))) {
                    rem += expMod((long)dsu.size(i), (long)k, MOD) % MOD;
                    seen.add(dsu.find(i));
                }
            }

            System.out.println((ans-rem%MOD+MOD)%MOD);
        //}
    }

    private static long expMod(long a, long b, long mod) {
        if(b == 0)
            return 1L;

        long val = expMod(a, b / 2, mod);

        if(b % 2 == 0)
            return val * val % mod;
        else
            return val * val % mod * a % mod;
    }

}