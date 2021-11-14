package hw1_2.Sweets;

public class Gingerbread extends Gift {

    private final boolean hasGlaze;

    public Gingerbread(String name, double weight, double price, boolean hasGlaze) {
        super(name, weight, price);
        this.hasGlaze = hasGlaze;
    }

    @Override
    public String toString() {
        return "Пряник: [" + super.toString() + ", Есть ли глазурь: " + hasGlaze + "]";
    }
}
