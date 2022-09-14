import java.io.*;
import java.util.Scanner;

public class Task001 {
    public static double pow(int number, int degree) {
        int result = number;
        for (int i = 1; i < degree; i++)
            result *= number;
        return result;
    }

    public static double resultPow(int number, int degree) {
        if (degree > 0) return pow(number, degree);
        else if (degree < 0) return 1 / pow(number, -degree);
        else return 1;
    }

    public static void file_read() throws Exception {
        FileReader file_read = new FileReader("input.txt");
        Scanner scan = new Scanner(file_read);
        int a = 0, b = 0;
        while (scan.hasNextLine()) {
            String data_line = scan.nextLine();
            String[] data_file = data_line.split(" ");
            if (data_file[0].equals("a")) {
                a = Integer.parseInt(data_file[1]);
            } else if (data_file[0].equals("b")) {
                b = Integer.parseInt(data_file[1]);
            }
        }

        System.out.println("Число " + a + " в степени " + b + " равно " + resultPow(a, b));
        file_read.close();
    }


    public static int Parsing(String base, int step){
        int k = 2;
        String digit = "";
        while (!Character.toString(base.charAt(step + k)).equals(",")) {
            digit = digit + Character.toString(base.charAt(step+k));
            k++;
        }
        return Integer.parseInt(digit);
    }

    public static void main(String[] args) throws Exception {
        int a = 0, b = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("Введите число а и степень b (или название файла): ");
        String example = input.nextLine().replace(" ", "") + ",";
        if (example.contains(".txt")) file_read();
        else {
            for (int i = 0; i < example.length() - 1; i++) {
                String base = Character.toString(example.charAt(i)) + Character.toString(example.charAt(i + 1));
                if (base.equals("a="))
                    a = Parsing(example, i);
                if (base.equals("b=")) {
                    b = Parsing(example, i);
                }
            }
            System.out.println("Число " + a + " в степени " + b + " равно " + resultPow(a, b));
        }
    }

}
