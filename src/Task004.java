import java.io.IOException;
import java.util.Scanner;

public class Task004 {
    public static class Pyramid {
        int[][] pyramids;
        int step, size;

        public Pyramid(int size) {
            this.step = 0;
            this.size = size;
            this.pyramids = new int[3][size];
            for (int i=0; i<size; i++)
                this.pyramids[0][i] = i+1;
        }

        public void changePyramid (int start, int finish, boolean view) throws IOException {
            int temp1 = 0, temp2 = 0, i, j;
            this.step++;
            if (view) {
                if (this.step == 1) System.out.println("Чтобы начать - нажмите любую клавишу");
                else System.out.println("Для следующего шага - нажмите любую клавишу");
                System.in.read();
            }
            for (i = 0; i < this.size; i++) {
                if (this.pyramids[start][i] != 0) {
                    temp1 = this.pyramids[start][i];
                    break;
                }
            }
            for (j = this.size - 1; j > 0; j--) {
                if (this.pyramids[finish][j] == 0) {
                    temp2 = this.pyramids[finish][j];
                    break;
                }
            }
            this.pyramids[start][i] = temp2;
            this.pyramids[finish][j] = temp1;
            this.print();
        }

        public void print(){
            System.out.printf("Шаг #%d\n", this.step);
            for (int i = 0; i < this.size; i++) {
                for (int j = 0; j < 3; j++) {
                    String value;
                    if (this.pyramids[j][i] == 0) value = "|";
                    else value = Integer.toString(this.pyramids[j][i]);
                    System.out.printf("  %s  ", value);
                }
                System.out.println();
            }
            System.out.println("---------------");
        }

        public void move ( int start, int finish, int reserve, int count, boolean view) throws IOException {
            if (count > 1) this.move(start, reserve, finish, count - 1, view);
            this.changePyramid(start, finish, view);
            if (count > 1) this.move(reserve, finish, start, count - 1, view);

        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число блинов: ");
        int count = in.nextInt();
        System.out.print("Пошаговое отображение? (y/n) ");
        String view = in.next();
        boolean viewOption = view.equals("y");
        Pyramid pyramid = new Pyramid(count);
        pyramid.print();
        pyramid.move(0, 2, 1, count, viewOption);
    }
}
