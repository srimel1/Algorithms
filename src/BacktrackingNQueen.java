import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BacktrackingNQueen {

    public static void main(String[] args) {

        BacktrackingNQueen backtrackingNQueen = new BacktrackingNQueen();
        List<List<String>> res = backtrackingNQueen.solveNQueens(4);

        for ( List ans : res ) {
            System.out.println(ans);
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(board, 0, res);
        return res;
    }


    private void dfs(char[][] board, int colIndex, List<List<String>> res) {

        if(colIndex == board.length) {
            res.add(construct(board));
            return;
        }

        for(int i = 0; i < board.length; i++) {

            if(validate(board, i, colIndex)) {

                // take it
                board[i][colIndex] = 'Q';

                // explore
                dfs(board, colIndex + 1, res);

                // backtrack so we can try other choices
                board[i][colIndex] = '.';
            }

        }
    }

    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    private boolean validate(char board[][], int i, int j) {

        // check the row
        for (int col = 0; col < board[0].length; col++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // check the column
        for ( int row = 0; row < board.length; row++ ) {
            if ( board[row][j] == 'Q') {
                return false;
            }
        }

        // check diagonals
        for ( int row = 0; row < board.length; row++ ) {
            for ( int col = 0; col < board[0].length; col++ ) {
                if ( row+col == i+j && board[row][col] == 'Q' ) {
                    return false;
                }
                if ( row-col == i-j && board[row][col] == 'Q') {
                    return false;
                }
            }
        }

        return true;
    }

}
