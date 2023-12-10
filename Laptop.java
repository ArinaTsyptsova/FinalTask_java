public class Laptop {
    private String model;
    private int ram;
    private int hddSize;
    private String os;
    private String color;

    public Laptop(String model, int ram, int hddSize, String os, String color) {
        this.model = model;
        this.ram = ram;
        this.hddSize = hddSize;
        this.os = os;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getHddSize() {
        return hddSize;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Ноутбук [Бренд: " + model + ", ОЗУ: " + ram + ", Размер ЖД: " + hddSize + ", ОС: " + os + " Цвет: "
                + color + "]";
    }
}