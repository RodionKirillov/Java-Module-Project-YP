import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        int numOfVisitors;
        String exit = "Завершить";

        while (true) {
            System.out.println("На скольких человек необходимо разделить счёт?");
            if (scanner.hasNextInt()) {
                numOfVisitors = scanner.nextInt();
                if (numOfVisitors < 1) {
                    System.out.println("Это некорректное значение для подсчёта.");
                } else if (numOfVisitors == 1) {
                    System.out.println("Нет смысла делить счёт на одного человека.");
                } else {
                    break;
                }
            } else {
                System.out.println("Введите число.");
                scanner.next();
            }
        }

        while (true) {
            System.out.println("Введите название товара");
            Order order = new Order();
            order.setNameOrder(scanner.next());

            System.out.println("Введите стоимость товара");
            do {
                if (scanner.hasNextDouble()) {
                    double price = scanner.nextDouble();
                    if (price > 0) {
                        order.setPrice(price);
                        calculator.add(order);
                        System.out.println("Товар успешно добавлен");
                        System.out.println(
                                "Общая сумма всех товаров: "
                                        + calculator.sumOrder()
                                        + calculator.rubEnd()
                        );
                        break;
                    } else {
                        System.out.println("Ошибка. Введите положительное число.");
                    }
                } else {
                    System.out.println("Ошибка. Введите сумму.");
                    scanner.next();
                }
            } while (true);

            System.out.println("Хотите добавить ещё товар?");
            String stop = scanner.next().trim();
            if (stop.equalsIgnoreCase(exit)) {
                System.out.println("Добавленные товары:  ");
                calculator.nameOrder(numOfVisitors);
                scanner.close();
                break;
            }
        }
    }
}