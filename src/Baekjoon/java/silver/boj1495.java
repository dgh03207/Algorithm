package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1495 {
    static int N,M,answer,V[],dp[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = -1;

        V = new int[N+1];
        dp = new int[M+1];
        Arrays.fill(dp,-1);
        dp[S]=0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            V[i] = Integer.parseInt(st.nextToken());
        }

        getMaxV(0,S);

        System.out.println(answer);

    }
    private static boolean isRange(int n){
        return n>=0&&n<=M;
    }

    private static void getMaxV(int idx,int val){
        Queue<Integer> queue = new LinkedList<>();
        outer:
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if(dp[j]==i-1){
                    if(isRange(j+V[i])) {
                        queue.add(V[i]+j);
                    }if(isRange(j-V[i])){
                        queue.add(j-V[i]);
                    }
                }
            }
            if(queue.isEmpty()) break outer;

            while(!queue.isEmpty()){
                int p = queue.poll();
                dp[p] = i;
                if(i==N){
                    if(answer<p) answer = p;
                }
            }
        }

    }
}
