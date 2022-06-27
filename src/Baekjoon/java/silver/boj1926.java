package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1926 {
    static int[] dr = new int[]{0,1,0,-1};
    static int[] dc = new int[]{1,0,-1,0};
    static int N,M;
    static int[][] map;
    static int maxSize;
    static boolean[][] isChecked;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isChecked = new boolean[N][M];
        maxSize=0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int paintCnt=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(isChecked[i][j]) continue;
                isChecked[i][j] = true;
                if(map[i][j]==0) continue;
                isChecked[i][j]=true;
                maxSize=Math.max(maxSize,getSize(i,j));
                paintCnt+=1;
            }
        }

        System.out.println(paintCnt);
        System.out.println(maxSize);
    }

    private static boolean isRange(int r, int c){
        return r>=0&&r<N&&c>=0&&c<M;
    }
    private static int getSize(int r, int c){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r,c});
        int size=1;
        while(!queue.isEmpty()){
            int[] start = queue.poll();
            isChecked[start[0]][start[1]]=true;
            for (int i = 0; i < 4; i++) {
                int nr = start[0]+dr[i];
                int nc = start[1]+dc[i];

                if(isRange(nr,nc)){
                    if(isChecked[nr][nc]) continue;
                    if(map[nr][nc]==0) continue;
                    isChecked[nr][nc]=true;
                    queue.add(new int[]{nr,nc});
                    size+=1;
                }
            }
        }
        return size;
    }
}
