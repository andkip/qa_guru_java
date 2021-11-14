package hw1_2.Sweets;

public class JellyBean extends Gift {

    private final String form;

    public JellyBean(String name, double weight, double price, String form) {
        super(name, weight, price);
        this.form = form;
    }

    @Override
    public String toString() {
        return "Жевательные конфеты: [" + super.toString() + ", Форма: " + form + "]";
    }
}
