import java.io.IOException;
import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите номер задания: ");
        int number = in.nextInt();
        switch (number) {
            case (1) -> Task001.main(args);
            case (2) -> Task002.main(args);
            case (3) -> Task003.main(args);
            case (4) -> Task004.main(args);
            case (5) -> System.out.printf("Задание %d еще не готово", number);
            case (6) -> Task006.main(args);
            case (7) -> Task007.main(args);
            case (8) -> {
                System.out.println("На досках размером [5, 6, 7, 8, 9] отрабатывает идеально. Выше - 'задумывается'");
                Task008.main(args);
            }
            case (9) -> Task009.main(args);
            case (10) -> System.out.printf("Задание %d еще не готово", number);
            case (11) -> Task011.main(args);
            case (12) -> Task012.main(args);
            case (13) -> System.out.printf("Задание %d еще не готово", number);
            default -> System.out.println("Такого задания нет");
        }
    }
}
