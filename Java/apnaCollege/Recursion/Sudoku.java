package Java.apnaCollege.Recursion;

import java.util.Scanner;

public class Sudoku {

    public static boolean isSafe(char[][] board, int row, int column, int number){
        
        //Row and Column
        for(int i=0; i<board.length; i++){
            if(board[i][column]==(char)(number+'0')){
                return false;
            }
            if(board[row][i]==(char)(number+'0')){
                return false;
            }
        }

        //Grid
        int startRow=(row/3) * 3;
        int startColumn=(column/3) * 3;

        for(int i=startRow; i<startRow+3; i++){
            for(int j=startColumn; j<startColumn+3; j++){
                if(board[i][j]==(char)(number+'0')){
                    return false;
                }
            }
        }

        return true;

    }

    public static boolean helper(char[][] board, int row, int column){
        
        if(row==board.length){
            return true;
        }

        int newRow=0, newColumn=0;

        if(column!=board.length-1){
            newRow=row;
            newColumn= column + 1;
        }
        else{
            newRow= row + 1;
            newColumn=0;
        }

        if(board[row][column]!='.'){
            if(helper(board, newRow, newColumn)){
                return true;
            }
        }
        else{
            for(int i=1; i<=9; i++){
                if(isSafe(board, row, column, i)){
                    board[row][column]=(char)(i+'0');
                    if(helper(board, newRow, newColumn)){
                        return true;
                    }
                    else{
                        board[row][column]= '.';
                    }
                }
            }
        }

        return false;
    }

    public static void solveSudoku(char[][] board){

        helper(board, 0, 0);
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        char[][] board=new char[9][9];

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                board[i][j]=sc.next().charAt(0);
            }
        }

        solveSudoku(board);

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
