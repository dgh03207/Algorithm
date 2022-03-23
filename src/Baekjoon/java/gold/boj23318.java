package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj23318 {
    static int N,M,a,b,board[][],result[][],cutA[],cutB[],answer,prefixSum[][];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        result = new int[N][M];
        prefixSum = new int[N+1][M+1];
        answer = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        cutA = new int[a+1];
        cutB = new int[b+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j]=Integer.parseInt(st.nextToken());
                prefixSum[i+1][j+1]=board[i][j];
            }
        }

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < M+1; j++) {
                prefixSum[i][j]=prefixSum[i-1][j]+prefixSum[i][j-1]-prefixSum[i-1][j-1]+prefixSum[i][j];
            }
        }

        cutA[a]=N;
        cutB[b]=M;
        combiA(0,1);

        System.out.println(answer);

    }

    private static void combiA(int cnt, int start){
        if(cnt==a){
            combiB(0,1);
            return;
        }

        for (int i = start; i <= N; i++) {
            cutA[cnt]=i;
            combiA(cnt+1,i+1);
        }
    }


    private static void combiB(int cnt, int start){
        if(cnt==b){
            int subSum = 0;
            int N_prev=0;
            int M_prev=0;
            for (int i = 0; i < a+1;i++) {
                M_prev=0;
                for (int j = 0; j < b+1;j++) {
                    subSum = Math.max(getSum(N_prev,cutA[i],M_prev,cutB[j]),subSum);
                    M_prev=cutB[j];
                }
                N_prev=cutA[i];
            }
            answer = Math.min(subSum,answer);
            return;
        }

        for (int i = start; i <= M; i++) {
            cutB[cnt]=i;
            combiB(cnt+1,i+1);
        }
    }

    private static int getSum(int Astart,int Aend,int Bstart,int Bend){
        int sum = 0;
        sum=prefixSum[Aend][Bend]-prefixSum[Aend][Bstart]-prefixSum[Astart][Bend]+prefixSum[Astart][Bstart];
        return sum;
    }
}
