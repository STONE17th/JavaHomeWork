import java.util.Random;
import java.util.Scanner;

public class Task008 {

    public static class Horse {
        int x, y, id, move;
        int[][] step = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
        private final Random rnd = new Random();

        public Horse(int x, int y) {
            this.x = x;
            this.y = y;
            this.id = x * 10 + y;
            this.move = 1;
        }
        public boolean checkEmptyCell(Board board){
            for (int i=0; i<8; i++){
                int x = this.x + this.step[i][0];
                int y = this.y + this.step[i][1];
//                System.out.printf("x = %d, y = %d\n", x, y);
                if (x >= 0 && x < board.size && y >= 0 && y < board.size){
                    if (board.cell[x][y] <= 0) {
                        return false;
                    }
                }
            }
            return true;
        }
        public void corner(Board board, int corner) {
            while (true) {
                for (int i = 0; i < 8; i++) {
                    int x = this.x + this.step[i][0];
                    int y = this.y + this.step[i][1];
                    if (x >= 0 && x < board.size && y >= 0 && y < board.size) {
                        if (board.cell[x][y] == corner) {
                            this.x = x;
                            this.y = y;
                            return;
                        }
                    }
                }
            }
        }

        public void move(Board board) {
            if (this.move <= board.size*board.size) {
                while (true) {
                    int index = this.rnd.nextInt(8);
                    int x = this.x + this.step[index][0];
                    int y = this.y + this.step[index][1];
                    if (x >= 0 && x < board.size && y >= 0 && y < board.size) {
                        if (board.cell[x][y] == 0) {
                            this.x = x;
                            this.y = y;
                            return;
                        }
                        else if (board.cell[x][y] == -1){
                            this.x = x;
                            this.y = y;
                            board.cell[this.x][this.y] = this.move;
                            this.move++;
                            corner(board, -2);
                            board.cell[this.x][this.y] = this.move;
                            corner(board, -1);
                            board.cell[this.x][this.y] = this.move;
                            this.move++;
                            return;
                        }
                    }
                }
            }
        }
    }

    public static class Board {
        int size;
        int[][] cell;

        public Board(int size) {
            this.size = size;
            this.cell = new int[this.size][this.size];
            for (int i = 0; i < this.size; i++)
                for (int j = 0; j < this.size; j++) {
                    if (i == 0 && j == 0) this.cell[j][i] = -2;
                    if (i == this.size - 1 && j == 0) this.cell[j][i] = -2;
                    if (i == this.size - 1 && j == this.size - 1) this.cell[j][i] = -2;
                    if (i == 0 && j == this.size - 1) this.cell[j][i] = -2;
                    if (i == 1 && j == 2) this.cell[j][i] = -1;
                    if (i == 2 && j == 1) this.cell[j][i] = -1;
                    if (i == 1 && j == this.size-3) this.cell[j][i] = -1;
                    if (i == 2 && j == this.size-2) this.cell[j][i] = -1;
                    if (i == this.size-3 && j == 1) this.cell[j][i] = -1;
                    if (i == this.size-2 && j == 2) this.cell[j][i] = -1;
                    if (i == this.size-3 && j == this.size-2) this.cell[j][i] = -1;
                    if (i == this.size-2 && j == this.size-3) this.cell[j][i] = -1;
                }
        }


        public void print(Horse horse) {
            System.out.printf("%d ход, x= %d, y = %d\n", horse.move-1, horse.x, horse.y);
            for (int i = 0; i < this.size; i++) {
                for (int j = 0; j < this.size; j++) {
                    System.out.printf("%5d", this.cell[j][i]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void start() {
        int xpos = 2;
        int ypos = 2;
        Board board = null;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер поля: ");
        int size = in.nextInt();
        Horse horse = new Horse(xpos, ypos);
        while(horse.move<size*size+1) {
            horse.move = 1;
            board = new Board(size);
            nextTurn(board, horse);
        }
        assert board != null;
        board.print(horse);
    }

    public static void nextTurn(Board board, Horse horse) {
        if (horse.checkEmptyCell(board)) {
            return;
        }
        if (horse.move <= board.size*board.size) {
            horse.move(board);
            board.cell[horse.x][horse.y] = horse.move;
            horse.move++;
            nextTurn(board, horse);
        }
    }

    public static void main(String[] args) {
        start();
    }
}
