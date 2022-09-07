import java.io.*;
import java.util.Scanner;

public class Task001 {
    public static double result(int number, int degree){
        return (int) Math.pow(number, degree);
    }

    public static void file_read() throws Exception {
        FileReader file_read = new FileReader("input.txt");
        Scanner scan = new Scanner(file_read);
        int number = 0;
        int degree = 0;
        while (scan.hasNextLine()) {
            String data_line = scan.nextLine();
            String[] data_file = data_line.split(" ");
            if (data_file[0].equals("a")){
                number = Integer.parseInt(data_file[1]);
            }
            else if (data_file[0].equals("b")){
                degree = Integer.parseInt(data_file[1]);
            }
        }

        System.out.println(result(number, degree));
        file_read.close();





//        return result(number, degree);
    }


    public static void main(String[] args) throws Exception {
        if (args.length == 0){
            Scanner in = new Scanner(System.in);
            System.out.print("Введите число: ");
            int number = in.nextInt();
            System.out.print("Введите степень числа: ");
            int degree = in.nextInt();
            System.out.printf("Число %d в степени %d равно %.3f", number, degree, result(number, degree));
        }
        else if (args[0].equals("-f")){
            file_read();
        }
        else{
            System.out.print("Вы ввели неверный флаг. Флаг -f для работы с файлом");
        }

    }
}
