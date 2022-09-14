import java.util.Scanner;

public class Task006 {

    public static void Divine(int[] original) {
        if (original.length <= 1)
            return;
        int middleIndex = original.length / 2;
        int[] first = new int[middleIndex];
        int[] second = new int[original.length - middleIndex];

        for (int i = 0; i < middleIndex; i++)
            first[i]=original[i];
        for (int i=middleIndex; i<original.length; i++)
            second[i - middleIndex] = original[i];

        Divine(first);
        Divine(second);
        Merge(original, first, second);
    }

    public static void Merge(int[] original, int[] first, int[] second){
        int firstIndex = 0;
        int secondIndex = 0;
        int originalIndex = 0;
        while(firstIndex < first.length && secondIndex < second.length) {
            if (first[firstIndex] <= second[secondIndex]) {
                original[originalIndex] = first[firstIndex];
                firstIndex++;
            } else {
                original[originalIndex] = second[secondIndex];
                secondIndex++;
            }
            originalIndex++;
        }
        while (firstIndex<first.length){
            original[originalIndex] = first[firstIndex];
            firstIndex++;
            originalIndex++;
        }
        while (secondIndex<second.length){
            original[originalIndex] = second[secondIndex];
            secondIndex++;
            originalIndex++;
        }
    }
    public static void print(int[] array, String text){
        System.out.println(text);
        for (int element: array)
            System.out.print(element + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите элементы массива через пробел: ");
        String rawInput = input.nextLine();
        String[] array = rawInput.split(" ");
        int[] original = new int[array.length];
        for (int i=0; i<original.length; i++)
            original[i] = (Integer.parseInt(array[i]));
        print(original, "Исходный массив:");
        Divine(original);
        print(original, "Отсортированный массив:");

    }
}
