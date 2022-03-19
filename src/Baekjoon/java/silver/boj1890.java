package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//참고코드 : https://zoonvivor.tistory.com/109
public class boj1890 {
    static int N,board[][];
    static long[][] dp;
    static long answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        board = new int[N][N];
        dp = new long[N][N];
        answer = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0]=1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i==N-1&&j==N-1) continue;
                int next = board[i][j];
                if (i + next < N) {
                    dp[i + next][j] += dp[i][j];
                }
                if (j + next < N) {
                    dp[i][j + next] += dp[i][j];
                }
            }
        }
        System.out.println(dp[N-1][N-1]);
    }
    private static boolean isRange(int a, int b){
        return a>=0&&a<N&&b>=0&&b<N;
    }

}
