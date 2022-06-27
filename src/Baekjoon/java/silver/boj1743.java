package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1743 {
    static int N,M,K,maxCnt,cnt;
    static boolean[][] isChecked,map;
    static int[] dr = new int[]{0,0,-1,1};
    static int[] dc = new int[]{-1,1,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Queue<int[]> queue = new LinkedList<>();
        map = new boolean[N+1][M+1];
        isChecked = new boolean[N+1][M+1];
        maxCnt = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = true;
            queue.add(new int[]{a,b});
        }
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(!isChecked[now[0]][now[1]]){
                cnt=1;
                dfs(now);
                if(maxCnt< cnt) maxCnt = cnt;
            }
        }
        System.out.println(maxCnt);
    }

    private static void dfs(int[] now){

        isChecked[now[0]][now[1]]=true;
        for (int i = 0; i < 4; i++) {
            int nr = now[0]+dr[i];
            int nc = now[1]+dc[i];
            if(isRange(nr,nc)&&map[nr][nc]&&!isChecked[nr][nc]){
                cnt+=1;
                dfs(new int[]{nr,nc});
            }
        }
    }

    private static boolean isRange(int n, int m){
        return n>=0&&n<=N&&m>=0&&m<=M;
    }

}
