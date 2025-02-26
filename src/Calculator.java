import java.util.function.*;

class Calculator {
    public static Supplier<Calculator> instance = Calculator::new;

    public BinaryOperator<Integer> plus = (x, y) -> x + y;
    public BinaryOperator<Integer> minus = (x, y) -> x - y;
    public BinaryOperator<Integer> multiply = (x, y) -> x * y;
    public BinaryOperator<Integer> devide = (x, y) -> {
        if (y == 0) {
//            Если делитель равен 0, то выбрасываем исключение
//            с сообщением "Делить на ноль нельзя!"
            throw new ArithmeticException("Делить на ноль нельзя!");
        }
        return x / y;
    };

    public UnaryOperator<Integer> pow = x -> x * x;
    public UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    public Predicate<Integer> isPositive = x -> x > 0;

    public Consumer<Integer> println = System.out::println;
}