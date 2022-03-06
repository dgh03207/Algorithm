package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//동전 0
public class boj11047 {
    static int K,coins[],coinCnt[],answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coins = new int[N];
        coinCnt = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        getCoins(coinCnt,0,N-1);
        System.out.println(answer);
    }

    private static void getCoins(int[] coinCnt,int value,int index){
        if(value==K){
            answer = Arrays.stream(coinCnt).sum();
            return;
        }

        while((K-value)<coins[index]){
            index-=1;
        }
        for (int i = (int) ((K - value) / coins[index]); i >= 0; i--) {
            coinCnt[index] = i;
            value += coins[index] * i;
            getCoins(coinCnt, value, index - 1);
            break;
        }
    }
}
