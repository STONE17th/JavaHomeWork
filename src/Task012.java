import java.util.Scanner;
import java.util.Stack;

public class Task012 {

    public static void main(String[] args) {
        boolean trigger = true;
        Stack<Integer> error = new Stack<>();
        Stack<String> stack = new Stack<>();
        String start = "([{<";
        String finish = ")]}>";
        Scanner input = new Scanner(System.in);
        System.out.print("Введите выражение для проверки: ");
        String example = input.next();
        for (int i=0; i<example.length(); i++) {
            String element = Character.toString(example.charAt(i));
//            System.out.println("Текущий " + i + " элемент - " + element);
//            System.out.println("Индекс ошибки - " + index);
            if (trigger) {
                for (int j = 0; j < start.length(); j++) {
                    String startElement = Character.toString(start.charAt(j));
                    String finishElement = Character.toString(finish.charAt(j));
                    if (startElement.equals(element)) {
//                                            System.out.println("Добавляем " + i + " в стек - " + finishElement);
                        stack.add(finishElement);
                        error.add(i);
                    } else if (finishElement.equals(element)) {
                        if (!stack.isEmpty()) {
                            String stackElement = stack.peek();
//                                                    System.out.println("Достаем  " + i + " из стека - " + stackElement);
                            if (element.equals(stackElement)) {
                                stack.pop();
                                error.pop();
//                                                            System.out.println("Удалили из стека");
                            } else {
                                trigger = false;
                                error.add(i);
                                break;
                            }
                        } else {
                            trigger = false;
                            error.add(i);
                            break;
                        }
                    }

                }
            }
        }
        if (!stack.isEmpty()) {
            trigger = false;
            if (error.isEmpty()) error.add(error.size());
        }
        System.out.println("Выражение " + example + (trigger?" - верно":" - Ошибка"));
        String empty = "                                                              ";
        if (!trigger) {
            empty = empty.substring(0, 10 + error.get(error.size()-1)) + "^" + empty.substring(10 + error.get(error.size() - 1), empty.length());
            System.out.println(empty);
        }
    }
}
