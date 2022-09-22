import java.util.ArrayList;

public class Task018 {

    public static String printString(int count, String prefix){
        return String.valueOf(prefix).repeat(Math.max(0, count));
    }

    public static void printArray(String[] array){
        int size = array.length;
        for (int i=0; i<size; i++) {
            if (i != size-1)
                System.out.print(array[i] + ", ");
            else
                System.out.print(array[i] + "\n");
        }
    }

    public static void main(String[] args) throws Exception {
        String[] array = {"aabb", "aaaabbb", "abb", "aaabbbbb"};
        ArrayList<Integer> prefixList = new ArrayList<>();
        String prefix = "";
        for (String word: array) {
            int count = 1;
            int size = word.length();
            for (int i = 0; i < size - 1; i++) {
                Character first = word.charAt(i);
                Character second = word.charAt(i+1);
                prefix = Character.toString(first);
                if (first.equals(second))
                    count++;
                else break;
            }
            prefixList.add(count);
        }
        int minimumCount = Integer.MAX_VALUE;
        for (Integer prefixCount : prefixList) if (prefixCount < minimumCount) minimumCount = prefixCount;
        printArray(array);
        System.out.printf("Минимальный префикс %s", printString(minimumCount, prefix));
    }
}
