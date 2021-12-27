package com.patterns.dfs;

import java.io.*;
import java.util.*;

import static sun.misc.Version.print;

public class ProtectSheep {

    static int[][] grid;
    static int dogs=0;
    static int[] dirX = {-1,1,0,0};
    static int[] dirY = {0,0,-1,1};
    static int r;
    static int c;

    public static void main(String[] args) {
        FastIO sc = new FastIO();
        r = sc.nextInt();
        c = sc.nextInt();

        List<int[]> wolves = new ArrayList<>();
        grid = new int[r][c];
        for (int i = 0; i < r; i++) {
            String s = sc.next();
            for(int j=0; j<c; j++) {
                grid[i][j] = s.charAt(j);
                if(grid[i][j] == 'W') {
                    wolves.add(new int[]{i, j});
//                } else if(grid[i][j] == '.') {
//                    grid[i][j] = 'D';
                }
            }
        }

        for (int[] wolf : wolves) {
            if(dfs(wolf, new int[r][c])) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
        printGrid();
    }

    private static boolean dfs(int[] pos, int[][] visited) {
        visited[pos[0]][pos[1]] = 1;
        for(int k=0; k<4; k++) {
            int[] newPos = new int[]{pos[0]+dirX[k], pos[1]+dirY[k]};
            if(newPos[0] >= 0 && newPos[0] < r &&
                    newPos[1] >= 0 && newPos[1] < c &&
                    grid[newPos[0]][newPos[1]] == 'S') {
                return true;
            }
        }
        return false;
    }

    private static void printGrid() {
        Arrays.stream(grid).forEach(row -> {
            Arrays.stream(row).forEach(ele -> {
                if (ele != '.')
                    System.out.printf("%c", ele);
                else
                    System.out.print("D");
            });
            System.out.println();
        });
    }
}

//-----------MyScanner class for faster input----------
class FastIO extends PrintWriter {
    private InputStream stream;
    private byte[] buf = new byte[1 << 16];
    private int curChar, numChars;

    // standard input
    public FastIO() {
        this(System.in, System.out);
    }

    public FastIO(InputStream i, OutputStream o) {
        super(o);
        stream = i;
    }

    // file input
    public FastIO(String i, String o) throws IOException {
        super(new FileWriter(o));
        stream = new FileInputStream(i);
    }

    // throws InputMismatchException() if previously detected end of file
    private int nextByte() {
        if (numChars == -1) throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars == -1) return -1; // end of file
        }
        return buf[curChar++];
    }

    // to read in entire lines, replace c <= ' '
    // with a function that checks whether c is a line break
    public String next() {
        int c;
        do {
            c = nextByte();
        } while (c <= ' ');
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = nextByte();
        } while (c > ' ');
        return res.toString();
    }

    public String nextLine() {
        int c;
        do {
            c = nextByte();
        } while (c < '\n');
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = nextByte();
        } while (c > '\n');
        return res.toString();
    }

    public int nextInt() { // nextLong() would be implemented similarly
        int c;
        do {
            c = nextByte();
        } while (c <= ' ');
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = nextByte();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res = 10 * res + c - '0';
            c = nextByte();
        } while (c > ' ');
        return res * sgn;
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }
}