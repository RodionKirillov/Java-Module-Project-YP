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

    public String rubEnd() {
        String rub;
        if (sumOrder() < 1) {
            rub = " копеек.";
        } else if (sumOrder() < 2) {
            rub = " рубль.";
        } else {
            rub = " рублей.";
        }
        return rub;
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
            String nameCheck = "Позиция №%d : %s, Цена - %.2f %s.";
            System.out.printf((nameCheck) + "%n", i + 1, name, price, rub);
        }
        double sum = sumOrder() / numOfVisitors;
        String rub2;
        if (sum < 1) {
            rub2 = "копеек";
        } else if (sum < 2) {
            rub2 = "рубль";
        } else {
            rub2 = "рублей";
        }
        System.out.printf("Каждый человек должен заплатить - %.2f %s. %n", sum, rub2);
    }
}