package hw1_2.Sweets;

public abstract class Gift {
    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private String name;
    private double weight;
    private double price;

    public Gift(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Название: " + name + ", Цена: " + price + ", Вес: " + weight;
    }
}
