package leecode;

import java.util.HashSet;

public class Minesweeper {

    public static void main(String[] args) {
        char[][] mine = {{'B', '1', 'E', '1', 'B'},
                {'B', '1', 'M', '1', 'B'},
                {'B', '1', '1', '1', 'B'},
                {'B', 'B', 'B', 'B', 'B'}};

        int[] click = {3,0};

        char[][] b = new Minesweeper().updateBoard(mine, click);
        System.out.println(b);
    }

    public char[][] updateBoard(char[][] board, int[] click) {

        int x = click[0];
        int y = click[1];

        if (board[x][y]=='M') {
            board[x][y]='X';
            return board;
        }

        return updateBoardRec(board, x, y, new HashSet<>());

    }

    public char[][] updateBoardRec(char[][] board, int x, int y, HashSet<String> cache) {

        if (cache.contains(x+"-"+y)) {
            return board;
        }
        if (x<0 || y<0 || x>=board.length || y>=board[x].length) {
            return board;
        }

        int countM = 0;
        // left
        if (x-1>=0 && board[x-1][y]=='M') {
            countM++;
        }

        // right
        if (x+1<board.length && board[x+1][y]=='M') {
            countM++;
        }

        // up
        if (y-1>=0 && board[x][y-1]=='M') {
            countM++;
        }

        // done
        if (y+1<board[x].length && board[x][y+1]=='M') {
            countM++;
        }

        // up left
        if (x-1>=0 && y-1>=0 && board[x-1][y-1]=='M') {
            countM++;
        }

        // down left
        if (x-1>=0 && y+1<board[x-1].length && board[x-1][y+1]=='M') {
            countM++;
        }

        // down right
        if (x+1<board.length && y+1<board[x+1].length && board[x+1][y+1]=='M') {
            countM++;
        }

        // up right
        if (x+1<board.length && 0<=y-1 && board[x+1][y-1]=='M') {
            countM++;
        }

        cache.add(x + "-" + y);

        if (countM>0) {
            board[x][y]= Character.forDigit(countM,10);
        } else {
            board[x][y]= 'B';
            updateBoardRec( board, x+1, y, cache);
            updateBoardRec( board, x-1, y, cache);
            updateBoardRec( board, x, y+1, cache);
            updateBoardRec( board, x, y-1, cache);
            updateBoardRec( board, x+1, y+1, cache);
            updateBoardRec( board, x+1, y-1, cache);
            updateBoardRec( board, x-1, y+1, cache);
            updateBoardRec( board, x-1, y-1, cache);
        }

        return board;
    }

    private void reveil(char[][] board, int[] click) {

        int x = click[0];
        int y = click[1];

        

    }

}
