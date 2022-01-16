package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2469 {

    static boolean[][] ladder;
    static int target,k,n;
    static String middle[];
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        String[] answer = br.readLine().split("");
        System.out.println(Arrays.toString(answer));
        boolean[][] ladder = new boolean[n][k];
        middle = new String[k];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            if(line[0].equals("?")) target = i;
            for (int j = 0; j < k-1; j++) {
                if(line[j].equals("-")) ladder[i][j]=true;
            }
        }

        for (int i = 0; i < k-1; i++) {
            ghostleg(n-1,i,answer[i]);
        }
    }
    private static boolean isRange(int n1,int k1){
        return n1>=0&&n1<n&&k1>=0&&k1<k;
    }
    private static void ghostleg(int a, int b,String word){
        if(a==target){
            middle[b] = word;
            return;
        }

        if(isRange(a-1,b-1)&&ladder[a-1][b-1]) ghostleg(a-1,b-1,word);
        if(isRange(a-1,b)&&ladder[a-1][b]) ghostleg(a-1,b,word);
    }
}
