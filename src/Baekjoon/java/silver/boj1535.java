package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj1535 {


    static int N,answer,myInfo[][];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        myInfo = new int[N][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            myInfo[i][0] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            myInfo[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(myInfo,Comparator.comparingInt(o1->o1[0]));

        sayHi(-1,0,0);

        System.out.println(answer);
    }

    private static void sayHi(int i,int l,int j){
        if(l>=100) return;

        for (int k = i+1; k < N; k++) {
            sayHi(k,l+myInfo[k][0],j+myInfo[k][1]);
            if(answer<j)answer = j;
        }
        if(answer<j)answer = j;
    }

}
