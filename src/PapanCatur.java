public class PapanCatur {

    private char[] board;
    public PapanCatur(char[] board) {
        this.board = board;
    }

    public void displayBoard(){
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("--|---|--");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("--|---|--");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
    }
}
