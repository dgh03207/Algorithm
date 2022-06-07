package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj7682 {
    static char[][] board;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        board = new char[3][3];
        String line = "";

        while(true){
            line = br.readLine();
            //end 만나면 끝내기
            if(line.equals("end")) break;
            int Xcnt = 0;
            int Ocnt = 0;
            int emptycnt = 0;
            String answer= "valid";
            //보드에 정보 담기
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = line.charAt(3*i+j);
                    if(board[i][j]=='X') Xcnt++;
                    else if(board[i][j]=='O') Ocnt++;
                    else if(board[i][j]=='.') emptycnt++;
                }
            }
            if((emptycnt==0&&Xcnt!=5&&Ocnt!=4)
                    ||(Xcnt<Ocnt)){
                answer="invalid";
            }else{
                if(Xcnt-Ocnt==1||Xcnt-Ocnt==0){
                    boolean Xflag = false;
                    boolean Oflag = false;
                    Xflag = checkBoard('X');
                    Oflag = checkBoard('O');

                    if(Xcnt==5&&Ocnt==4){
                        if(Oflag) answer = "invalid";

                    }else if(Xcnt>Ocnt){
                        if(Oflag) answer = "invalid";
                        else if(!Xflag) answer = "invalid";
                    }else if(Xcnt==Ocnt){
                        if(!Oflag||Xflag) answer = "invalid";
                    }
                }else{
                    answer = "invalid";
                }
            }
            sb.append(answer).append("\n");

        }
        System.out.println(sb.toString());

    }

    private static boolean checkBoard(char target){
        if(checkHorizontal(target)||checkVertical(target)||checkDiagonal(target)) {
            return true;
        }

        return false;
    }

    private static boolean checkDiagonal(char target) {
        boolean result = false;
        if(board[1][1]==target) {
            if(board[0][0]==target&&board[2][2]==target) result = true;
            else if(board[0][2]==target&&board[2][0]==target) result = true;
        }
        return result;
    }

    private static boolean checkVertical(char target) {
        boolean result = false;
        for (int i = 0; i < 3; i++) {
            if(board[0][i]==target){
                result = true;
                for (int j = 1; j < 3; j++) {
                    if(board[j][i]!=target){
                        result = false;
                        break;
                    }
                }
            }
        }
        return result;
    }

    private static boolean checkHorizontal(char target) {
        boolean result = false;
        for (int i = 0; i < 3; i++) {
            if(board[i][0]==target){
                result = true;
                for (int j = 1; j < 3; j++) {
                    if(board[i][j]!=target){
                        result = false;
                        break;
                    }
                }
            }
        }

        return result;
    }

}
