package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class boj13706 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger N = new BigInteger(br.readLine());
        BigInteger left = BigInteger.ONE;
        BigInteger right = N;
        BigInteger n = BigInteger.ONE;
        while(n.compareTo(N)!=0){
            n = left.add(right).divide(BigInteger.TWO);
            if(n.pow(2).compareTo(N)==0){
                break;
            }else if(n.pow(2).compareTo(N) == 1){
                right = n;
            }else if(n.pow(2).compareTo(N) == -1){
                left = n;
            }
        }

        System.out.println(n);
    }
}
