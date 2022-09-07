import java.util.ArrayList;
import java.util.Scanner;

public class Task003 {
    public static int triangleNumber(int number){
        if(number==1){return 1;}
        else{return(number + triangleNumber(number-1) );}
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = in.nextInt();
        System.out.printf("%d-е треугольное число = %d", number, triangleNumber(number));
    }
}
