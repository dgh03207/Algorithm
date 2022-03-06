package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2469 {
    static int targetDepth,answer[];
    static String alphabet[],board[][];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        targetDepth = 0;
        board = new String[N][K-1];
        alphabet = new String[N];
        answer= new int[K-1];
        for (int i = 0; i < K; i++) {
            alphabet = br.readLine().split("");
        }

        for (int i = 0; i < K; i++) {
            board[i] = br.readLine().split("");
            if(board[i][0].equals("?")) targetDepth=i;
        }


    }

    private static void getLadder(int now,int depth,int start,int target){
        if(depth<0){
            if(now==start){

            }
            return;
        }

        if(depth==targetDepth){

            board[targetDepth][now-1]="-";
            getLadder(now-1,depth-1,start,now);
            board[targetDepth][now]="-";
            getLadder(now+1,depth-1,start,now);
            board[targetDepth][now]="*";
            board[targetDepth][now-1]="*";
            getLadder(now,depth-1,start,now);
        }else{
            if(now>0&&board[depth][now-1].equals("-")){
                getLadder(now-1,depth-1,start,target);
            }else if(board[depth][now].equals("-")){
                getLadder(now+1,depth-1,start,target);
            }else if(board[depth][now].equals("*")&&board[depth][now-1].equals("*")){
                getLadder(now,depth-1,start,target);
            }
        }
    }

}
