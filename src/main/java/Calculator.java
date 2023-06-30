import java.util.ArrayList;

public class Calculator {
    private final ArrayList<Order> check = new ArrayList<>();

    public void add(Order order) {
        check.add(order);
    }

    public double sumOrder() {
        double sum = 0;
        for (Order order : check) {
            sum += order.getPrice();
        }
        return sum;

    }

    public String rubEnd(double num) {
        int lastNum = (int) num % 10;
        int lastTwoNum = (int) num % 100;


        if (lastTwoNum >= 11 && lastTwoNum <= 19) {
            return " рублей.";
        } else if (lastNum == 1) {
            return " рубль.";
        } else if (lastNum >= 2 && lastNum <= 4) {
            return " рубля.";
        } else {
            return " рублей.";
        }

    }

    public void nameOrder(int numOfVisitors) {
        for (int i = 0; i < check.size(); i++) {
            double price = check.get(i).getPrice();
            String name = check.get(i).getNameOrder();
            String nameCheck = "Позиция №%d : %s, Цена - %.2f %s";
            System.out.printf((nameCheck) + "%n", i + 1, name, price, rubEnd(price));
        }
        double sum = sumOrder() / numOfVisitors;
        System.out.printf("Каждый человек должен заплатить - %.2f %s %n", sum, rubEnd(sum));
    }
}