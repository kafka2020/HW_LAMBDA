import java.util.*;

public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);

        calc.println.accept(a);
        calc.println.accept(b);

        try {
//            если b равно нулю, это приведет к исключению ArithmeticException,
//            так как деление на ноль в Java недопустимо.
            int c = calc.devide.apply(a, b);
            calc.println.accept(c);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

//        Задача 2

        OnTaskDoneListener listener = System.out::println;

        Worker worker = new Worker(listener);
        worker.start();

//        Задача 3

        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> targetList = new ArrayList<>();
        for (int i : intList) {
            if (i > 0 && (i % 2) == 0) {
                targetList.add(i);
            }
        }
        Collections.sort(targetList);
        for (int i : targetList) {
            System.out.print(i + " ");
        }
    }
}

