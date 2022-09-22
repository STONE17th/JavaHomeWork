public class Task017 {

    public static int searchIndex(int[] array) {
        int size = array.length;
        for (int i = 1; i < size - 1; i++) {
            int summFirst = 0;
            int summSecond = 0;
            for (int k = 0; k < i; k++)
                summFirst += array[k];
            for (int l = i + 1; l < size; l++)
                summSecond += array[l];
            if (summFirst == summSecond)
                return i;
        }
        return 0;
    }

    public static void printArray(int[] array, int start, int finish, String end) {
        for (int i = start; i < finish; i++) {
            if (i != finish - 1)
                System.out.printf("%d, ", array[i]);
            else if (end.equals("end"))
                System.out.printf("%d\n", array[i]);
            else
                System.out.printf("%d", array[i]);
        }
    }


    public static void main(String[] args) {
        int[] nums = {9, 7, 3, 6, 4, 6};
        int index = searchIndex(nums);
        System.out.print("Исходный массив - ");
        printArray(nums, 0, nums.length, "end");
        if (index > 0) {
            System.out.printf("Сумма чисел (");
            printArray(nums, 0, index, " ");
            System.out.printf(") до элемента %d (индекс %d) равна сумме чисел после этого индекса (", nums[index], index);
            printArray(nums, index + 1, nums.length, " ");
            System.out.println(")");
        } else
            System.out.println("Такого индекса в данном массиве нет");
    }
}
