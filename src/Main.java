import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> cart = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите номер операции:");
            System.out.println("1. Добавить");
            System.out.println("2. Показать");
            System.out.println("3. Удалить");
            System.out.println("4. Найти");
            int num = Integer.parseInt(scanner.nextLine());
            switch (num) {
                case 1:
                    System.out.println("Какую покупку хотите добавить?");
                    cart.add(scanner.nextLine());
                    System.out.println("Итого в списке покупок:" + cart.size());
                    break;
                case 2:
                    System.out.println("Список покупок:");
                    if (!cart.isEmpty()) {
                        for (String item : cart) {
                            System.out.println((cart.lastIndexOf(item) + 1) + ". " + item);
                        }
                    } else {
                        System.out.println("Пусто");
                    }
                    break;
                case 3:
                    System.out.println("Список покупок:");
                    if (!cart.isEmpty()) {
                        for (String item : cart) {
                            System.out.println((cart.lastIndexOf(item) + 1) + ". " + item);
                        }
                        System.out.println("Какую хотите удалить? Введите номер или название");
                        String delItem = scanner.nextLine();
                        try {
                            int delInput = (Integer.parseInt(delItem) - 1);
                            delItem = cart.get(delInput);
                            cart.remove(delInput);
                        } catch (NumberFormatException exception) {
                            cart.remove(delItem);
                        }
                        System.out.println("Покупка \"" + delItem + "\" удалена, список покупок:");
                        for (String item : cart) {
                            System.out.println((cart.lastIndexOf(item) + 1) + ". " + item);
                        }
                    } else {
                        System.out.println("Пусто");
                    }
                    break;
                case 4:
                    System.out.println("Введите текст для поиска:");
                    String query = (scanner.nextLine()).toLowerCase();
                    for (String item : cart) {
                        String itemLower = item.toLowerCase();
                        if (itemLower.contains(query)) {
                            System.out.println((cart.lastIndexOf(item) + 1) + ". " + item);
                        }
                    }
                    break;
                default:
                    System.out.println("Ошибка. Неверно введён номер операции.");
            }
        }
    }
}