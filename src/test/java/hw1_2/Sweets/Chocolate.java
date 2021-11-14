package hw1_2.Sweets;

public class Chocolate extends Gift {

    private final String flavour;

    public Chocolate(String name, double weight, double price, String flavour) {
        super(name, weight, price);
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Шоколад: [" + super.toString() + ", Вкус: " + flavour + "]";
    }
}
