package homework60;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AlkoAppl {
    record  Alcohol (String title, double strength, double price) {
        @Override
        public String title() {
            return title;
        }

        @Override
        public double strength() {
            return strength;
        }

        @Override
        public double price() {
            return price;
        }
    };
    /*
    Задание 1 ⭐⭐
    Получите LinkedList из топ 3 самых дорогих товаров.

    Задание 2 ⭐⭐
    Получите самый дешевый товар

    Задание 3 ⭐⭐
    Создайте Set из исходного листа.

    Задание 4 ⭐⭐⭐
    Создайте Map из исходного листа, в котором ключами будут - названия товаров, а значениями будут цены.

    Задание 5 ⭐⭐⭐
    Создайте Map из исходного листа, в котором ключами будут - названия товаров, а значениям будет крепость.
    */
    public static void main(String[] args) {

        List<Alcohol> vinesAndSpirits = List.of(
                new Alcohol("Carlos I, Solera Gran Reserva", 40.0, 24.9),
                new Alcohol("Gran Duque de Alba XO", 40.0, 54.9),
                new Alcohol("Remy Martin VSOP", 40.0, 44.9),
                new Alcohol("Remy Martin VSOP", 40.0, 44.9),
                new Alcohol("Louis Jadot Bourgogne Pinot Noir", 12.81, 18.7),
                new Alcohol("Carlos I, Solera Gran Reserva", 40.0, 24.9),
                new Alcohol("Coto de Imaz Reserva 2018", 13.5, 8.5)
        );

//        Задание 1. Получите LinkedList из топ 3 самых дорогих товаров.

        LinkedList<Alcohol> topThreeByPrice = vinesAndSpirits.stream()
                .sorted((a, b) -> Double.compare(b.price(), a.price()))
                .distinct()
                .limit(3)
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(topThreeByPrice);

        System.out.println("--------------------------------------------------------------");

//        Задание 2. Получите самый дешевый товар.

        Optional<Alcohol> cheapest = vinesAndSpirits.stream()
                .min(Comparator.comparingDouble(Alcohol::price));
        System.out.println(cheapest);

        System.out.println("--------------------------------------------------------------");

//        Задание 3. Создайте Set из исходного листа.

        Set<Alcohol> alkoSet =  vinesAndSpirits.stream()
                .collect(Collectors.toSet());
        System.out.println(alkoSet);

        System.out.println("--------------------------------------------------------------");

//        Задание 4. Создайте Map из исходного листа, в котором ключами будут - названия товаров, а значениями будут цены.

        Map<String, Double> alkoMapPrc = vinesAndSpirits.stream()
                .distinct()
                .collect(Collectors
                        .toMap(Alcohol::title, Alcohol::price));
        System.out.println(alkoMapPrc);

        System.out.println("--------------------------------------------------------------");

//        Задание 5. Создайте Map из исходного листа, в котором ключами будут - названия товаров, а значениями будет
//        крепость.

        Map<String, Double> alkoMapStr = vinesAndSpirits.stream()
                .distinct()
                .collect(Collectors
                        .toMap(Alcohol::title, Alcohol::strength));
        System.out.println(alkoMapStr);

    }
}
