package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1520 {

    static int N,M,dp[][],dr[],dc[],map[][];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        dp = new int[M][N];
        dr = new int[]{0,1,0,-1};
        dc = new int[]{1,0,-1,0};

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0]=1;
        dfs(new int[]{0,0});
        System.out.println(dp[M-1][N-1]);
    }

    private static boolean isRange(int r, int c){
        return r>=0&&r<M&&c>=0&&c<N;
    }
    private static void dfs(int[] now){
        if(now[0]==M-1&&now[1]==N-1){
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nr = now[0]+dr[i];
            int nc = now[1]+dc[i];

            if(isRange(nr,nc)&&map[now[0]][now[1]]>map[nr][nc]){
                dp[nr][nc]+=1;
                dfs(new int[]{nr,nc});
            }
        }
    }
}
