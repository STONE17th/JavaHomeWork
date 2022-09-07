import java.util.ArrayList;

public class Task002 {

    static ArrayList<String> allRoutes = new ArrayList<>();

    static void runFunc(int a, int b, int c, int d, String way) {
        if (a == b) {
            allRoutes.add(way);
        }
        if (a < b) {
            runFunc(a * c, b, c, d, way + "*" + c + " ");
            runFunc(a + d, b, c, d, way + "+" + d + " ");
        }
    }

    static String minWay(ArrayList<String> arr) {

        String minWay = arr.get(0);

        for (String elem : arr) {

            if (elem.length() < minWay.length()) minWay = elem;

        }
        return minWay;
    }

    public static void main(String[] args) {

        int a = 6;
        int b = 78;
        int c = 3;
        int d = 5;
        runFunc(a, b, c, d, a + " ");

        if (allRoutes.isEmpty())
            System.out.println("Решений нет!");
        else {

            StringBuilder route = new StringBuilder();

            route.append("Все варианты решений:\n\n");

            for (String elem : allRoutes) {

                route.append(elem).append(" = ").append(b);
                route.append("\n");

            }

            route.append("\n");

            route.append("Самое быстрое решение:\n\n");
            route.append(minWay(allRoutes));
            System.out.println(route + " = " + b);
        }
    }
}