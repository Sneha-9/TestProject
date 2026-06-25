package com.sneha.ticTacToe;

public class Board {
    private int row;
    private int column;
    Character arr[][] ;

    Board(int row, int column) {
        this.row = row;
        this.column = column;
        arr = new Character[row][column];
    }

    void assignSymbol(int row, int column, Character ch) {
        arr[row][column] = ch;
    }

    boolean fullOrNot() {
        int f = 0;
        outerloop: for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (arr[i][j] == null) {
                    f = 1;
                    break outerloop;
                }
            }
        }

        if (f == 0)
            return true;
        else
            return false;
    }

    void display() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


    boolean winOrNot() {
        if (winByRow() == true || winByColumn() == true || winByLeftDiagnol() == true || winByRightDiagnol() == true) {
            System.out.println(winByRow()+ " " + winByColumn()+ " " + winByLeftDiagnol() + " " + winByRightDiagnol());
            return true;
        } else {
            return false;
        }
    }

    private boolean winByRow() {

        for (int i = 0; i < row; i++) {

            Character ch = arr[i][0];
            for (int j = 1; j < column - 1; j++) {
                if (arr[i][j] != null && ch != null && arr[i][j] == ch && arr[i][j + 1] == ch) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean winByColumn() {
        for (int i = 0; i < row; i++) {
            Character ch = arr[0][i];
            for (int j = 1; j < column - 1; j++) {
                if (ch != null && arr[i][j] != null && arr[j][i] == ch && arr[j + 1][i] == ch) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean winByLeftDiagnol() {
        int f=0;
        Character leftDiagnol = arr[0][0];
        for (int i = 1; i < row; i++) {

             if (leftDiagnol != null && arr[i][i]!= null && arr[i][i] == leftDiagnol) {
              f++;
            }
        }
        if(f==2 )
            return true;
        else
        return false;
    }

    private boolean winByRightDiagnol() {
        int f=0;
        Character rightDiagnol = arr[0][row - 1];
        for (int i = 1; i < row; i++) {
            for (int j = row - 1 - i; j >= 0; j--) {

                 if (rightDiagnol != null && arr[i][j] != null && arr[i][j] == rightDiagnol) {
                 f++;
                }
                break;
            }
        }
        if(f==2)
            return true;
        else
        return false;
    }
}
