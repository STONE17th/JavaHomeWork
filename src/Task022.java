import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task022 {
    public static ArrayList<Integer> removeEven(ArrayList<Integer> array){
        int size = array.size();
        ArrayList<Integer> newArray = new ArrayList<>();
        for (Integer value : array) {
            if (value % 2 != 0) newArray.add(value);
        }
        return newArray;
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
        System.out.println("После удаления четных элементов: ");
        removeEven(arrayInteger);
        System.out.println(removeEven(arrayInteger));
    }
}