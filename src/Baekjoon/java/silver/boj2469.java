package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2469 {
    static int targetDepth,answer[],N,K;
    static boolean board[][];
    static char[] alphabet;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        K = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        targetDepth = 0;
        board = new boolean[N][K-1];
        alphabet = new char[N];
        answer= new int[K-1];
        alphabet = br.readLine().toCharArray();

        for (int i = 0; i < N; i++) {
            int j=0;
            for(char c:br.readLine().toCharArray()){
                if(c=='-') board[i][j] = true;
                else if(c=='?'){
                    targetDepth=i;
                    break;
                }
                j+=1;
            }
        }

        int[] up = new int[K];
        int[] down = new int[K];

        for (int i = 0; i < K;i++) {
            int depth = 0;
            int now =i;
            while(depth<targetDepth){
                if(now>0&&board[depth][now-1]){
                    now-=1;
                }else if(now<K-1&&board[depth][now]){
                    now+=1;
                }
                depth+=1;
            }
            up[now] = i;
        }
        for (int i = 0; i < K;i++) {
            int depth = N-1;
            int now =i;
            while(depth>targetDepth){
                if(now>0&&board[depth][now-1]){
                    now-=1;
                }else if(now<K-1&&board[depth][now]){
                    now+=1;
                }
                depth-=1;
            }
            down[now] = alphabet[i]-65;
        }
        boolean flag = true;
        for (int i = 0; i < K-1; i++) {
            if(up[i]!=down[i]){
                if(i==0){
                    if(!board[targetDepth][i+1]&&up[i+1]==down[i]){
                        board[targetDepth][i]=true;
                        int temp = up[i];
                        up[i]=up[i+1];
                        up[i+1]=temp;
                        sb.append("-");
                    }else{
                        flag = false;
                        break;
                    }
                }else if(i>0&&i<K-2){
                    if(!board[targetDepth][i+1]&&!board[targetDepth][i-1]&&up[i+1]==down[i]){
                        board[targetDepth][i]=true;
                        sb.append("-");
                        int temp = up[i];
                        up[i]=up[i+1];
                        up[i+1]=temp;
                    }else{
                        flag = false;
                        break;
                    }
                }else if(i==K-2){
                    if(!board[targetDepth][i-1]&&up[i+1]==down[i]){
                        board[targetDepth][i] = true;
                        sb.append("-");
                        int temp = up[i];
                        up[i]=up[i+1];
                        up[i+1]=temp;
                    }else{
                        flag = false;
                        break;
                    }
                }else if(i==K-1){
                    flag=false;
                    break;
                }
            }else{
                sb.append("*");
            }
        }
        if(flag){
            System.out.println(sb.toString());
        }else{
            System.out.println("x".repeat(K-1));
        }
    }
}
