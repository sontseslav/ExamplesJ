import static java.util.Arrays.*;
import java.util.Random;
import java.util.function.*;

@FunctionalInterface
interface Square {
    int calculate(int x);
    default void newMethod(){
        System.out.println("New feature in default method");
    }
}

public class FuncInterface {

    public static void main(String[] args) {
        int a = 5;
        Square result = (int x) -> x * x;

        System.out.println(result.calculate(a));
        result.newMethod();

        // Predicate
        int[] arr = new int[10];
        fill(arr, new Random().nextInt(5000));
        // System.out.printf("%.3f", new Double(arr[5]));
        Predicate<Integer> predicate = (Integer x) -> x % 2 == 0;
        for (int element: arr) {
            if (predicate.test(element)) System.out.printf("%d, ", element);
        }
        System.out.printf("\n");

        // BinaryOperator
        BinaryOperator<Double> multiplier = (Double x, Double y) -> Math.pow(x, y);
        System.out.println(multiplier.apply(Double.valueOf(5), 2.0));

        // Function
        Function<Integer, Double> int2double = (Integer x) -> new Double(x) + 1;
        System.out.printf("Function returns %.2f\n", int2double.apply(12));
        System.out.printf("Function divides %.4f\n", int2double.andThen(x -> x / 8).apply(12)); // runs Function, after - andThen
        System.out.printf("Function composes %.4f\n", int2double.compose((Integer x) -> x / 8).apply(16)); // runs compose - after Function
    }
}
