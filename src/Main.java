import java.util.*;
import java.util.stream.Collectors;

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
        System.out.println();
//        Задача 4

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        long minors = persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.println("Количество несовершеннолетних: " + minors);

        List<String> conscripts = persons.stream()
                .filter(person -> person.getSex() == Sex.MAN)
                .filter(person -> person.getAge() >= 18 && person.getAge() <= 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());
//        System.out.println("Список фамилий призывников: " + conscripts);
        List<Person> employables = persons.stream()
                .filter(person -> person.getEducation() == Education.HIGHER)
                .filter(person -> {
                    if (person.getSex() == Sex.WOMAN) {
                        return person.getAge() >= 18 && person.getAge() <= 60;
                    } else {
                        return person.getAge() >= 18 && person.getAge() <= 65;
                    }
                })
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
//        System.out.println("Список потенциально работоспособных людей с высшим образованием: " + employables);
    }
}

