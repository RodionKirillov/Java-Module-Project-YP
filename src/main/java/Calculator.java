import java.util.ArrayList;

public class Calculator {
    ArrayList<Order> check = new ArrayList<>();
    String nameCheck = "Позиция №%d : %s, Цена - %.2f %s.";

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

    public void nameOrder(int numOfVisitors) {
        for (int i = 0; i < check.size(); i++) {
            double price = check.get(i).getPrice();
            String name = check.get(i).getNameOrder();
            String rub;
            if (price < 1) {
                rub = "копеек";
            } else if (price < 2) {
                rub = "рубль";
            } else {
                rub = "рублей";
            }
            System.out.printf((nameCheck) + "%n", i + 1, name, price, rub);
        }
        double sum = sumOrder() / numOfVisitors;
        if (sum < 1) {
            System.out.printf("Каждый человек должен заплатить - %.2f копеек. %n", sum);
        } else if (sum < 2) {
            System.out.printf("Каждый человек должен заплатить - %.2f рубль. %n", sum);
        } else {
            System.out.printf("Каждый человек должен заплатить - %.2f рублей. %n", sum);
        }
    }
}