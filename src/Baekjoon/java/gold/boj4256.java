package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//트리
public class boj4256 {
    static int[] preorder,inorder;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            preorder = new int[N+1];
            inorder = new int[N+1];

            for (int i = 0; i < N; i++) {
                preorder[i]=Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                inorder[i] = Integer.parseInt(st.nextToken());
            }

            find(0,0,N);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void find(int root, int start, int end){
        int rootIndex = preorder[root];
        for (int i = start; i < end; i++) {
            if(inorder[i] == rootIndex){
                find(root+1,start,i);
                find(root+1+i-start,i+1,end);
                sb.append(rootIndex+" ");
            }
        }
    }
}
