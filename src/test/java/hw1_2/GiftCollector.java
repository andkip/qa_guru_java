package hw1_2;

import hw1_2.Sweets.*;

public class GiftCollector {
    public static void main(String[] args) {

        double price = 0;
        double weight = 0;

        Candy candy = new Candy("Ананасовые", 3.2, 295, "Джем");
        Chocolate chocolate = new Chocolate("Ritter Sport", 1.5, 190, "Ореховый");
        Gingerbread gingerbread = new Gingerbread("Тульский", 1.4, 170, true);
        JellyBean jellyBean = new JellyBean("Malabar", 0.7, 85, "Мишки");
        Gift[] gift = {candy, chocolate, gingerbread, jellyBean};

        for (Gift value : gift) {
            System.out.println(value.toString());
            price = price + value.getPrice();
            weight = weight + value.getWeight();
        }
        System.out.println("Цена подарка: " + price + " руб");
        System.out.println("Вес подарка: " + weight + " кг");

        System.out.println("Новое поступление конфет - " + GiftSetter.giftSetter());
    }

    public static class GiftSetter {
        public static String giftSetter() {
            Candy candy = new Candy("", 0, 0, "");

            candy.setFilling("Клубничное варенье");
            candy.setName("Конфетос");
            candy.setWeight(2);
            candy.setPrice(90.5);

            return candy.toString();
        }
    }
}