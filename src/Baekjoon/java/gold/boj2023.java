package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj2023 {
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        dfs(0,"");
        System.out.println(sb.toString());
    }

    private static void dfs(int cnt,String num){
        if(cnt==N){
            sb.append(num).append("\n");
            return;
        }

        for (int i = 1; i <= 9; i++) {
            String temp = num+Integer.toString(i);
            int tempNum = Integer.parseInt(temp);
            if(isPrime(tempNum)){
                dfs(cnt+1,temp);
            }
        }
    }

    private static boolean isPrime(int num) {
        if(num==1)return false;
        for (int i = 2; i*i <= num; i++) {
            if(num%i==0) return false;
        }
        return true;
    }
}
