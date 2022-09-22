import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task023 {

    public static Integer arrayLimitMin(ArrayList<Integer> array){
        int min = Integer.MAX_VALUE;
        for (Integer element : array)
            if (element < min) min = element;
        return min;
    }

    public static Integer arrayLimitMax(ArrayList<Integer> array){
        int max = Integer.MIN_VALUE;
        for (Integer element : array)
            if (element > max) max = element;
        return max;
    }

    public static int averageArray(ArrayList<Integer> array, int min, int max){
        int average = (min + max)/2;
        int diff = Integer.MAX_VALUE;
        int averageList = 0;
        for (Integer value : array){
            if (Math.abs(value - average) < diff) {
                diff = Math.abs(value - average);
                averageList = value;
            }
        }
        return averageList;
    }

    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner input = new Scanner(System.in);
        System.out.print("Введите размер списка: ");
        int size = input.nextInt();
        ArrayList<Integer> arrayInteger = new ArrayList<>();
        for (int i=0; i<size; i++)
            arrayInteger.add(rnd.nextInt(1, 100));
        System.out.println("Исходный список: ");
        System.out.println(arrayInteger);
        int maximum = arrayLimitMax(arrayInteger);
        int minimum = arrayLimitMin(arrayInteger);
        System.out.println("Минимальный элемент списка - " + minimum);
        System.out.println("Максимальный элемент списка - " + maximum);
        System.out.printf("Средний элемент списка - %d", averageArray(arrayInteger, minimum, maximum));

    }
}
