package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class boj14629 {
    static String Num,answer;
    static Long minResult,targetNum;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        minResult = 9876543210L;
        Num = br.readLine();
        targetNum = Long.parseLong(Num);
        if(targetNum>=minResult){
            System.out.println("9876543210");
        }else if(Num.length()<=10){
            boolean[] numbers = new boolean[10];
            int digit = Num.length();
            dfs(numbers,0,"",digit);
            if(digit!=1){
                dfs(numbers,0,"",digit-1);
            }
            if(digit!=10){
                dfs(numbers,0,"",digit+1);
            }

            System.out.println(Long.parseLong(answer));
        }
    }

    private static void dfs(boolean[] numbers,int idx,String myNum,int Max){
        if(idx==Max){
            Long calNum = Long.parseLong(myNum);
            Long result = Math.abs(calNum-targetNum);
            if(minResult>result){
                minResult = result;
                answer = myNum;
            }
            return;
        }

        for (int i = 0; i <10; i++) {
            if(!numbers[i]){
                numbers[i] = true;
                dfs(numbers,idx+1,myNum+Integer.toString(i),Max);
                numbers[i] = false;
            }
        }
    }
}