import java.util.Scanner;

public class Main {

    static char[] board = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    static char currentPlayer = 'X';

    public static void main(String[] args) {

            // Menambahkan pesan selamat datang
            System.out.println("-----------------------------");
            System.out.println("   Selamat Datang di Tic-Tac-Toe");
            System.out.println("-----------------------------");

        while (true) {
            displayBoard(board);

            int move = getPlayerMove();
            board[move] = currentPlayer;

            if (checkWinner()) {
                displayBoard(board);
                System.out.println("PEMAIN " + currentPlayer + " WINS!");
                break;
            }

            if (isBoardFull()) {
                displayBoard(board);
                System.out.println("SERI !");
                break;
            }

            GantiPemain();
        }
    }

    static void displayBoard(char[] board) {
        PapanCatur displayBoard = new PapanCatur(board);
        displayBoard.displayBoard();
    }

    static int getPlayerMove() {
        Scanner scanner = new Scanner(System.in);
        int move;
        while (true) {
            System.out.print("Pemain " + currentPlayer + ", Pilih langkahmu  (1-9): ");
            move = scanner.nextInt() - 1;
            if (move >= 0 && move < 9 && board[move] == ' ') {
                break;
            } else {
                System.out.println("Langkah tidak valid. Silakan pilih posisi yang kosong.");
            }
        }
        return move;
    }

    static void GantiPemain() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    static boolean checkWinner() {
        // Check rows
        for (int i = 0; i < 9; i += 3) {
            if (board[i] != ' ' && board[i] == board[i + 1] && board[i] == board[i + 2]) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[i] != ' ' && board[i] == board[i + 3] && board[i] == board[i + 6]) {
                return true;
            }
        }

        // Check diagonals
        if (board[0] != ' ' && board[0] == board[4] && board[0] == board[8]) {
            return true;
        }
        if (board[2] != ' ' && board[2] == board[4] && board[2] == board[6]) {
            return true;
        }

        return false;
    }

    static boolean isBoardFull() {
        for (int i = 0; i < 9; i++) {
            if (board[i] == ' ') {
                return false;
            }
        }
        return true;
    }
}
