import java.util.*;

public class Stock {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();

        laptops.add(new Laptop("MSI", 8, 1000, "Windows", "Black"));
        laptops.add(new Laptop("Lenovo", 4, 512, "FreeBSD", "Grey"));
        laptops.add(new Laptop("Apple", 16, 1000, "macOS", "White"));
        laptops.add(new Laptop("Asus", 8, 2000, "Windows", "Red"));
        laptops.add(new Laptop("Dell", 32, 2000, "Linux", "Black"));

        getChoiceLaptops(laptops);
    }

    public static void getChoiceLaptops(Set<Laptop> laptops) {

        Map<String, String> condition = new HashMap<>();
        condition.put("1", "ОЗУ");
        condition.put("2", "Размер ЖД");
        condition.put("3", "ОС");
        condition.put("4", "Цвет");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите цифру, соответствующую нужному условию: ");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Размер ЖД");
        System.out.println("3 - ОС");
        System.out.println("4 - Цвет");
        String inputText = scanner.nextLine();

        if (condition.containsKey(inputText)) {
            String currentCondition = condition.get(inputText);
            System.out.println("Введите минимальное значение для " + currentCondition);
            String minValue = scanner.nextLine();

            Set<Laptop> filteredLaptops = new HashSet<>();
            switch (currentCondition) {
                case "ОЗУ":
                    int minRam = Integer.parseInt(minValue);
                    for (Laptop laptop : laptops) {
                        if (laptop.getRam() >= minRam) {
                            filteredLaptops.add(laptop);
                        }
                    }
                    break;

                case "Размер ЖД":
                    int minHddSize = Integer.parseInt(minValue);
                    for (Laptop laptop : laptops) {
                        if (laptop.getHddSize() >= minHddSize) {
                            filteredLaptops.add(laptop);
                        }
                    }
                    break;

                case "ОС":
                    for (Laptop laptop : laptops) {
                        if (laptop.getOs().equalsIgnoreCase(minValue)) {
                            filteredLaptops.add(laptop);
                        }
                    }
                    break;

                case "Цвет":
                    for (Laptop laptop : laptops) {
                        if (laptop.getColor().equalsIgnoreCase(minValue)) {
                            filteredLaptops.add(laptop);
                        }
                    }
                    break;

                default:
                    System.out.println("Условие введено некорректно!");
                    return;
            }

            if (filteredLaptops.isEmpty()) {
                System.out.println("К сожалению, ноутбков по Вашим условиям нет на складе");
            } else {
                for (Laptop laptop : filteredLaptops) {
                    System.out.println(laptop);
                }
            }
        } else {
            System.out.println("Некорректный ввод условия! Пожалуйста, повторите ввод снова");
        }
    }
}