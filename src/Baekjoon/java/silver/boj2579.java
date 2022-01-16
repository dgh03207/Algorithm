package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2579 {

    static int N,stairs[],answer,dp[],cnts[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        stairs = new int[N];
        cnts = new int[N];
        answer = 0;
        dp = new int[N];

        Arrays.fill(dp,0);
        Arrays.fill(cnts,0);
        for (int i = 0; i < N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dfs(0,0,0);
        System.out.println(answer);
    }

    private static void dfs(int n,int cnt,int score){
        if(n==N-1){
            if(answer < score) answer = score;
            return;
        }

        int now = score+stairs[n];

        if(cnt<=2 && n<=N-2) dfs(n+1,cnt+1,now);
        if(n<=N-3) dfs(n+2,0,now);
    }
}
