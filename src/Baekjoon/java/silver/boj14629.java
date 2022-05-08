package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class boj14629 {
    static String Num,answer;
    static BigInteger minResult;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Num = br.readLine();
        minResult = new BigInteger("9876543210");
        BigInteger bigN = new BigInteger(Num);
        if(Num.length()>10||bigN.compareTo(minResult)>=0){
            System.out.println(minResult);
        }else{
            boolean[] numbers = new boolean[10];

            dfs(numbers,0,"");
            System.out.println(answer);
        }
    }

    private static void dfs(boolean[] numbers,int idx,String myNum){
        if(idx==Num.length()){
            BigInteger bigmyNum = new BigInteger(myNum);
            BigInteger bigN = new BigInteger(Num);
            BigInteger result = bigmyNum.subtract(bigN).abs();
            if(result.compareTo(minResult)<0){
                minResult = result;
                answer = myNum;
            }
        }
        for (int i = 0; i <10; i++) {
            if(!numbers[i]){
                numbers[i] = true;
                dfs(numbers,idx+1,myNum+Integer.toString(i));
                numbers[i] = false;
            }
        }
    }
}
