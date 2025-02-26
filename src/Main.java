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
    }
}