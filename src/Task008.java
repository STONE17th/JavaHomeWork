import java.util.Random;

public class Task008 {

    public static class Horse {
        int x, y, id, move;
        int[][] step = {{2,1}, {2,-1}, {-2,1}, {-2,-1}, {1,2}, {1,-2}, {-1,2}, {-1,-2}};
        private final Random rnd = new Random();
        public Horse(int x, int y) {
            this.x = x;
            this.y = y;
            this.id = x * 10 + y;
            this.move = 0;
        }

        public void move(Board board) {
            if (this.move<25) {
                while (true) {
                    int index = this.rnd.nextInt(8);
                    int x = this.x + this.step[index][0];
                    int y = this.y + this.step[index][1];
                    if (x >= 0 && x < board.size && y >= 0 && y < board.size) {
                        if (board.cell[x][y] == 0) {
                            this.x = this.x + this.step[index][0];
                            this.y = this.y + this.step[index][1];
                            break;
                        } else if (this.move > 16 && (board.cell[x][y] == -1 || board.cell[x][y] == -2)) {
                            this.x = this.x + this.step[index][0];
                            this.y = this.y + this.step[index][1];
                            break;
                        }
                    }
                }
            }
        }
    }

    public static class Board{
        int size;
        int[][] cell;

        public Board(int size) {
            this.size = size;
            this.cell = new int [this.size][this.size];
            for (int i = 0; i < this.size; i++)
                for (int j = 0; j < this.size; j++) {
                    if (i == 0 && j == 0) this.cell[j][i] = -2;
                    if (i == this.size - 1 && j == 0) this.cell[j][i] = -2;
                    if (i == this.size - 1 && j == this.size - 1) this.cell[j][i] = -2;
                    if (i == 0 && j == this.size - 1) this.cell[j][i] = -2;
                    if (i == 1 && j == 2) this.cell[j][i] = -1;
                    if (i == 2 && j == 1) this.cell[j][i] = -1;
                    if (i == 2 && j == 3) this.cell[j][i] = -1;
                    if (i == 3 && j == 2) this.cell[j][i] = -1;
                }
        }


        public void print(Horse horse){
            System.out.printf("%d ход\n", horse.move);
            for (int i = 0; i < this.size; i++) {
                for (int j = 0; j < this.size; j++) {
                    System.out.printf("%5d", this.cell[j][i]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void start(int size) {
        Horse horse = new Horse(2, 2);
        Board board = new Board(size);
        nextTurn(board, horse);
    }

    public static void nextTurn(Board board, Horse horse){
        if (horse.move<25) {
            horse.move++;
            board.cell[horse.x][horse.y] = horse.move;
            horse.move(board);
            nextTurn(board, horse);
        }else{
            board.print(horse);
        }
    }

    public static void main(String[] args) {
        int size = 5;
        start(size);
    }
}
