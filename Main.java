import java.util.*;

class Laptop {
    private String model;
    private int ram;
    private int hddCapacity;
    private String os;
    private String color;
    private double price;

    public Laptop(String model, int ram, int hddCapacity, String os, String color, double price) {
        this.model = model;
        this.ram = ram;
        this.hddCapacity = hddCapacity;
        this.os = os;
        this.color = color;
        this.price = price;
    }

    // Геттеры
    public int getRam() { return ram; }
    public int getHddCapacity() { return hddCapacity; }
    public String getOs() { return os; }
    public String getColor() { return color; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "Laptop{" +
                "model='" + model + '\'' +
                ", ram=" + ram +
                ", hddCapacity=" + hddCapacity +
                ", os='" + os + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}

class LaptopStore {
    private Set<Laptop> laptops;

    public LaptopStore() {
        laptops = new HashSet<>();
    }

    public void addLaptop(Laptop laptop) {
        laptops.add(laptop);
    }

    public void filterLaptops() {
        Map<String, Object> filters = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите цифру, соответствующую необходимому критерию:");
            System.out.println("1 - ОЗУ");
            System.out.println("2 - Объем ЖД");
            System.out.println("3 - Операционная система");
            System.out.println("4 - Цвет");
            System.out.println("5 - Цена");
            System.out.println("0 - Завершить ввод");

            int choice = scanner.nextInt();
            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.println("Введите минимальный объем ОЗУ:");
                    filters.put("ram", scanner.nextInt());
                    break;
                case 2:
                    System.out.println("Введите минимальный объем ЖД:");
                    filters.put("hddCapacity", scanner.nextInt());
                    break;
                case 3:
                    System.out.println("Введите операционную систему:");
                    filters.put("os", scanner.next());
                    break;
                case 4:
                    System.out.println("Введите цвет:");
                    filters.put("color", scanner.next());
                    break;
                case 5:
                    System.out.println("Введите максимальную цену:");
                    filters.put("price", scanner.nextDouble());
                    break;
            }
        }

        Set<Laptop> filteredLaptops = new HashSet<>(laptops);
        for (Laptop laptop : laptops) {
            if (filters.containsKey("ram") && laptop.getRam() < (int) filters.get("ram")) {
                filteredLaptops.remove(laptop);
            }
            if (filters.containsKey("hddCapacity") && laptop.getHddCapacity() < (int) filters.get("hddCapacity")) {
                filteredLaptops.remove(laptop);
            }
            if (filters.containsKey("os") && !laptop.getOs().equalsIgnoreCase((String) filters.get("os"))) {
                filteredLaptops.remove(laptop);
            }
            if (filters.containsKey("color") && !laptop.getColor().equalsIgnoreCase((String) filters.get("color"))) {
                filteredLaptops.remove(laptop);
            }
            if (filters.containsKey("price") && laptop.getPrice() > (double) filters.get("price")) {
                filteredLaptops.remove(laptop);
            }
        }

        System.out.println("Отфильтрованные ноутбуки:");
        for (Laptop laptop : filteredLaptops) {
            System.out.println(laptop);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LaptopStore store = new LaptopStore();

        store.addLaptop(new Laptop("Model1", 8, 512, "Windows", "Black", 999.99));
        store.addLaptop(new Laptop("Model2", 16, 1024, "MacOS", "Silver", 1499.99));
        store.addLaptop(new Laptop("Model3", 4, 256, "Linux", "Red", 599.99));
        store.addLaptop(new Laptop("Model4", 32, 2048, "Windows", "White", 1999.99));

        store.filterLaptops();
    }
}