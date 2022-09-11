import java.util.Random;
import java.util.Scanner;

public class Task011 {


    public static class Labirint {
        int size;
        int[][] lab;

        public Labirint(int size) {
            lab = new int[size][size];
            this.size = size;
            for (int i = 0; i < size; i++)
                for (int j = 0; j < size; j++) {
                    if (i == 0 || i == size - 1 || j == 0 || j == size - 1)
                        this.lab[j][i] = 1;
                    else {
                        Random rnd = new Random();
                        this.lab[j][i] = rnd.nextInt(0, 2);
                    }
                }
            for (int i = 1; i < size - 2; i++)
                for (int j = 1; j < size - 2; j++) {
                    if (this.lab[i][j - 1] == 0 && this.lab[i][j + 1] == 0) this.lab[i][j] = 0;
                }
        }

        public void checkWave(int x, int y) {
            if (this.lab[x][y] == 0) {
                this.lab[x][y] = 2;
                checkWave(x - 1, y);
                checkWave(x, y - 1);
                checkWave(x + 1, y);
                checkWave(x, y + 1);
            }
        }

        public void wallBreaker() {
            int x, y;
            int[][] steps = {{-1, 0, 0, 2}, {1, 0, 2, 0}, {-1, 0, 2, 0}, {1, 0, 0, 2}, {0, -1, 0, 2}, {0, 1, 2, 0}, {0, -1, 2, 0}, {0, 1, 0, 2}};
            for (y = 1; y < size - 1; y++)
                for (x = 1; x < size - 1; x++)
                    if (this.lab[x][y] == 1)
                        for (int[] step : steps)
                            if (this.lab[x + step[0]][y + step[1]] == step[2] && this.lab[x - step[0]][y - step[1]] == step[3]) {
                                this.lab[x][y] = 0;
                                checkWave(x, y);
                            }
        }

        public int[] startWave() {
            int x, y;
            int[] coord = new int[2];
            for (x = 1; x < size - 1; x++)
                for (y = 1; y < size - 1; y++)
                    if (this.lab[x][y] == 0) {
                        coord[0] = x;
                        coord[1] = y;
                        return coord;
                    }
            return coord;
        }

        public void fillBoard() {
            int x = startWave()[0];
            int y = startWave()[1];
            checkWave(x, y);
            wallBreaker();
            wallBreaker();
        }

        public void print() {
            for (int y = 0; y < size; y++) {
                for (int x = 0; x < size; x++) {
                    if (this.lab[x][y] == 1) System.out.print("|||");
                    else if (this.lab[x][y] == 2) System.out.print("   ");
                    else if (this.lab[x][y] == 0) System.out.print(" 0 ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите размер квадратного лабиринта: ");
        int size = input.nextInt();
        Labirint lab = new Labirint(size);
        lab.fillBoard();
        System.out.println();
        lab.print();
    }

}