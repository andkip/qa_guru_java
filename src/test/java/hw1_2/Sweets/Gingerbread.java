package hw1_2.Sweets;

public class Gingerbread extends Gift {

    private final boolean glaze;

    public Gingerbread(String name, double weight, double price, boolean glaze) {
        super(name, weight, price);
        this.glaze = glaze;
    }

    @Override
    public String toString() {
        return "Пряник: [" + super.toString() + ", Есть ли глазурь: " + glaze + "]";
    }
}
