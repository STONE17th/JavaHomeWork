import java.util.ArrayList;

public class Task016 {

    public static class Stack<T>{
        ArrayList<Object> list;

        public Stack() {
            this.list = new ArrayList<>();
        }

        public boolean isEmpty(){
            return this.list.size() == 0;
        }

        public void push(Object object){
            this.list.add(0, object);
        }
        public Object pop(){
            Object temp = this.list.get(0);
            this.list.remove(0);
            return temp;
        }

        public int size(){
            return this.list.size();
        }

        public StringBuilder print(){
            StringBuilder list = new StringBuilder();
            for (Object element : this.list)
                list.append(element + " ");
            return list;
        }
    }


    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("string 1");
        stack.push("string 2");
        stack.push("string 3");
        stack.push("string 4");
        stack.push("string 5");
        System.out.println(stack.size());
        System.out.println(stack.print());
        Object element = stack.pop();
        System.out.println(element);
        System.out.println(stack.print());

    }
}
