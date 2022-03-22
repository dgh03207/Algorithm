package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2293 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[K+1];
        dp[0] = 1;
        for (int i = 0; i < N; i++) {
            int coin = Integer.parseInt(br.readLine());

            for (int j = coin; j <= K; j++) {
                dp[j] += dp[j-coin];
            }
        }

        System.out.println(dp[K]);
    }

}
