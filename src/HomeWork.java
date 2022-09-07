import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите номер задания: ");
        int number = in.nextInt();
        switch (number) {
            case (1) -> System.out.printf("Задание %d еще не готово", number);
            case (2) -> Task002.main(args);
            case (3) -> Task003.main(args);
            case (4) -> System.out.printf("Задание %d еще не готово", number);
            case (5) -> System.out.printf("Задание %d еще не готово", number);
            case (6) -> System.out.printf("Задание %d еще не готово", number);
            case (7) -> Task007.main(args);
            case (8) -> {
                System.out.println("Частный случай для доски 5*5, универсальное решение в разработке");
                Task008.main(args);
            }
            case (9) -> System.out.printf("Задание %d еще не готово", number);
            case (10) -> System.out.printf("Задание %d еще не готово", number);
            case (11) -> System.out.printf("Задание %d еще не готово", number);
            case (12) -> System.out.printf("Задание %d еще не готово", number);
            case (13) -> System.out.printf("Задание %d еще не готово", number);
            default -> System.out.println("Такого задания нет");
        }
    }
}
